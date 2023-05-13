package AddEmployees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecord {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        String query = "delete from employee_info where emp_id = ?";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt = con.prepareStatement(query);

            pstmt.setInt(1,1);
            int count1 =   pstmt.executeUpdate();

            pstmt.setInt(1,3);
            int count2 =   pstmt.executeUpdate();

            System.out.println(count1+count2+" Deleted Successfully!!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
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
