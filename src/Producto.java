/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Memo
 */
public class Producto {

    private double subtotal;
    private double total;
    private double imp;
    private int PrecioCosto;
    private int PrecioVenta;
    private String nombre;

    public Producto() {
    }

    public Producto(int PrecioCosto, int PrecioVenta, String nombre) {
        this.PrecioCosto = PrecioCosto;
        this.PrecioVenta = PrecioVenta;
        this.nombre = nombre;
    }

    public double getSubtotal() {
        subtotal = total / 1.15;
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
        subtotal = total / 1.15;
    }

    public double getTotal() {
        total += PrecioVenta;
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        total += PrecioVenta;
    }

    public double getImp() {
        imp = total - subtotal;
        return imp;
    }

    public void setImp(double imp) {
        this.imp = imp;
        imp = total - subtotal;
    }

    public int getPrecioCosto() {
        return PrecioCosto;
    }

    public void setPrecioCosto(int PrecioCosto) {
        this.PrecioCosto = PrecioCosto;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" + "PrecioCosto=" + PrecioCosto + ", PrecioVenta=" + PrecioVenta + ", nombre=" + nombre + '}';
    }

}
