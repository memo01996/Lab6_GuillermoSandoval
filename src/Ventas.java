
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Memo
 */
public class Ventas {

    private double totalventafactura;
    private Date fecha = new Date();

    public Ventas(double totalventafactura) {
        this.totalventafactura = totalventafactura;
    }

    public Ventas() {
    }

    public double getTotalventafactura() {
        Producto pro = new Producto();
        totalventafactura = pro.getTotal();
        return totalventafactura;
    }

    public void setTotalventafactura(double totalventafactura) {
        Producto pro = new Producto();
        this.totalventafactura = totalventafactura;
        totalventafactura = pro.getTotal();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Ventas{" + "totalventafactura=" + totalventafactura + ", fecha=" + fecha + '}';
    }

}
