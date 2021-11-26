package rest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrugerDAO {

    /*public static PatientService getInstance() {

    }*/

    public Bruger findBruger(String brugernavn) {
        Connection connection = MySQLDB.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE User= ? ");
            preparedStatement.setString(1, brugernavn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String password = resultSet.getString("Password");
                Bruger bruger = new Bruger();
                bruger.setBrugernavn(brugernavn);
                bruger.setPassword(password);
                return bruger;
            }
            /*if (resultSet.next()) {
                //in this case enter when at least one result comes it means user is valid
                System.out.println("Brugernavn finds:" + brugernavn);
            } else {
                System.out.println("Brugernavn ikke finds:" + brugernavn);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}