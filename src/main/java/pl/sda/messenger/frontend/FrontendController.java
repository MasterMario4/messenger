package pl.sda.messenger.frontend;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.messenger.services.MessageService;
import pl.sda.messenger.services.UsernameService;

@Log
@RequiredArgsConstructor
@Controller
public class FrontendController {
    private final UsernameService usernameService;
    private final MessageService messageService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("allMessages", messageService.readAllPublicMessages());
        model.addAttribute("username", usernameService.getUsername());
        return "index";
    }
}
