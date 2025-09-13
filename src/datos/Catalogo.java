package datos;

import java.util.*;
import modelo.Producto;
import modelo.Rubro;

/**
 *
 * @author Nehuen
 */
public class Catalogo {
    private static final TreeSet<Producto> productos = new TreeSet<>();

    public static boolean agregar(Producto p){ return productos.add(p); }
    public static boolean eliminar(Producto p){ return productos.remove(p); }
    public static Optional<Producto> buscarPorCodigo(int codigo){
        return productos.stream().filter(p -> p.getCodigo()==codigo).findFirst();
    }
    public static Set<Producto> todos(){ return Collections.unmodifiableSet(productos); }

    // Filtros para consultas:
    public static List<Producto> filtrarPorNombre(String patron){
        String x = patron==null? "": patron.trim().toLowerCase();
        return productos.stream()
                .filter(p -> p.getDescripcion().toLowerCase().contains(x))
                .toList();
    }
    public static List<Producto> filtrarPorPrecio(double min, double max){
        return productos.stream()
                .filter(p -> p.getPrecio()>=min && p.getPrecio()<=max)
                .toList();
    }
    public static List<Producto> filtrarPorRubro(Rubro r){
        return productos.stream().filter(p -> p.getRubro()==r).toList();
    }
    
}
