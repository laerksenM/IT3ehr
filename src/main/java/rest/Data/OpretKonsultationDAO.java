package rest.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OpretKonsultationDAO {

    private List<OpretKonsultation> aftaler = new ArrayList<>();
    private static OpretKonsultationDAO opretKonsultationDAO = new OpretKonsultationDAO();

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;


    // Test til indsætning i database table med et statement ad gangen, kun brugt til test
    public OpretKonsultation InsertIntoAftaler(OpretKonsultation opretKonsultationer) {
        String SQLAftaler = "INSERT INTO Aftaler (CPR, TimeStart, TimeEnd, Notat, KlinikID) VALUES (?,?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(SQLAftaler);
            preparedStatement.setString(1, opretKonsultationer.getCPR());
            preparedStatement.setString(2, opretKonsultationer.getTimeStart());
            preparedStatement.setString(3, opretKonsultationer.getTimeEnd());
            preparedStatement.setString(4, opretKonsultationer.getNotat());
            preparedStatement.setString(5, opretKonsultationer.getKlinikID());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("fejl i overførsel til db");
        }
        return opretKonsultationer;
    }

    public OpretKonsultation InsertIntoAftaler2(String CPR, String TimeStart, String TimeEnd, String Notat, String KlinikID) {
        Connection connection = MySQLDB.getConnection();
        String SQLAftaler = "INSERT INTO Aftaler (CPR, TimeStart, TimeEnd, Notat, KlinikID) VALUES (?,?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(SQLAftaler);
            preparedStatement.setString(1, CPR);
            preparedStatement.setString(2, TimeStart);
            preparedStatement.setString(3, TimeEnd);
            preparedStatement.setString(4, Notat);
            preparedStatement.setString(5, KlinikID);
            preparedStatement.execute();
            System.out.println("overført til db! :)");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("fejl i overførsel til db");
        }
        return null;
    }

}
