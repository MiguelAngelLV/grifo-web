package com.elhackaton.grifo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {


    public static final String BD   = "elhackaton";
    public static final String USER = "elhackaton";
    public static final String PASS = "elhackaton";

    private static Connection connection;


    public static Connection getConnection() {
        if (connection == null) try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + BD + "?user=" + USER + "&password=" + PASS);
        } catch (SQLException e) {
        }

        return connection;
    }


}

