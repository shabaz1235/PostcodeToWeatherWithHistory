package org.local.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropsUtil {
    String f = "setting.properties";
    String api_url_zipcode;
    String api_url_weather;
    String api_key;
    String sqlite_db;
    private static PropsUtil instance;

    static {
        try {
            instance = new PropsUtil();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static PropsUtil getInstance(){
        return instance;
    }
    private PropsUtil() throws IOException {
        Properties props = new Properties();
        props.load(new java.io.FileInputStream(f));
        api_url_zipcode = (String) props.get("api_url_zipcode");
        api_url_weather = (String) props.get("api_url_weather");
        api_key = (String) props.get("api_key");
        sqlite_db = (String) props.get("sqlite_db");
    }
}

