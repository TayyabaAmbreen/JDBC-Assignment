/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab08.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Lab08JDBC {

    /**
     * @param args the command line arguments
     */
    
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost/";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "";
    
      public static void Method1Stmt(Connection con) throws SQLException
      {
          con.setAutoCommit(true);
          Statement stmnt=con.createStatement();
          
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
          for(int i=1;i<=5000;i++)
          {
              String name="Tayyaba"+i;
               int rs=stmnt.executeUpdate("INSERT INTO Students values('"+i+"','"+semester+"','"+address+"','"+name+"')");
          }
          
          
      }
      
        public static void Method2Stmt(Connection con) throws SQLException
      {
          con.setAutoCommit(false);
          Statement stmnt=con.createStatement();
          
          String address="Rawalpindi";
          int semester=6;
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
          for(int i=1;i<=5000;i++)
          {
              String name="Tayyaba"+i;
               int rs=stmnt.executeUpdate("INSERT INTO Students values('"+i+"','"+semester+"','"+address+"','"+name+"')");
          }
          
          
      }
          
        public static void Method1PrepStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(true);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
          for(int i=1;i<=5000;i++)
          {
              PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               stmnt1.setInt(1,i);
               stmnt1.setInt(2,semester);
               stmnt1.setString(3,address);
               stmnt1.setString(4,name);
               
               stmnt1.executeUpdate();
          }
                   
      }
           
        public static void Method2PrepStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(false);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
          for(int i=1;i<=5000;i++)
          {
              PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               stmnt1.setInt(1,i);
               stmnt1.setInt(2,semester);
               stmnt1.setString(3,address);
               stmnt1.setString(4,name);
               
               stmnt1.executeUpdate();
          }
          
      }
            
        public static void Method1BatchPrepStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(false);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
          for(int i=1;i<=5000;i++)
          {
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               stmnt1.setInt(1,i);
               stmnt1.setInt(2,semester);
               stmnt1.setString(3,address);
               stmnt1.setString(4,name);
               stmnt1.addBatch();
               
          }
          stmnt1.executeBatch();
          
      }
            
        public static void Method2BatchPrepStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(false);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
          for(int i=1;i<=5000;i++)
          {
              
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               stmnt1.setInt(1,i);
               stmnt1.setInt(2,semester);
               stmnt1.setString(3,address);
               stmnt1.setString(4,name);
               stmnt1.addBatch();
                             
          }
          stmnt1.executeBatch();
          
      }
            
        public static void Method1CallStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(true);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
          CallableStatement callstmnt = con.prepareCall("{CALL addStudent(?,?,?,?)}");
          
          for(int i=1;i<=5000;i++)
          {
             // PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               callstmnt.setInt(1,i);
               callstmnt.setInt(2,semester);
               callstmnt.setString(3,address);
               callstmnt.setString(4,name);
               
               callstmnt.executeQuery();
          }
          
          
      }
        
        public static void Method2CallStmt(Connection con) throws SQLException
      {
          con.setAutoCommit(false);
          
          Statement stmnt=con.createStatement();
          String address="Rawalpindi";
          int semester=6;
          
          String truncate="TRUNCATE TABLE students";
          stmnt.executeUpdate(truncate);
          
         
          CallableStatement callstmnt = con.prepareCall("{CALL addStudent(?,?,?,?)}");
          
          for(int i=1;i<=5000;i++)
          {
             // PreparedStatement stmnt1=con.prepareStatement("INSERT INTO Students values(?,?,?,?)");
              String name="Tayyaba"+i;
               //int rs=stmnt.executeUpdate("INSERT INTO students values(?,?,?,?)");
               callstmnt.setInt(1,i);
               callstmnt.setInt(2,semester);
               callstmnt.setString(3,address);
               callstmnt.setString(4,name);
               
               callstmnt.executeQuery();
          }
          
          
      }
                       
    public static void main(String[] args) {
        // TODO code application logic here
        
        Connection conn = null;
        Statement stmt = null;
        
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");
      
      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", USER, PASS);
      
      
      System.out.println("..........Statement Class...........");
      long startTime=System.currentTimeMillis();
      Method1Stmt(conn);     
      long endTime = System.currentTimeMillis();    
      System.out.println("Statement method with AutoCommit=true took " + (endTime - startTime) + " milliseconds");
      
      long startTime1=System.currentTimeMillis();
      Method2Stmt(conn);     
      long endTime1 = System.currentTimeMillis();
      
      System.out.println("Statement method with AutoCommit=false took " + (endTime1 - startTime1) + " milliseconds");
      System.out.println("");
      
      System.out.println("..........PrparedStatement Class...........");
      long startTime2=System.currentTimeMillis();
      Method1PrepStmt(conn);     
      long endTime2 = System.currentTimeMillis();    
      System.out.println("PreparedStatement method with AutoCommit=true took " + (endTime2 - startTime2) + " milliseconds");
      
      long startTime3=System.currentTimeMillis();
      Method2PrepStmt(conn);     
      long endTime3 = System.currentTimeMillis();
      
      System.out.println("PreparedStatement method with AutoCommit=false took " + (endTime3 - startTime3) + " milliseconds");
      System.out.println("");
      
      System.out.println("..........BatchPreparedStatement Class...........");
      long startTime4=System.currentTimeMillis();
      Method1PrepStmt(conn);     
      long endTime4 = System.currentTimeMillis();    
      System.out.println("BatchPreparedStatement method with AutoCommit=true took " + (endTime4 - startTime4) + " milliseconds");
      
      long startTime5=System.currentTimeMillis();
      Method2PrepStmt(conn);     
      long endTime5 = System.currentTimeMillis();
      
      System.out.println("BatchPreparedStatement method with AutoCommit=false took " + (endTime5 - startTime5) + " milliseconds");
      System.out.println("");
      
      System.out.println("..........CallableStatement Class...........");
      long startTime6=System.currentTimeMillis();
      Method1CallStmt(conn);     
      long endTime6 = System.currentTimeMillis();    
      System.out.println("BatchPreparedStatement method with AutoCommit=true took " + (endTime6 - startTime6) + " milliseconds");
      
      long startTime7=System.currentTimeMillis();
      Method2PrepStmt(conn);     
      long endTime7 = System.currentTimeMillis();
      
      System.out.println("BatchPreparedStatement method with AutoCommit=false took " + (endTime7 - startTime7) + " milliseconds");
      System.out.println("");
   }
        
        catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Goodbye!");
}//end main
    
    
}
