/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package health_tracker;

/**
 *
 * @author Asus
 */
import java.sql.*;

public class Pengguna {
//    private int idPengguna;
    private String namaPengguna;
    private String kataSandi;
    private int usia;
    private float beratBadan;
    private float tinggiBadan;
    private String tingkatAktivitas;

    // Konstruktor
    public Pengguna(String namaPengguna, String kataSandi, int usia, float beratBadan, float tinggiBadan, String tingkatAktivitas) {
        this.namaPengguna = namaPengguna;
        this.kataSandi = kataSandi;
        this.usia = usia;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.tingkatAktivitas = tingkatAktivitas;
    }

    // Registrasi Pengguna
    public void registrasi() {
        String query = "INSERT INTO pengguna (namaPengguna, kataSandi, usia, beratBadan, tinggiBadan, tingkatAktivitas) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = KoneksiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, namaPengguna);
            ps.setString(2, kataSandi);
            ps.setInt(3, usia);
            ps.setFloat(4, beratBadan);
            ps.setFloat(5, tinggiBadan);
            ps.setString(6, tingkatAktivitas);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Login Pengguna
    public boolean login(String namaPengguna, String kataSandi) {
        String query = "SELECT * FROM pengguna WHERE namaPengguna = ? AND kataSandi = ?";
        try (Connection con = KoneksiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, namaPengguna);
            ps.setString(2, kataSandi);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

