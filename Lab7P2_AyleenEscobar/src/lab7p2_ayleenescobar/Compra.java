
package lab7p2_ayleenescobar;

public class Compra {
    private double monto;
    private Restaurante restaurante;
    private Producto producto;

    public Compra() {
    }

    public Compra(double monto, Restaurante restaurante, Producto producto) {
        this.monto = monto;
        this.restaurante = restaurante;
        this.producto = producto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Compra{" 
                + "monto=" + monto 
                + ", restaurante=" + restaurante 
                + ", producto=" + producto 
                + '}';
    }

}
