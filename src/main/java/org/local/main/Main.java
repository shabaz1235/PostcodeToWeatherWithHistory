package org.local.main;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import org.local.model.*;
import org.local.util.OutputUtil;
import org.local.util.SQLiteUitl;
import org.local.util.WeatherUtil;
import org.local.util.ZipCodeUtil;


public class Main {

    public static HttpClient httpClient = HttpClient.newBuilder().build();
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
        SQLiteUitl sqLiteUitl = SQLiteUitl.getInstance();

        sqLiteUitl.create();
        while (true){

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(">Please input zipcode in the format of 000-0000, or history, clear, quit:");
            String inputString = in.readLine();

            if(Objects.equals(inputString, "history")){
                ArrayList<History> histories = sqLiteUitl.selectHistory();
                OutputUtil.WriteHistoriesToConsole(histories);
                continue;
            }
            else if(Objects.equals(inputString, "clear")){
                sqLiteUitl.clear();
                continue;
            }
            else if(Objects.equals(inputString, "quit")){
                break;
            } else if (!inputString.matches("\\d{3}-\\d{4}")) {
                System.out.println("wrong input!");
                continue;
            }

            ZipCode zipCode = ZipCodeUtil.GetZipCodeFromZipCode(inputString);
            String coordinates = zipCode.getCoordinates();
            if(coordinates.isEmpty() || coordinates.isBlank()){
                System.out.println("wrong zipcode!");
                continue;
            }

            String address = zipCode.getAddress();
            Weather weather = WeatherUtil.GetWeatherFromCoordinates(coordinates);
            ArrayList<Weather.WeatherItem> WeatherItems = weather.getWeatherList();
            OutputUtil.WriteQueryToConsole(WeatherItems,address);
            sqLiteUitl.bulkInsert(inputString,WeatherItems);

        }
        sqLiteUitl.close();
    }
}