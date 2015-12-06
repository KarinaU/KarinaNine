package JDBC;

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Created by IT_School on 06.12.2015.
 */

public class Main {

    private static void printResults(ResultSet rs) throws SQLException {
        String 	SName, 	City ;
        int SNum, Age ;
        double Comm;
        while (rs.next()){
            SName = rs.getString("Sname");
            City= rs.getString("City");
            SNum = rs.getInt("Snum");
            Age = rs.getInt("Age");
            Comm = rs.getDouble("Comm");

            System.out.println("***************************************");

            System.out.println("Sname" + SName);
            System.out.println("City" + City);
            System.out.println("Snum" + SNum);
            System.out.println("Age" + Age);
            System.out.println("Comm" + Comm);

            System.out.println("****************************************");


        }
    }

   /* private static void printResults2 (ResultSet rs2) throws SQLException{
        int ONum, CNum;
        Date ODate;
        float Summa;
         while (rs2.next()){
             ONum = rs2.getInt("ONum");
             CNum = rs2.getInt("CNum");
             ODate = rs2.getDate("ODate");
             Summa = rs2.getFloat("Summa");

             System.out.println("***************************************");

             System.out.println("ONum" + ONum);
             System.out.println("CNum" + CNum);
             System.out.println("ODate" + ODate);
             System.out.println("Summa" + Summa);

             System.out.println("****************************************");
         }

    }*/



    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost/DatabaseOne";
        String name  = "Karina";
        String password = "qwerty";

            Connection con = DriverManager.getConnection(url, name, password);

            System.out.println("connect");

            java.sql.Statement st = con.createStatement();
            String query1 = "select * from s";
        //String query2 = "select * from o";
        //String query3 = "select * from c";

            ResultSet rs = st.executeQuery(query1);
        //    ResultSet rs2 = st.executeQuery(query2);
        //  ResultSet rs3 = st.executeQuery(query3);


            printResults(rs);
        con.close();
            //printResults2(rs2);
        //con.close();
            // printResults(rs3);
        //con.close();


    }




}
