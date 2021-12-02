package rest.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrugerDAO {

    private static List<Bruger> patients = new ArrayList<>();
    private static BrugerDAO instance = new BrugerDAO();

    public BrugerDAO(){
        Bruger b = new Bruger();
        /*
        Patient melman = new Patient();
        melman.setName("melman");
        melman.setCpr("20200101");
        patients.add(melman);
        */
    }

    public static BrugerDAO getInstance(){
        return instance;
    }

    public List<Bruger> getPatient() {
        return patients;
    }

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
                System.out.println("Brugernavn: " + resultSet.getString(2) + " Kodeord: " + resultSet.getString(3) );
                return bruger;
            }else {
                System.out.println("ingen bruger med dette brugernavn fundet");
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

    public static List<Bruger> allPatients() {
        Connection conn= MySQLDB.getConnection();
        Bruger b = new Bruger();
        patients.clear();
        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM Patients ");
            //preparedStatement.setString(1, brugernavn);
            ResultSet resultSet = st.executeQuery();
            /*if (resultSet.next()) {
                String password = resultSet.getString("Password");
                Bruger bruger = new Bruger();
                bruger.setBrugernavn(brugernavn);
                bruger.setPassword(password);
                return bruger;
            }*/
            //if(!resultSet.next() && resultSet.getRow() == 0) {

            while (resultSet.next()){
                //in this case enter when at least one result comes it means user is valid
                //System.out.println("Patients finds:" );
                //return (Bruger) resultSet;
                //Bruger b = new Bruger();
                String fn = resultSet.getString("firstName");
                String cpr = resultSet.getString("CPR");
                //resultSet.getString("lastName");
                b.setBrugernavn(fn);
                b.setPassword(cpr);
                patients.add(b);
                System.out.println("resultset: "+fn+" "+cpr);

            }
            //else {
              //  System.out.println("Patients finds ikke:" );
            //}
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patients;
    }

    public void savePatient(Bruger b) {
        try {
            Connection con = MySQLDB.getConnection();
            System.out.println(con);
            PreparedStatement st = con.prepareStatement("insert into Users(User, Password)  values(?, ?)");
            st.setString(1, b.getBrugernavn());
            st.setString(2, b.getPassword());
            st.executeUpdate();
            st.close();
            con.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }
}