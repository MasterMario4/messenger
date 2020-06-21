package pl.sda.messenger.model;

import lombok.Data;

import java.util.Random;

@Data
public class User {
    private final String name;
    private final String colorCode;


    public User(final String name) {
        this.name = name;
        final Random r = new Random(this.name.hashCode());
        int rand_num = r.nextInt(0xffffff + 1);
        this.colorCode = String.format("#%06x", rand_num);
    }
}
