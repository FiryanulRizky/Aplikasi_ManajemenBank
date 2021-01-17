/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class KoneksiDB {
    public static Connection koneksi;
    
    public static Connection getKoneksi(){
        //cek koneksi null
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/bank";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
            }catch(SQLException e){
                System.out.println(e);
            }

        }
        return koneksi;
    }
}
