package pl.sda.messenger.frontend;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.messenger.frontend.dto.SendMessageDto;
import pl.sda.messenger.model.Message;
import pl.sda.messenger.services.MessageService;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Controller
@RequiredArgsConstructor
public class FrontendController {
    private static final DateTimeFormatter FORMATTER_TIMESTAMP = DateTimeFormatter.ofPattern("hh:mm:ss");
    private final MessageService messageService;


    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("allMessages", convertMessagesToText(messageService.readAllMessages()));
        model.addAttribute("newMessage", new SendMessageDto());
        return "index";
    }

    private List<String> convertMessagesToText(final List<Message> messages) {
        return messages.stream()
                .map(m -> m.getTimestamp().format(FORMATTER_TIMESTAMP) + " " + m.getUsername() + " " + m.getMessage())
                .collect(Collectors.toList());
    }

    @PostMapping("/")
    public String receiveMessage(final Model model, @ModelAttribute SendMessageDto messageDto) {
        log.info("Message received: " + messageDto);
        messageService.postPublicMessage(messageDto);
        return "redirect:";
    }
}
