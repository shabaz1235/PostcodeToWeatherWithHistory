package org.local.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.URIBuilder;
import org.local.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.local.main.Main.httpClient;

public class WeatherUtil {
    public static Weather GetWeatherFromCoordinates (String coordinates) throws IOException, InterruptedException {
        PropsUtil props = PropsUtil.getInstance();
        URIBuilder weather_url = new URIBuilder();
        weather_url.setScheme("https")
                .setHost(props.api_url_weather)
                .setParameter("appid",props.api_key)
                .setParameter("coordinates",coordinates)
                .setParameter("output","json");
        HttpRequest weather_req = HttpRequest.newBuilder()
                .uri(URI.create(weather_url.toString()))
                .build();
        HttpResponse<String> weather_res = httpClient.send(weather_req,
                HttpResponse.BodyHandlers.ofString());
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = objectMapper.readValue(weather_res.body(), Weather.class);
        return weather;
    }
}
