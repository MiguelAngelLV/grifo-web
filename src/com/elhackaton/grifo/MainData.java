package com.elhackaton.grifo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Random;

public class MainData {



    public static void main(String argv[]) throws SQLException {
        Connection connection = DataBase.getConnection();

        Random random = new Random();
        String sql = "INSERT INTO datos (duracion, inicio) VALUES(?, ?)";
        long time = Calendar.getInstance().getTimeInMillis();


        for (int i = 0; i < 600; i++) {
            PreparedStatement prepare = connection.prepareStatement(sql);
            prepare.setInt(1, random.nextInt(8) + 2);
            prepare.setTimestamp(2, new Timestamp(time));
            prepare.execute();

            time += random.nextInt(1000*60*60*10) + 1000*60*60;
        }



    }


}
