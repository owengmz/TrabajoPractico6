package vistas;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import modelo.Producto;
/**
 *
 * @author Nehuen
 */
public class ProductoTableModel extends AbstractTableModel {
    private final String[] cols = {"Código", "Descripción", "Precio", "Stock", "Rubro"};
    private List<Producto> data;

    public ProductoTableModel(List<Producto> data){ this.data = data; }
    public void setData(List<Producto> data){ this.data = data; fireTableDataChanged(); }

    @Override public int getRowCount(){ return data==null?0:data.size(); }
    @Override public int getColumnCount(){ return cols.length; }
    @Override public String getColumnName(int c){ return cols[c]; }
    @Override public boolean isCellEditable(int r,int c){ return false; } // ← No editable
    @Override public Object getValueAt(int r,int c){
        Producto p = data.get(r);
        return switch(c){
            case 0 -> p.getCodigo();
            case 1 -> p.getDescripcion();
            case 2 -> p.getPrecio();
            case 3 -> p.getStock();
            case 4 -> p.getRubro();
            default -> "";
        };
    }
    public Producto getAt(int r){ return data.get(r); }
}
    
