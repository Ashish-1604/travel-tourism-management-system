import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUser = System.getenv().getOrDefault("DB_USER", "root");
            String dbPassword = System.getenv("DB_PASSWORD");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", dbUser, dbPassword);
            s = c.createStatement();

        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
