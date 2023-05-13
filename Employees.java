package AddEmployees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Employees {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "insert into employee_info values(?,?,?,?)";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,0);
            pstmt.setString(2,"Jayesh");
            pstmt.setString(3,"HR");
            pstmt.setDouble(4,35000.52);
            int count1 = pstmt.executeUpdate();

            pstmt.setInt(1,0);
            pstmt.setString(2,"Juned");
            pstmt.setString(3,"Developer");
            pstmt.setDouble(4,36000.52);
            int count2 = pstmt.executeUpdate();


            pstmt.setInt(1,0);
            pstmt.setString(2,"Vrushab");
            pstmt.setString(3,"Admin");
            pstmt.setDouble(4,38000.52);
            int count3 = pstmt.executeUpdate();

            System.out.println(count1+count2+count3+" Inserted Successfully!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            if (con!=null)
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (pstmt!=null)
            {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
