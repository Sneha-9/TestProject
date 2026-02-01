package com.sneha.urlShortener;

import java.security.NoSuchAlgorithmException;

public class URLShortener {

    private final HashCodeGenerator hashCodeGenerator;
    private final URLMappingDatabase urlMappingDatabase;
    private final URLService urlService;

    URLShortener(URLService urlService, URLMappingDatabase urlMappingDatabase, HashCodeGenerator hashCodeGenerator) {
        this.hashCodeGenerator = hashCodeGenerator;
        this.urlService = urlService;
        this.urlMappingDatabase = urlMappingDatabase;
    }

    String getOriginalURL(String url) {
        String id = urlService.getURLId(url);
        String originalURL = urlMappingDatabase.getURL(id);

        return originalURL;

    }

    String getShortenedURL(String url) throws NoSuchAlgorithmException {
        String id = hashCodeGenerator.generate(url);

        urlMappingDatabase.addURL(url, id);

        String shortenedURL = urlService.generateShortenedURL(id);

        return shortenedURL;
    }
}
