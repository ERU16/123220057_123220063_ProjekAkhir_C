/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author Bagus Duta Prasetya
 */
public class modeltabeldatahotel extends AbstractTableModel{
    List<datahotel> dh;
    public modeltabeldatahotel(List<datahotel>dh){
        this.dh = dh;
    }
    
    @Override
    public int getRowCount(){
        return dh.size();
    }
    
    @Override
    public int getColumnCount(){
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID";
            case 1:
                return "NAMA PEMESAN";
            case 2:
                return "NO HP";
            case 3:
                return "NO KAMAR";
            case 4:
                return "TYPE KAMAR";
            case 5:
                return "LAMA MENGINAP";
            case 6 : 
                return "HARGA";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dh.get(row).getId();
            case 1:
                return dh.get(row).getNama();
            case 2:
                return dh.get(row).getNo_hp();
            case 3:
                return dh.get(row).getNo_kamar();
            case 4:
                return dh.get(row).getType();
            case 5:
                return dh.get(row).getLama();
            case 6:
                return dh.get(row).getHarga();
            default:
                return null;
        }
    }
    
}
