package pl.almatron.funwar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * funwar
 * @author macvek
 */
@Controller
public class FunController {
    
    @RequestMapping("*")
    public String helloClient() {
        return "helloClient";
    }
}
