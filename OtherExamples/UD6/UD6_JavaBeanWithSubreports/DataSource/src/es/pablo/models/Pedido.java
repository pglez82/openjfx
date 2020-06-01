package es.pablo.models;

public class Pedido
{
    private String producto;
    private Integer cantidad;
    private Double precio;

    public Pedido(String producto, Integer cantidad, Double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecio() {
        return precio;
    }
}
