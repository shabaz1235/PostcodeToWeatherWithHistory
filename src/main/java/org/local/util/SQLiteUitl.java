package org.local.util;

import org.local.model.History;
import org.local.model.Weather;

import java.sql.*;
import java.util.ArrayList;

public class SQLiteUitl {
    String url ;
    Connection connection;
    private static SQLiteUitl instance;

    static {
        try {
            instance = new SQLiteUitl();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static SQLiteUitl getInstance(){
        return instance;
    }
    private SQLiteUitl() throws SQLException, ClassNotFoundException {
        PropsUtil props = PropsUtil.getInstance();
        url = "jdbc:sqlite:"+props.sqlite_db;
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection(url);
    }
    public void create() throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS WEATHER (" +
                " ZIPCODE           CHAR(50)    NOT NULL, " +
                " TIME              CHAR(50)    NOT NULL, " +
                " RAINFALLRATE      CHAR(50)    NOT NULL, " +
                " primary key (ZIPCODE,TIME))";
        stmt.executeUpdate(sql);
        stmt.close();
    }
    public void insert (String ZIPCODE, String TIME, String RAINFALLRATE) throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        String sql = "REPLACE INTO WEATHER (ZIPCODE, TIME, RAINFALLRATE)" +
                "VALUES('" + ZIPCODE + "', '" + TIME + "', '" + RAINFALLRATE + "')";
        stmt.executeUpdate(sql);
        stmt.close();
    }
    public void bulkInsert (String zipcode, ArrayList<Weather.WeatherItem> WeatherItems) throws SQLException {
        for(int i = 0; i < WeatherItems.size() ; i++) {
            insert(zipcode, WeatherItems.get(i).date, String.valueOf(WeatherItems.get(i).rainfall));
        }
    }

    public ArrayList<History> selectHistory() throws SQLException {
        Statement stmt = null;
        ResultSet res = null;
        ArrayList<History> histories = new ArrayList<>();
        stmt = connection.createStatement();
        String sql = "SELECT a.ZIPCODE, a.TIME, a.RAINFALLRATE FROM WEATHER a " +
                "inner join (SELECT ZIPCODE, max(TIME) as NEWEST FROM WEATHER GROUP BY ZIPCODE) b " +
                "on a.ZIPCODE = b.ZIPCODE AND a.TIME = b.NEWEST";
        res = stmt.executeQuery(sql);
        while (res.next()){
                History history = new History();
            history.ZIPCODE = res.getString("ZIPCODE");
            history.TIME = res.getString("TIME");
            history.RAINFALLRATE = res.getString("RAINFALLRATE");
            histories.add(history);
        }
        stmt.close();
        return histories;
    }

    public void clear() throws SQLException {
        Statement stmt = null;
        stmt = connection.createStatement();
        String sql = "DELETE FROM WEATHER";
        stmt.executeUpdate(sql);
        stmt.close();
    }

    public void close() throws SQLException {
        connection.close();
    }
}
