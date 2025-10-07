package com.sneha.urlShortener;

import java.util.Map;

public class URLMappingDatabase {
    Map<String ,String> urlMappingDatabase;

    URLMappingDatabase(Map<String, String> urlMappingDatabase){
        this.urlMappingDatabase = urlMappingDatabase;
    }

    void addURL(String url, String id){
        urlMappingDatabase.put(id, url);
    }

    String getURL(String id){
        if(urlMappingDatabase.containsKey(id)){
            return urlMappingDatabase.get(id);
        }
        return null;
    }

}
