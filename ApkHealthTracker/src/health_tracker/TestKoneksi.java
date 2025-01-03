/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package health_tracker;

/**
 *
 * @author Asus
 */
import java.sql.Connection;

public class TestKoneksi {
    public static void main(String[] args) {
        Connection conn = KoneksiDB.getConnection();
        if (conn != null) {
            System.out.println("Koneksi ke database berhasil!");
        } else {
            System.out.println("Koneksi ke database gagal.");
        }
    }
}

