/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import DAOdatahotel.datahotelDAO;
import DAOImplement.datahotelimplement;
import javax.swing.JOptionPane;
import model.*;
import view.MainView;
/**
 *
 * @author ACER
 */
public class datahotelcontroller {
    MainView frame;
    datahotelimplement impldatahotel;
    List<datahotel> dh;

    public datahotelcontroller(MainView frame) {
        this.frame = frame;
        impldatahotel = new datahotelDAO();
        dh = impldatahotel.getAll();
    }
    public void isitabel(){
        dh = impldatahotel.getAll();
        modeltabeldatahotel mh = new modeltabeldatahotel(dh);
        frame.getTabelHotel().setModel(mh);
    }
    
    public void insert(){
        try {
            if (frame.getTxtNama().getText().isEmpty() || frame.getTxtNohp().getText().isEmpty() || frame.getTxtNokamar().getText().isEmpty() || frame.getCbTipe().getSelectedItem() == null || frame.getTxtLama().getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            datahotel dh = new datahotel();
            dh.setNama(frame.getTxtNama().getText());
            dh.setNo_hp(frame.getTxtNohp().getText());
            dh.setNo_kamar(Integer.parseInt(frame.getTxtNokamar().getText()));
            if(dh.getNo_kamar() <= 0){
                JOptionPane.showMessageDialog(frame, "No kamar tidak tersedia.", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                dh.setType(frame.getCbTipe().getSelectedItem().toString());
                dh.setLama(Integer.parseInt(frame.getTxtLama().getText()));
                if(dh.getLama() <= 0){
                JOptionPane.showMessageDialog(frame, "Lama menginap harus lebih dari 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    else{
                        impldatahotel.insert(dh);
                        JOptionPane.showMessageDialog(null, "Data hotel berhasil ditambahkan!");
            }
            
            
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Lama menginap harus berupa angka/berupa Integer.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat menambahkan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void update(){
        try {
            if (frame.getTxtNama().getText().isEmpty() || frame.getTxtNohp().getText().isEmpty() || frame.getTxtNokamar().getText().isEmpty() || frame.getCbTipe().getSelectedItem() == null || frame.getTxtLama().getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            datahotel dhtl = new datahotel();
            dhtl.setId(Integer.parseInt(frame.getTxtId().getText()));
            dhtl.setNama(frame.getTxtNama().getText());
            dhtl.setNo_hp(frame.getTxtNohp().getText());
            dhtl.setNo_kamar(Integer.parseInt(frame.getTxtNokamar().getText()));
            if(dhtl.getNo_kamar() <= 0){
                JOptionPane.showMessageDialog(frame, "No kamar tidak tersedia.", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                dhtl.setType(frame.getCbTipe().getSelectedItem().toString());
                dhtl.setLama(Integer.parseInt(frame.getTxtLama().getText()));
                if(dhtl.getLama() <= 0){
                JOptionPane.showMessageDialog(frame, "Lama menginap harus lebih dari 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    else{
                        impldatahotel.update(dhtl);
                        JOptionPane.showMessageDialog(null, "Data hotel berhasil diupdate!");
            }
            
            
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Lama menginap harus berupa angka/berupa Integer.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat update data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void delete(){
        try {
            if (frame.getTxtNama().getText().isEmpty() || frame.getTxtNohp().getText().isEmpty() || frame.getTxtNokamar().getText().isEmpty() || frame.getCbTipe().getSelectedItem() == null || frame.getTxtLama().getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Semua field harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
            int id = Integer.parseInt(frame.getTxtId().getText());
            impldatahotel.delete(id);
            JOptionPane.showMessageDialog(null, "Data hotel berhasil dihapus!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Lama menginap harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Terjadi kesalahan saat update data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void search(){
        String x = frame.getTxtSearch().getText();
        dh = impldatahotel.cari(x);
        
        if(!dh.isEmpty()){
            modeltabeldatahotel mth = new modeltabeldatahotel(dh);
            frame.getTabelHotel().setModel(mth);
        }else{
            JOptionPane.showMessageDialog(null, "TIdak ada nama dengan keyword " + x);
        }
        
    }
}
