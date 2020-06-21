package pl.sda.messenger.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private static final DateTimeFormatter FORMATTER_TIMESTAMP = DateTimeFormatter.ofPattern("hh:mm:ss");

    private String message;
    private LocalDateTime timestamp;
    private User user;

    public String getHumanReadableTimestamp(){
        return timestamp.format(FORMATTER_TIMESTAMP);
    }
}
