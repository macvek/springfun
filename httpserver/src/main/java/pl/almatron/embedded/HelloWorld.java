package pl.almatron.embedded;
import java.io.IOException;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorld {

    static Server server;
    
    public static void main(String[] args) throws Exception {
        server = new Server(8080);
        setupContextHandler();
        
        server.setDumpAfterStart(true);
        server.setDumpBeforeStop(true);
        server.setStopAtShutdown(true);
        
        server.start();
        server.join();
    }

    private static void setupContextHandler() throws IOException {
        XmlWebApplicationContext webContext = new XmlWebApplicationContext();

        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath("/");
        contextHandler.addServlet(new ServletHolder(new DispatcherServlet(webContext)), "/*");
        contextHandler.addEventListener(new ContextLoaderListener(webContext));
        contextHandler.setResourceBase(new ClassPathResource("/").getURI().toString());
        
        server.setHandler(contextHandler);
    }

    
}