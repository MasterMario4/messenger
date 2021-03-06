package pl.sda.messenger.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class Message {
    private static final DateTimeFormatter FORMATTER_TIMESTAMP =
            DateTimeFormatter.ofPattern("HH:mm:ss");

    private final String text;
    private final LocalDateTime timestamp;
    private final User user;

    public String getHumanReadableTimestamp() {
        return timestamp.format(FORMATTER_TIMESTAMP);
    }
}
