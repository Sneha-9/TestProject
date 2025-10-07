package com.sneha.urlShortener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashCodeGenerator {

    String generate(String input) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(input.getBytes());

            // Step 2: Print raw byte array
            // System.out.println("Raw byte[] (binary hash):");
            //System.out.println(Arrays.toString(hashBytes)); // signed bytes

            // Step 3: Convert to hexadecimal string for readability
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            System.out.println("\nReadable Hexadecimal Hash:");
            String hashCode = hexString.toString();
            String truncatedHashCode = hashCode.substring(0, 33);
            System.out.println("Truncated Hash Code  : " + truncatedHashCode);
            System.out.println("Actual Hash Code Generated  : " + hashCode);
            return truncatedHashCode;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
