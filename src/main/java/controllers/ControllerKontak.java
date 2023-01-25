/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import edu.praktikumpbo.crudkontak.Connection.Koneksi;
import interfaces.InterfaceKontak;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Kontak;

/**
 *
 * @author Putri
 */
public class ControllerKontak implements InterfaceKontak {
    PreparedStatement ps;

    @Override
    public Kontak insert(Kontak Kontak) throws SQLException {
        
        ps = Koneksi.getConnection().prepareStatement("INSERT INTO kontak (nama, telepon, alamat) VALUES (?,?,?)");
        ps.setString(1, Kontak.getNama());
//        System.out.println(kontak.getNama());
        ps.setString(2, Kontak.getTelepon());
//        System.out.println(kontak.getTelepon());
        ps.setString(3, Kontak.getAlamat());
//        System.out.println(kontak.getAlamat());
        ps.executeUpdate();
        ps.close();
        
        return Kontak;
    }
    
    @Override
    public void update(Kontak kontak) throws SQLException {
        
        ps = Koneksi.getConnection().prepareStatement("UPDATE kontak SET nama=?, telepon=?, alamat=? WHERE id=?");
        ps.setString(1, kontak.getNama());
        ps.setString(2, kontak.getTelepon());
        ps.setString(3, kontak.getAlamat());
        ps.setInt(4, kontak.getId());
        ps.executeUpdate();
        ps.close();
    }
    
    @Override
    public void delete(int id) throws SQLException {
        
        ps = Koneksi.getConnection().prepareStatement("DELETE FROM kontak WHERE id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
    }
    
    @Override
    public List<Kontak> getAll() throws SQLException {
        
        Statement st = Koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM kontak");
        List<Kontak> dataKontak = new ArrayList<>();
        
        while(rs.next()) {
            
            Kontak kontak = new Kontak();
            kontak.setId(rs.getInt("ID"));
            kontak.setNama(rs.getString("Nama"));
            kontak.setTelepon(rs.getString("Telepon"));
            kontak.setAlamat(rs.getString("Alamat"));
            dataKontak.add(kontak);
        }
        return dataKontak;
    }

}
