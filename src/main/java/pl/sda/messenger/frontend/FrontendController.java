package pl.sda.messenger.frontend;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.messenger.frontend.dto.SendMessageDto;

import java.time.LocalTime;

@Log
@Controller
public class FrontendController {

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("time", LocalTime.now());
        model.addAttribute("newMessage", new SendMessageDto());
        return "index";
    }

    @PostMapping("/")
    public String receiveMessage(final Model model, @ModelAttribute SendMessageDto messageDto) {
        log.info("Message received: " + messageDto);

        return "redirect:";
    }
}
