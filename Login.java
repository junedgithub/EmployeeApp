package AddEmployees;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        System.out.println("Enter Username");
        String username = sc.next();
        System.out.println("Enter password!!");
        String password = sc.next();

        String query = "select * from login_info where username = ? and password = ?";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();

            while(rs.next())
            {
                 if (username.equals(rs.getString(2)))
                 {
                     if (password.equals(rs.getString(3)))
                     {
                         System.out.println("AddEmployees.Login Successfully!!");
                     }
                 }
                 else
                 {
                     System.out.println("Invalid AddEmployees.Login!!");
                 }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally{
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
            if (rs!=null)
            {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
