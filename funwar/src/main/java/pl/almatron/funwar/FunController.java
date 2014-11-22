package pl.almatron.funwar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * funwar
 * @author macvek
 */
@Controller
public class FunController {
    
    @RequestMapping("/")
    public ModelAndView helloClientHandler() {
        return new ModelAndView("helloClient");
    }
}
