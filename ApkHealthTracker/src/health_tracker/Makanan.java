/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package health_tracker;

/**
 *
 * @author Asus
 */
public class Makanan {
    private int idMakanan;
    private String namaMakanan;
    private float kalori;

    public Makanan(String namaMakanan, float kalori) {
        this.namaMakanan = namaMakanan;
        this.kalori = kalori;
    }

    // Getter untuk kalori
    public float getKalori() {
        return kalori;
    }
}

