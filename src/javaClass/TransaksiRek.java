/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class TransaksiRek {
    int noRek;
    
    public void setTransaksi(int nomor){
        noRek = nomor;
    }
    
    public void setDebit(int jmlDebit, int teller_ktp){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            String sql = "INSERT INTO transaksi (transaksi_jenis, teller_ktp, "
                    + "transaksi_nominal, rekening_nomor) VALUES (?,?,?,?)";
            PreparedStatement ps = koneksi.prepareStatement(sql);
                ps.setString(1, "Debit");
                ps.setInt(2, teller_ktp);
                ps.setInt(3, jmlDebit);
                ps.setInt(4, this.noRek);
                System.out.println(ps.toString());
                
                ps.executeUpdate();
                ps.close();
            
            String sql2 = "UPDATE rekening SET rekening_saldo=rekening_saldo+? WHERE rekening_nomor=?";
            PreparedStatement ps2 = koneksi.prepareStatement(sql2);
                ps2.setInt(1, jmlDebit);
                ps2.setInt(2, this.noRek);
                
                ps2.executeUpdate();
                ps2.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void setKredit(int jmlKredit, int teller_ktp){
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            String sql = "INSERT INTO transaksi (transaksi_jenis, teller_ktp, transaksi_nominal, rekening_nomor) VALUES "
                    + "(?,?,?,?)";
            PreparedStatement ps = koneksi.prepareStatement(sql);
                ps.setString(1, "Kredit");
                ps.setInt(2, teller_ktp);
                ps.setInt(3, jmlKredit);
                ps.setInt(4, this.noRek);
                
                ps.executeUpdate();
                ps.close();
            
            String sql2 = "UPDATE rekening SET rekening_saldo=rekening_saldo-? WHERE rekening_nomor=?";
            PreparedStatement ps2 = koneksi.prepareStatement(sql2);
                ps2.setInt(1, jmlKredit);
                ps2.setInt(2, this.noRek);
                
                ps2.executeUpdate();
                ps2.close();
            
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Error nominal transaksi");
        }
    }
    
    public int getJmlTransaksi(){
        int jmlTransaksi = 0;
        try{
            LocalDate reportDate = java.time.LocalDate.now();
            String startDate = reportDate.toString()+" 00:00:00";
            String endDate = reportDate.toString()+" 23:59:59";
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            String sql = "SELECT SUM(transaksi_nominal) AS nominal FROM transaksi WHERE transaksi_tanggal BETWEEN '"
                    +startDate+ "' AND '"+endDate+ "' AND rekening_nomor="+this.noRek+" AND transaksi_jenis='Kredit'";  
            ResultSet rs = s.executeQuery(sql);
            System.out.println(sql);
            while(rs.next()){
                jmlTransaksi = rs.getInt("nominal");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return jmlTransaksi;
    }
    
    public ResultSet getTabelTransaksi(){
        ResultSet rs = null;
        try{
            Connection koneksi = KoneksiDB.getKoneksi();
            Statement s = koneksi.createStatement();
            String sql = "SELECT * FROM transaksi INNER JOIN rekening "
                    + "ON transaksi.rekening_nomor = rekening.rekening_nomor "
                    + "WHERE transaksi.rekening_nomor="+this.noRek;
            rs = s.executeQuery(sql);
        }catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
    
}
