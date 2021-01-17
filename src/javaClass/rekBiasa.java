/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author User
 */
public class rekBiasa {
    
    int biaya;
    float bunga;
    
    public void setBiayaAdmin(String bulan, String currentDate){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            String sql = "UPDATE rekening SET rekening_saldo=rekening_saldo-?, waktu_bayar=?, WHERE waktu_bayar=? AND rekening_jenis=?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, 5000);
            ps.setString(2, currentDate);
            ps.setString(3, bulan);
            ps.setString(4, "Biasa");
            ps.executeUpdate();
            ps.close();            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void setBunga(String tahun, String currentDate){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            String sql2 = "UPDATE rekening set rekening_saldo=rekening_saldo+(?/?*rekening_saldo), waktu_bunga=? WHERE waktu_bunga=? AND rekening_jenis=?";
            PreparedStatement ps = koneksi.prepareStatement(sql2);
            ps.setInt(1, 1);
            ps.setInt(1, 100);
            ps.setString(3, currentDate);
            ps.setString(4, tahun);
            ps.setString(5, "Biasa");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate currentDate = LocalDate.now();
        return dtf.format(currentDate);
    }
    
    public String getBulan(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate bulan = LocalDate.now().minusMonths(1);
        return dtf.format(bulan);
    }
    
    public String getTahun(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate tahun = LocalDate.now().minusYears(1);
        return dtf.format(tahun);
    }
    
}

class bisnis extends rekBiasa{
    @Override
    public void setBiayaAdmin(String bulan, String currentDate){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            String sql = "UPDATE rekening SET rekening_saldo=rekening_saldo-?, waktu_bayar=?, WHERE waktu_bayar=? AND rekening_jenis=?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, 15000);
            ps.setString(2, currentDate);
            ps.setString(3, bulan);
            ps.setString(4, "Bisnis");
            ps.executeUpdate();
            ps.close();            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
            
    @Override    
    public void setBunga(String tahun, String currentDate){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            String sql2 = "UPDATE rekening set rekening_saldo=rekening_saldo+(?/?*rekening_saldo), waktu_bunga=? WHERE waktu_bunga=? AND rekening_jenis=?";
            PreparedStatement ps = koneksi.prepareStatement(sql2);
            ps.setInt(1, 1);
            ps.setInt(1, 100);
            ps.setString(3, currentDate);
            ps.setString(4, tahun);
            ps.setString(5, "Bisnis");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void setPoin(String tahun, String currentDate){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            String sql3 = "UPDATE rekening SET rekening_poin = rekening_poin/?, waktu_poin=? WHERE waktu_poin=? AND rekening_jenis=?";
            PreparedStatement ps = koneksi.prepareStatement(sql3);
            ps.setInt(1, 100000);
            ps.setString(2, currentDate);
            ps.setString(3, tahun);
            ps.setString(4, "Bisnis");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
