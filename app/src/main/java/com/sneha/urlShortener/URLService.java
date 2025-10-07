package com.sneha.urlShortener;

public class URLService {
    private static final String url = "https://tiny.com/";

    String generateShortenedURL(String id){
        String shortenURL = url.concat(id);

        return shortenURL;

    }


    String getURLId(String url){
        int index = url.lastIndexOf("/");
        String id = url.substring(index+1);

        return id;
    }


}
