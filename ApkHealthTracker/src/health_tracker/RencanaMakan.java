/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package health_tracker;

/**
 *
 * @author Asus
 */
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class RencanaMakan {
    private int idRencana;
    private int idPengguna;
    private float totalKalori;
    private List<Makanan> daftarMakanan;

    public RencanaMakan(int idPengguna) {
        this.idPengguna = idPengguna;
        this.daftarMakanan = new ArrayList<>();
    }

    // Menambahkan makanan ke dalam rencana makan
    public void tambahkanMakanan(Makanan makanan) {
        daftarMakanan.add(makanan);
        totalKalori += makanan.getKalori();
        String query = "INSERT INTO rencana_makan (idPengguna, totalKalori) VALUES (?, ?)";
        try (Connection con = KoneksiDB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idPengguna);
            ps.setFloat(2, totalKalori);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

