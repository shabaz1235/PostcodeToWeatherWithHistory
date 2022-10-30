package org.local.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ZipCode {
    @JsonProperty("ResultInfo")
    public ResultInfo resultInfo;
    @JsonProperty("Feature")
    public Feature[] features;

    public String getCoordinates(){
       if (resultInfo.count<1){
          return "";
       }
       return features[0].geometry.coordinates;
    }
    public String getAddress(){
       if (resultInfo.count<1){
          return "";
       }
       return features[0].property.address;
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
      @JsonProperty("Description")
      public String description;
      @JsonProperty("Copyright")
      public String copyright;
      @JsonProperty("Latency")
      public double latency;
   }

   static class Feature{
      @JsonProperty("Id")
      public String id;
      @JsonProperty("Gid")
      public String gid;
      @JsonProperty("Name")
      public String name;
      @JsonProperty("Geometry")
      public Geometry geometry;
      @JsonProperty("Category")
      public ArrayList<String> category;
      @JsonProperty("Description")
      public String description;
      @JsonProperty("Style")
      public ArrayList<Object> style;
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
      @JsonProperty("Uid")
      public String uid;
      @JsonProperty("CassetteId")
      public String cassetteId;
      @JsonProperty("Country")
      public Country country;
      @JsonProperty("Address")
      public String address;
      @JsonProperty("GovernmentCode")
      public String governmentCode;
      @JsonProperty("AddressMatchingLevel")
      public String addressMatchingLevel;
      @JsonProperty("PostalName")
      public String postalName;
      @JsonProperty("Area")
      public ArrayList<Area> area;
      @JsonProperty("Station")
      public ArrayList<Station> station;
   }

   static class Area{
      @JsonProperty("Code")
      public String code;
      @JsonProperty("Name")
      public String name;
   }
   static class Station{
      @JsonProperty("Id")
      public String id;
      @JsonProperty("SubId")
      public String subId;
      @JsonProperty("Name")
      public String name;
      @JsonProperty("Railway")
      public String railway;
      @JsonProperty("Exit")
      public String exit;
      @JsonProperty("ExitId")
      public String exitId;
      @JsonProperty("Distance")
      public String distance;
      @JsonProperty("Time")
      public String time;
      @JsonProperty("Geometry")
      public Geometry geometry;
   }

   static class Country{
      @JsonProperty("Code")
      public String code;
      @JsonProperty("Name")
      public String name;
   }

}

