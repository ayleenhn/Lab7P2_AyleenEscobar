
package lab7p2_ayleenescobar;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AdministrarRestaurantes {
    private ArrayList<Restaurante> listaRestaurantes = new ArrayList<>();
    private File archivo = null;
    
    public AdministrarRestaurantes(String path) {
        archivo = new File(path);
    }
    
    public ArrayList<Restaurante> getListaRestaurantes() {
        return listaRestaurantes;
    }

    public void setListaRestaurantes(ArrayList<Restaurante> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void agregarRestaurante(Restaurante restaurante) {
        listaRestaurantes.add(restaurante);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Restaurante restaurante : listaRestaurantes) {
                bw.write(restaurante.getNombre() + ";");
                bw.write(restaurante.getUbicacion() + ";");
                bw.write(Double.toString(restaurante.getSaldo_Ventas()) + ";");
                
                for (Producto producto : restaurante.getProductos()) {
                    bw.write(producto.getNombre() + ",");
                    bw.write(Double.toString(producto.getPrecio()) + ",");
                    bw.write(";");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo() {
        Scanner sc = null;
        listaRestaurantes = new ArrayList<>();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    String nombre = sc.next();
                    String ubicacion = sc.next();
                    double saldoVentas = Double.parseDouble(sc.next());
                    Restaurante restaurante = new Restaurante(nombre, ubicacion, new ArrayList<>(), saldoVentas);

                    while (sc.hasNext(";")) {
                        sc.next();
                        String nombreProducto = sc.next();
                        double precioProducto = Double.parseDouble(sc.next());
                        Producto producto = new Producto(nombreProducto, precioProducto);
                        restaurante.getProductos().add(producto);
                    }
                    listaRestaurantes.add(restaurante);
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    
    public Restaurante autenticarRestaurante(String nombre) {
        for (Restaurante restaurante : listaRestaurantes) {
            if (restaurante.getNombre().equals(nombre)) {
                return restaurante;
            }
        }
        return null;
    }
    
    public DefaultTreeModel arbolRest() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Restaurantes");
        for (Restaurante restaurante : listaRestaurantes) {
            DefaultMutableTreeNode restauranteNode = new DefaultMutableTreeNode(restaurante.getNombre());
            for (Producto producto : restaurante.getProductos()) {
                DefaultMutableTreeNode productoNode = new DefaultMutableTreeNode(producto.getNombre());
                restauranteNode.add(productoNode);
            }
            root.add(restauranteNode);
        }return new DefaultTreeModel(root);
    }
}
