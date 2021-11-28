package rest;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class KonsultationDao {
    public Konsultationer findKonsultationer(String cprNummer) {
        System.out.println("først");
        Connection connection = MySQLDB.getConnection();
        System.out.println("hmmm");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Aftaler WHERE CPR= ?");
            preparedStatement.setString(1, cprNummer);
            System.out.println("cpr sat");;
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Når her til :) ");
            if (resultSet.next()){
                String timeStart = resultSet.getString("TimeStart");
                String timeEnd = resultSet.getString("TimeEnd");
                String notat = resultSet.getString("Notat");
                String cpr = resultSet.getString("CPR");
                Konsultationer konsultationer = new Konsultationer(cpr, timeStart, timeEnd,notat);
                return konsultationer;
            } else {
                throw new NotFoundException("cpr nummer ikke fundet");
            }
            // System.out.println(resultSet.next());
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}