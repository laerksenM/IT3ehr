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
    public OpretKonsultation InsertIntoAftaler(OpretKonsultation opretKonsultation) {
        String SQLAftaler = "INSERT INTO Aftaler (CPR, TimeStart, TimeEnd, Notat, KlinikID) VALUES (?,?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(SQLAftaler);
            preparedStatement.setString(1, opretKonsultation.getCPR());
            preparedStatement.setString(2, opretKonsultation.getTimeStart());
            preparedStatement.setString(3, opretKonsultation.getTimeEnd());
            preparedStatement.setString(4, opretKonsultation.getNotat());
            preparedStatement.setString(5, opretKonsultation.getKlinikID());
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("fejl i overførsel til db");
        }
        return opretKonsultation;
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
