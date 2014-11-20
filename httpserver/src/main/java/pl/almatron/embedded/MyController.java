package pl.almatron.embedded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

/**
 * httpserver
 *
 * @author macvek
 */
@Controller
@RequestMapping("/")
public class MyController {

    @Autowired
    private KillServer killServer;
    
    private int timesToKill = 3;
    
    @RequestMapping(value="killserver")
    @ResponseBody
    public String killServer() {
        if (--timesToKill == 0) {
            killServer.kill();
            return "Server killed";
        }
        else {
            return "<h1>times left "+timesToKill+"</h1><br/><a href=\"killserver\">Try again!</a>";
        }
    }
    
    @RequestMapping("/")
    @ResponseBody
    public String actionWelcome() {
        return "<h1>welcome</h1><br/><a href=\"killserver\">Server killer</a>";
    }
}
