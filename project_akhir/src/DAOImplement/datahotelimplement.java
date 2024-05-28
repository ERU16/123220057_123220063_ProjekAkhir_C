/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOImplement;
import java.util.List;
import model.*;
/**
 *
 * @author Bagus Duta Prasetya
 */
public interface datahotelimplement {
    public void insert(datahotel h);
    public void update(datahotel h);
    public void delete(int id);
    public List<datahotel> cari(String x);
    public List<datahotel> getAll();
}
