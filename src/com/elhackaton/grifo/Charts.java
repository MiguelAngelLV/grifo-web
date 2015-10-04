package com.elhackaton.grifo;


import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@ManagedBean
@ViewScoped
public class Charts {


    private Date end;
    private Date start;


    public Charts() {
        end = Calendar.getInstance().getTime();
        start = Calendar.getInstance().getTime();
    }

    private LineChartModel create(String sql) throws SQLException {
        Connection connection = DataBase.getConnection();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, new java.sql.Date(start.getTime()));

        if (end != null)
            statement.setDate(2, new java.sql.Date(end.getTime()));

        ResultSet resultSet = statement.executeQuery();

        LineChartModel model = new LineChartModel();
        LineChartSeries serie = new LineChartSeries();

        while(resultSet.next()) {
            serie.set(resultSet.getTimestamp(1).getTime(), resultSet.getInt(2));
        }

        model.addSeries(serie);

        return model;

    }

    public String update() {
        return null;
    }



    public LineChartModel getDay() throws SQLException {
        end = null;
        String sql = "SELECT inicio, duracion FROM datos WHERE DATE(inicio) = ?";
        return create(sql);
    }


    public Date getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public void setStart(Date start) {
        this.start = start;
    }


    public Date getStart() {
        return start;
    }
}
