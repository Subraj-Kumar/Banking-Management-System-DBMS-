package bank.management.system;

import java.sql.*;

public class connection {
    Connection con;
    /*
    we need not create any functions here, we will do our connection through driver manager;
     For which we need to import a file in library;
    */
    static Statement stmt;
    public connection(){
        //we need to use try and catch because there are high chances of errors especially run time error;
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banksystem", "root", "@12345678");
        stmt = con.createStatement();
        }catch(Exception e ){
            e.printStackTrace();
        }

    }
}
