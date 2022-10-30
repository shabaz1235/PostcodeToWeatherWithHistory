package org.local.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Weather {
    @JsonProperty("ResultInfo")
    public ResultInfo resultInfo;
    @JsonProperty("Feature")
    public Feature[] features;

    public ArrayList<WeatherItem> getWeatherList(){
        return features[0].property.weatherList.WeatherItems;
    }

    static class ResultInfo{
        @JsonProperty("Count")
        public int count;
        @JsonProperty("Total")
        public int total;
        @JsonProperty("Start")
        public int start;
        @JsonProperty("Status")
        public int status;
        @JsonProperty("Latency")
        public double latency;
        @JsonProperty("Description")
        public String description;
        @JsonProperty("Copyright")
        public String copyright;
    }

    static class Feature{
        @JsonProperty("Id")
        public String id;
        @JsonProperty("Name")
        public String name;
        @JsonProperty("Geometry")
        public Geometry geometry;
        @JsonProperty("Property")
        public Property property;
    }

    static class Geometry{
        @JsonProperty("Type")
        public String type;
        @JsonProperty("Coordinates")
        public String coordinates;
    }

    static class Property{
        @JsonProperty("WeatherAreaCode")
        public int weatherAreaCode;
        @JsonProperty("WeatherList")
        public WeatherList weatherList;
    }

    public static class WeatherList{
        @JsonProperty("Weather")
        public ArrayList<WeatherItem> WeatherItems;
    }

    public static class WeatherItem{
        @JsonProperty("Type")
        public String type;
        @JsonProperty("Date")
        public String date;
        @JsonProperty("Rainfall")
        public double rainfall;
    }
}
