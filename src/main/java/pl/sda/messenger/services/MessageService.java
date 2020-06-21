package pl.sda.messenger.services;

import org.springframework.stereotype.Service;
import pl.sda.messenger.frontend.dto.SendMessageDto;
import pl.sda.messenger.model.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private final List<Message> allMessages = new ArrayList<>();

    public List<Message> readAllMessages(){
        return allMessages;
    }

    public void postPublicMessage(final SendMessageDto messageDto){
        allMessages.add(new Message(messageDto.getMessage(), LocalDateTime.now()));
    }
}
