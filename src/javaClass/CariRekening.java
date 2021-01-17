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

/**
 *
 * @author User
 */
public class CariRekening {
    int noRek;
    public static String alamat;
    
    public void setRekNasabah(int rek){
        noRek = rek;
    }
    
    public String[] getNasabah(){
        
        String dataNasabah[] = new String[4];
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM nasabah INNER JOIN rekening ON nasabah.nasabah_ktp "
                    + "= rekening.nasabah_ktp WHERE rekening.rekening_nomor="+noRek;
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                dataNasabah[0] = Integer.toString(rs.getInt("nasabah_ktp"));
                dataNasabah[1] = rs.getString("nasabah_nama");
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date hari = rs.getDate("nasabah_tgllahir");
                String reportdate = df.format(hari);
                dataNasabah[2] = reportdate;
                dataNasabah[3] = rs.getString("nasabah_alamat");
            }
            System.out.println("cari sukses");
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return dataNasabah;
    }
    
    public String[] getRekening(){
        String dataRekening[] = new String[7];
        
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            
            String sql = "SELECT * FROM rekening WHERE rekening_nomor="+noRek;
            ResultSet rs = s.executeQuery(sql);
            
            while(rs.next()){
                dataRekening[0] = Integer.toString(rs.getInt("rekening_saldo"));
                dataRekening[1] = Integer.toString(rs.getInt("nasabah_ktp"));
                dataRekening[3] = rs.getString("rekening_jenis");
                dataRekening[2] = Integer.toString(rs.getInt("rekening_poin"));     
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return dataRekening;
    }
    
    
}
