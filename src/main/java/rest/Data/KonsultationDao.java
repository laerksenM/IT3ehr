package rest.Data;

import javax.ws.rs.NotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class KonsultationDao {

    public Konsultationer findKonsultationer(String cprNummer) {
        //System.out.println("først");
        Connection connection = MySQLDB.getConnection();
        //System.out.println("hmmm");

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Aftaler WHERE CPR= ?");
            preparedStatement.setString(1, cprNummer);
            //System.out.println("cpr sat");;
            ResultSet resultSet = preparedStatement.executeQuery();
            //System.out.println("Når her til :) ");

            if (resultSet.next()){
                String timeStart = resultSet.getString("TimeStart");
                String timeEnd = resultSet.getString("TimeEnd");
                String notat = resultSet.getString("Notat");
                String cpr = resultSet.getString("CPR");
                Konsultationer konsultationer = new Konsultationer(cpr, timeStart, timeEnd,notat);
                System.out.println(resultSet.getString(1) + "  |  " + resultSet.getString(2) + "  |  " + resultSet.getString(3) + "  |  " + resultSet.getString(4) + "  |  " + resultSet.getString(5)+ "  |  " + resultSet.getString(6));
                System.out.println("----------------------");
                return konsultationer;
            } else {
                System.out.println("cpr nummer ikke fundet");
                throw new NotFoundException("cpr nummer ikke fundet");

            }
            // System.out.println(resultSet.next());
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}