package com.backend.practice.dump.security;//package com.backend.practice.util.security;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.apache.commons.lang3.Validate;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.bouncycastle.jcajce.provider.digest.SHA3;
//import org.springframework.stereotype.Component;
//
//import java.io.Serial;
//import java.io.Serializable;
//import java.nio.charset.StandardCharsets;
//import java.security.SecureRandom;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//@Component
//public final class Passwords implements IPasswords, Serializable {
//
//    @Serial
//    private static final long serialVersionUID = 12052004L;
//    private static final Logger LOGGER = LogManager.getLogger(Passwords.class);
//    private static final Random RANDOM = new SecureRandom();
//    private static final int DEFAULT_SIZE = 64;
//    private static final char[] symbols;
//
//    static {
//        final StringBuilder tmp = new StringBuilder();
//
//        for (char ch = '0'; ch <= '9'; ++ch) {
//            tmp.append(ch);
//        }
//        for (char ch = 'a'; ch <= 'z'; ++ch) {
//            tmp.append(ch);
//        }
//        symbols = tmp.toString().toCharArray();
//    }
//
//    @Override
//    public byte[] getSalt64() {
//        return getSalt(DEFAULT_SIZE);
//    }
//
//    @Override
//    public byte[] getSalt32() {
//        return getSalt(32);
//    }
//
//    @Override
//    public byte[] getSalt(int size) {
//
//        final byte[] salt;
//
//        if (size < 32) {
//            final String message = String.format("Size < 32, using default of: %d", DEFAULT_SIZE);
//            LOGGER.warn(message);
//            salt = new byte[DEFAULT_SIZE];
//        } else {
//            salt = new byte[size];
//        }
//
//        RANDOM.nextBytes(salt);
//
//        return salt;
//    }
//
//    @Override
//    public byte[] hash(String password, byte[] salt) {
//
//        Validate.notNull(password, "Password must not be null");
//        Validate.notNull(salt, "Salt must not be null");
//
//        final byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
//        final byte[] all = ArrayUtils.addAll(passwordBytes, salt);
//
//        SHA3.DigestSHA3 md = new SHA3.Digest512();
//        md.update(all);
//
//        return md.digest();
//    }
//
//    @Override
//    public boolean isExpectedPassword(final String password, final byte[] salt, final byte[] hash) {
//
//        Validate.notNull(password, "Password must not be null");
//        Validate.notNull(salt, "Salt must not be null");
//        Validate.notNull(hash, "Hash must not be null");
//
//        final byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
//        final byte[] all = ArrayUtils.addAll(passwordBytes, salt);
//
//        SHA3.DigestSHA3 md = new SHA3.Digest512();
//        md.update(all);
//
//        final byte[] digest = md.digest();
//
//        return Arrays.equals(digest, hash);
//    }
//
//    @Override
//    public String generateRandomPassword(final int length) {
//
//        if (length < 1) {
//            throw new IllegalArgumentException("length must be greater than 0");
//        }
//
//        final char[] buf = new char[length];
//
//        for (int idx = 0; idx < buf.length; ++idx) {
//            buf[idx] = symbols[RANDOM.nextInt(symbols.length)];
//
//        }
//        return shuffle(new String(buf));
//    }
//
//    private String shuffle(final String input) {
//        final List<Character> characters = new ArrayList<>();
//
//        for (char c : input.toCharArray()) {
//            characters.add(c);
//        }
//
//        final StringBuilder output = new StringBuilder(input.length());
//
//        while (!characters.isEmpty()) {
//            int randPicker = (int) (Math.random() * characters.size());
//            output.append(characters.remove(randPicker));
//
//        }
//        return output.toString();
//    }
//}
