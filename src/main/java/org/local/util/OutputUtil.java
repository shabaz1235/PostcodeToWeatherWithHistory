package org.local.util;

import org.local.model.History;
import org.local.model.Weather;

import java.util.ArrayList;

public class OutputUtil {
    public static void WriteQueryToConsole(ArrayList<Weather.WeatherItem> WeatherItems, String address){
        String leftTitleFormat = "| %-29s |%n";
        String leftAlignFormat = "| %-15s | %-15f |%n";
        System.out.format("+-----------------------------------+%n");
        System.out.format(leftTitleFormat,address);
        System.out.format("+-----------------+-----------------+%n");
        System.out.format("| 時間             | 降水確率         |%n");
        System.out.format("+-----------------+-----------------+%n");
        for (int i = 0; i < WeatherItems.size() ; i++) {
            System.out.format(leftAlignFormat, WeatherItems.get(i).date, WeatherItems.get(i).rainfall);
        }
        System.out.format("+-----------------+-----------------+%n");
    }

    public static void WriteHistoriesToConsole(ArrayList<History> histories){
        String leftAlignFormat = "| %-8s  | %-12s  | %-3s      |%n";
        System.out.format("+-----------+---------------+----------+%n");
        System.out.format("| 郵便番号    | 時間           | 降水確率  |%n");
        System.out.format("+-----------+---------------+----------+%n");
        for (int i = 0; i < histories.size() ; i++) {
            System.out.format(leftAlignFormat, histories.get(i).ZIPCODE,histories.get(i).TIME, histories.get(i).RAINFALLRATE);
        }
        System.out.format("+-----------+---------------+----------+%n");
    }
}
