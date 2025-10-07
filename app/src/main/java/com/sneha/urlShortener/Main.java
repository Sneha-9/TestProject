package com.sneha.urlShortener;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        URLService urlService = new URLService();
        HashCodeGenerator hashCodeGenerator = new HashCodeGenerator();
        URLMappingDatabase urlMappingDatabase = new URLMappingDatabase(new HashMap<>());
        URLShortener urlShortener = new URLShortener(urlService, urlMappingDatabase, hashCodeGenerator);

        String shortenedURL = urlShortener.getShortenedURL("http://www.google.com");
        System.out.println(shortenedURL);

        String originalURL = urlShortener.getOriginalURL(shortenedURL);
        System.out.println(originalURL);
        String shortenedURL2 = urlShortener.getShortenedURL("http://www.google.com");
        System.out.println(shortenedURL2);

        String originalURL2 = urlShortener.getOriginalURL(shortenedURL);
        System.out.println(originalURL2);
    }
}
