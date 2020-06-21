package pl.sda.messenger;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Log
@Component
public class MyStartupRunner implements CommandLineRunner {
    @Override
    public void run(final String... args) throws Exception {
        log.info("cześć");
    }
}
