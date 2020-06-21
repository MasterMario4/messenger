package pl.sda.messenger.frontend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.messenger.model.Message;


@Data
@NoArgsConstructor
public class SendMessageDto {
    private String message;
}
