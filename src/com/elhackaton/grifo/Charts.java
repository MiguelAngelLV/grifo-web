package com.elhackaton.grifo;


import org.primefaces.model.chart.CartesianChartModel;

import javax.faces.bean.ManagedBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@ManagedBean
public class Charts {


    private String end;
    private String start;


    private void create(String sql) throws SQLException {
        Connection connection = DataBase.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(0, start);
        statement.setString(1, end);

        ResultSet resultSet = statement.executeQuery();

        CartesianChartModel model = new CartesianChartModel();


        while(resultSet.next()) {


        }

    }



    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        return format.format(calendar.getTime());
    }
}
