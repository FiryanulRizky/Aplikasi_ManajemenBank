/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class cariNoKtp {
    int ktpNasabah;
    
    public void setKtp(int ktp){
        ktpNasabah = ktp;
    }
  
    public String[] getDataNasabah(){
        String dataNasabah[] = new String[3];
        
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            
            String sql = "SELECT * FROM nasabah WHERE nasabah_ktp="+this.ktpNasabah;
            ResultSet rs = s.executeQuery(sql);
            
           
                while(rs.next()){
                dataNasabah[0] = rs.getString("nasabah_nama");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date ttl = rs.getDate("nasabah_tgllahir");
                String tgllahir = df.format(ttl);
                dataNasabah[1] = tgllahir;
                dataNasabah[2] = rs.getString("nasabah_alamat");
                    System.out.println(dataNasabah[0]);
               
                }
            
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("error");
        }
        return dataNasabah;
    }
    
}
