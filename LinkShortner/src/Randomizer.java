package LinkShortner.src;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

public class Randomizer {
    public String nextString() {
        for (int idx = 0; idx < buf.length; ++idx)
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }

    public static final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String lower = "abcdefghijklmnopqrstuvwxyz";
    public static final String digit = "0123456789";
    public static final String alphanum = upper + lower + digit;

    private final Random random;
    private final char[] symbols;
    private final char[] buf;

    public Randomizer(int length, Random random, String symbols) {
        if (symbols.length() < 2) throw new IllegalArgumentException();
        this.random = Objects.requireNonNull(random);
        this.symbols = symbols.toCharArray();
        this.buf = new char[length];

    }

    public Randomizer(int length, Random random) {
        this(length, random, alphanum);
    }

    public Randomizer(int length) {
        this(length, new SecureRandom());
    }

}
