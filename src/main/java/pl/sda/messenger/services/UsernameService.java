package pl.sda.messenger.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.*;
import java.util.stream.Collectors;

@Service
@SessionScope
public class UsernameService {
    private static final Random RANDOM = new Random();
    private static final String[] NAMES = {"kot", "pies", "chomik", "koń", "krowa", "kura", "indyk", "kogut", "świnia",
            "słoń", "żyrafa", "tygrys", "lew", "mrówka", "pająk", "mysz polna", "jaszczurka", "żmija", "wąż", "zając",
            "dzik", "królik", "wiewiórka", "żaba", "sarna", "jeleń", "pantera", "kuna", "małpa", "goryl", "hipopotam",
            "niedźwiedź", "krokodyl", "borsuk", "wilk", "lis", "fretka", "surykatka", "panda", "jeż", "jeżozwierz",
            "hiena", "leniwiec", "zebra", "kameleon", "łoś", "lama", "jastrząb", "jaskółka,sowa", "wrona", "gawron",
            "bocian biały", "bocian czarny", "jemiołuszka", "dzięcioł", "kawka", "wróbel", "sikorka bogatka", "papuga",
            "wieloryb", "delfin", "mors", "żółw", "bóbr", "foka", "czapla", "pingwin"};

    private static final List<String> availableUserNames = new LinkedList<>();
    private static int lastGeneratedIndex = 0;


    private String username = null;

    public String getUsername() {
        if (username == null) {
            username = generateNewUsername();
        }
        return username;
    }

    private String generateNewUsername() {
        if (availableUserNames.size() == 0) {
            lastGeneratedIndex++;
            availableUserNames.addAll(Arrays.stream(NAMES)
                    .map(name -> name.substring(0, 1).toUpperCase() + name.substring(1) +
                            (lastGeneratedIndex == 1 ? "" : (" " + lastGeneratedIndex)))
                    .collect(Collectors.toSet()));
        }

        final int randomIndex = RANDOM.nextInt(availableUserNames.size());
        return availableUserNames.remove(randomIndex);
    }
}
