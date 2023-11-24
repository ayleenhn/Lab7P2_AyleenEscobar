
package lab7p2_ayleenescobar;

import java.util.ArrayList;

public class Restaurante {
    private String nombre, ubicacion;
    private ArrayList<Producto> productos;
    private double Saldo_Ventas;

    public Restaurante() {
    }

    public Restaurante(String nombre, String ubicacion, ArrayList<Producto> productos) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
