package rest.Data;

import java.sql.*;

public class UsersDTO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UsersDTO(Connection connection){
        this.connection = connection;
    }

    // Test til indsætning i database table med et statement ad gangen, kun brugt til test
    public void InsertIntoUsers(String value1, String value2) {
        String SQLUsers = "INSERT INTO Users (User, Password) VALUES (?,?)";
        try {
            preparedStatement = connection.prepareStatement(SQLUsers);
            preparedStatement.setString(1, value1);
            preparedStatement.setString(2, value2);
            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("Brugernavn skal være unikt");
        }
    }
}
