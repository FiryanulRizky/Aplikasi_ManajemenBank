/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.util.Date;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.Format;
import java.text.SimpleDateFormat;

/**
 *
 * @author User
 */
public class ValidasiForm {
    
    String jenisNasabah; String ktpNasabah; String namaNasabah; String alamatNasabah; String rekNasabah;
    Date ttlNasabah;
    int saldoNasabah = 0; int poinNasabah = 0; int teleponNasabah;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date tanggal = new Date();
    
    public ValidasiForm( String jenisNasabah, String noKtp, String rekNasabah, 
            String namaNasabah,Date ttlNasabah, String alamatNasabah, int saldoNasabah){
        this.jenisNasabah = jenisNasabah;
        this.ktpNasabah = noKtp;
        this.namaNasabah = namaNasabah;
        this.alamatNasabah = alamatNasabah;
        this.rekNasabah = rekNasabah;
        this.ttlNasabah = ttlNasabah;
        this.saldoNasabah = saldoNasabah;
    }
    
    public boolean cekFormBiasa(){
        if(this.jenisNasabah.equals("") || this.ktpNasabah.equals("") ||
                this.rekNasabah.equals("") || this.namaNasabah.equals("") ||
                 this.alamatNasabah.equals("") || this.saldoNasabah < 50000){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean cekFormBisnis(){
        if(this.jenisNasabah.equals("") || this.ktpNasabah.equals("") ||
                this.rekNasabah.equals("") || this.namaNasabah.equals("") ||
                 this.alamatNasabah.equals("") || this.saldoNasabah < 500000){
            return true;
        }else{
            return false;
        }
    }
    
    public void setInputNasabahBaru(){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            
            String sql = "INSERT INTO nasabah VALUES (?, ?, ?, ?)";
            PreparedStatement ps = koneksi.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(this.ktpNasabah));
                ps.setString(2, this.namaNasabah);
                ps.setDate(3, new java.sql.Date(tanggal.getTime()));
                ps.setString(4, this.alamatNasabah);
                
                ps.executeUpdate();
                ps.close();
            
            String sql2 = "INSERT INTO rekening VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps2 = koneksi.prepareStatement(sql2);
                ps2.setInt(1, Integer.parseInt(this.rekNasabah));
                ps2.setInt(2, saldoNasabah);
                ps2.setInt(3, Integer.parseInt(this.ktpNasabah));
                ps2.setString(4, this.jenisNasabah);
                ps2.setInt(5, poinNasabah);
                java.sql.Date CurrentDate = new java.sql.Date(tanggal.getTime());
                ps2.setDate(6, CurrentDate);
                ps2.setDate(7, CurrentDate);
                ps2.setDate(8, CurrentDate);
                ps2.setDate(9, CurrentDate);
                
                ps2.executeUpdate();
                ps2.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void setInputNasabah(){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            
            String sql2 = "INSERT INTO rekening VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps2 = koneksi.prepareStatement(sql2);
                ps2.setInt(1, Integer.parseInt(this.rekNasabah));
                ps2.setInt(2, saldoNasabah);
                ps2.setInt(3, Integer.parseInt(this.ktpNasabah));
                ps2.setString(4, this.jenisNasabah);
                ps2.setInt(5, poinNasabah);
                java.sql.Date CurrentDate = new java.sql.Date(tanggal.getTime());
                ps2.setDate(6, CurrentDate);
                ps2.setDate(7, CurrentDate);
                ps2.setDate(8, CurrentDate);
                ps2.setDate(9, CurrentDate);
                
                ps2.executeUpdate();
                ps2.close();
                
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    
} 
