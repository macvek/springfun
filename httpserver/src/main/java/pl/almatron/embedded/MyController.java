package pl.almatron.embedded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    
    @RequestMapping(method = RequestMethod.GET)
    public String getIt() {
        if (--timesToKill == 0) {
            killServer.kill();
            return "Server killed";
        }
        else {
            return "Left_times_"+timesToKill;
        }
    }
}
