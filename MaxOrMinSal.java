package AddEmployees;

import java.sql.*;

public class MaxOrMinSal {
  static Connection con = null;
  static Statement stmt = null;
  static ResultSet rs = null;
  static String query = null;
    static{
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja8", "root", "sql123");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void maxSal()
    {
        query = "select * from employee_info where emp_sal = (select max(emp_sal) from employee_info)";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("EMP_ID\t\tEMP_NAME\t\tEMP_DESIGNATION\t\tEMP_SAL");
            while(rs.next())
            {
                int emp_id = rs.getInt(1);
                String emp_name = rs.getString(2);
                String emp_designation = rs.getString(3);
                double maxSalary = rs.getDouble(4);
                System.out.println(emp_id+"\t\t"+emp_name+"\t\t"+emp_designation+"\t\t"+maxSalary);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void minSal(){
        query = "select * from employee_info where emp_sal = (select min(emp_sal) from employee_info)";
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            System.out.println("EMP_ID\t\tEMP_NAME\t\tEMP_DESIGNATION\t\tEMP_SAL");
            while(rs.next()){
                double minSalary = rs.getDouble(4);
                System.out.println(minSalary);
                int emp_id = rs.getInt(1);
                String emp_name = rs.getString(2);
                String emp_designation = rs.getString(3);
                double maxSalary = rs.getDouble(4);
                System.out.println(emp_id+"\t\t"+emp_name+"\t\t"+emp_designation+"\t\t"+minSalary);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
