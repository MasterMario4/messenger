package pl.sda.messenger.frontend;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import pl.sda.messenger.frontend.dto.SendMessageDto;
import pl.sda.messenger.model.Message;
import pl.sda.messenger.services.MessageService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @MessageMapping("/publishMessage")
    @SendTo("/topic/allMessages")
    public Message publishMessage(SendMessageDto messageDto) throws Exception {
        return messageService.postPublicMessage(messageDto);
    }

}