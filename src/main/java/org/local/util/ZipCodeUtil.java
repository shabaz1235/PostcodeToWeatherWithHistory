package org.local.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.local.model.ZipCode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

import static org.local.main.Main.httpClient;

public class ZipCodeUtil {
    public static ZipCode GetZipCodeFromZipCode(String zipCode) throws IOException, InterruptedException {
        PropsUtil props = PropsUtil.getInstance();
        URIBuilder zipcode_url = new URIBuilder();
        zipcode_url.setScheme("https")
                .setHost(props.api_url_zipcode)
                .setParameter("appid",props.api_key)
                .setParameter("query",zipCode)
                .setParameter("output","json");
        HttpRequest zipcode_req = HttpRequest.newBuilder()
                .uri(URI.create(zipcode_url.toString()))
                .build();
        HttpResponse<String> zipcode_res = httpClient.send(zipcode_req,
                HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        ZipCode zpiCode = objectMapper.readValue(zipcode_res.body(),ZipCode.class);

        return zpiCode;
    }

}



