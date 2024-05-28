/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Bagus Duta Prasetya
 */
public class datahotel {
    private int id;
    private String nama;
    private String no_hp;
    private Integer no_kamar;
    private String type;
    private Integer lama;
    private Integer harga;

    public String getNama() {
        return nama;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public Integer getNo_kamar() {
        return no_kamar;
    }

    public String getType() {
        return type;
    }

    public Integer getLama() {
        return lama;
    }

    public Integer getHarga() {
        switch (type) {
        case "Standard":
            harga = lama * 400000;
            break;
        case "Superior":
            harga = lama * 700000;
            break;
        case "Deluxe":
            harga = lama * 900000;
            break;
        case "Family":
            harga = lama * 1100000;
            break;
        case "Suite":
            harga = lama * 2000000;
            break;
        default:
            harga = 0;
            break;
    }
        
    return harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public void setNo_kamar(Integer no_kamar) {
        this.no_kamar = no_kamar;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLama(Integer lama) {
        this.lama = lama;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
