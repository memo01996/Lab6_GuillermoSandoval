/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Memo
 */
public class Comida extends Producto {

    private String TipoComida;

    public Comida() {
        super();
    }

    public Comida(String TipoComida, int PrecioCosto, int PrecioVenta, String nombre) {
        super(PrecioCosto, PrecioVenta, nombre);
        this.TipoComida = TipoComida;
    }

    public String getTipoComida() {
        return TipoComida;
    }

    public void setTipoComida(String TipoComida) {
        this.TipoComida = TipoComida;
    }

    @Override
    public String toString() {
        return "Comida{" + "TipoComida=" + TipoComida + '}';
    }

}
