package pl.sda.messenger.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class FrontendController {

    @GetMapping("/")
    public String index(final Model model){
        model.addAttribute("time", LocalTime.now());
        return "index";
    }
}
