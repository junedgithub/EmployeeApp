package AddEmployees;

import java.util.Scanner;

public class MainApp1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Mode of Operation!!");
        System.out.println("1.Employee with MaxSalary!!");
        System.out.println("2.Employee with MinSalary!!");
        int ch = sc.nextInt();
        if (ch==1)
        {
            MaxOrMinSal.maxSal();
        }
        else if (ch==2)
        {
            MaxOrMinSal.minSal();
        }
    }
}
