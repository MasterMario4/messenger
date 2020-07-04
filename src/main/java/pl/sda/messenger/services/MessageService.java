package pl.sda.messenger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.messenger.frontend.dto.SendMessageDto;
import pl.sda.messenger.model.Message;
import pl.sda.messenger.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final List<Message> allMessages = new ArrayList<>();

    public Message postPublicMessage(SendMessageDto messageDto) {
        Message msg = new Message(messageDto.getText(), LocalDateTime.now(), new User(messageDto.getUsername()));
        allMessages.add(msg);
        return msg;
    }

    public List<Message> readAllPublicMessages() {
        return allMessages;
    }
}
