package controllers;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection( "jdbc:mysql://localhost:3306/student_crm?serverTimezone=UTC","root","avenue2020");

            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from discipline WHERE status = 1");
            while(rs.next())
                System.out.println(rs.getString("discipline"));
            con.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
