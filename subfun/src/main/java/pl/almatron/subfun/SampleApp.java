package pl.almatron.subfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * subfun
 *
 * @author macvek
 */
public class SampleApp {

    public static void main(String... args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"sampleconfig.xml"});

        Sample sample = context.getBean("sampleBean", Sample.class);
        System.out.println(sample.getRef().getValue());
        
    }
}
