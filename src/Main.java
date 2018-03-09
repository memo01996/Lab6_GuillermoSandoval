
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Memo
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int preciocosto, precioventa, pos;
        String preciocosto1, precioventa1, nombre, estado, tamano, tipo, tipocomida, posicion, correoelectronico = "", nombrecliente = "", RTN = "", CAI = "";
        Date fecha = new Date();
        InventarioClase ic = new InventarioClase();
        Factura fac = new Factura();
        switch (menu()) {
            case 1:
                switch (menuproducto()) {
                    case 1:
                        preciocosto1 = JOptionPane.showInputDialog("Precio de Costo:");
                        preciocosto = Integer.parseInt(preciocosto1);
                        precioventa1 = JOptionPane.showInputDialog("Precio de Venta:");
                        precioventa = Integer.parseInt(precioventa1);
                        nombre = JOptionPane.showInputDialog("Nombre:");
                        estado = JOptionPane.showInputDialog("Estado de la Bebida:");
                        tamano = JOptionPane.showInputDialog("Tamaño de la Bebida:");
                        tipo = JOptionPane.showInputDialog("Tipo de la Bebida:");
                        ic.getListaproducto().add(new Bebida(estado, tamano, tipo, preciocosto, precioventa, nombre));
                        break;
                    case 2:
                        preciocosto1 = JOptionPane.showInputDialog("Precio de Costo:");
                        preciocosto = Integer.parseInt(preciocosto1);
                        precioventa1 = JOptionPane.showInputDialog("Precio de Venta:");
                        precioventa = Integer.parseInt(precioventa1);
                        nombre = JOptionPane.showInputDialog("Nombre:");
                        tipocomida = JOptionPane.showInputDialog("Tipo de Comida:");
                        ic.getListaproducto().add(new Comida(tipocomida, preciocosto, precioventa, nombre));
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion NO valida");
                }//fin switch menuproducto
                break;
            case 2:
                posicion = JOptionPane.showInputDialog("Ingrese posicion del producto que desea listar:");
                pos = Integer.parseInt(posicion);
                JOptionPane.showMessageDialog(null, ic.getListaproducto().get(pos));
                break;
            case 3:
                posicion = JOptionPane.showInputDialog("Ingrese posicion del producto que desea Eliminar:");
                pos = Integer.parseInt(posicion);
                ic.getListaproducto().remove(pos);
                JOptionPane.showMessageDialog(null, "Producto Eliminado");
                break;
            case 4:
                posicion = JOptionPane.showInputDialog("Ingrese posicion del producto que desea Modificar:");
                pos = Integer.parseInt(posicion);
                if (ic.getListaproducto().get(pos) instanceof Bebida) {
                    preciocosto1 = JOptionPane.showInputDialog("Precio de Costo:");
                    preciocosto = Integer.parseInt(preciocosto1);
                    precioventa1 = JOptionPane.showInputDialog("Precio de Venta:");
                    precioventa = Integer.parseInt(precioventa1);
                    nombre = JOptionPane.showInputDialog("Nombre:");
                    estado = JOptionPane.showInputDialog("Estado de la Bebida:");
                    tamano = JOptionPane.showInputDialog("Tamaño de la Bebida:");
                    tipo = JOptionPane.showInputDialog("Tipo de la Bebida:");
                    ic.getListaproducto().add(new Bebida(estado, tamano, tipo, preciocosto, precioventa, nombre));
                    ic.getListaproducto().remove(pos);
                } else {
                    preciocosto1 = JOptionPane.showInputDialog("Precio de Costo:");
                    preciocosto = Integer.parseInt(preciocosto1);
                    precioventa1 = JOptionPane.showInputDialog("Precio de Venta:");
                    precioventa = Integer.parseInt(precioventa1);
                    nombre = JOptionPane.showInputDialog("Nombre:");
                    tipocomida = JOptionPane.showInputDialog("Tipo de Comida:");
                    ic.getListaproducto().add(new Comida(tipocomida, preciocosto, precioventa, nombre));
                    ic.getListaproducto().remove(pos);
                }
                break;
            case 5:
                correoelectronico = JOptionPane.showInputDialog("Correo Electronico:");
                nombrecliente = JOptionPane.showInputDialog("Nombre del Cliente:");
                RTN = JOptionPane.showInputDialog("Ingrese RTN:");
                CAI = JOptionPane.showInputDialog("Ingrese CAI:");
                String fecha1 = JOptionPane.showInputDialog("Ingrese Fecha (yy/MM/dd):");
                fecha.setYear(fecha1.charAt(0) + fecha1.charAt(1));
                fecha.setMonth(fecha1.charAt(3) + fecha1.charAt(4));
                fecha.setDate(fecha1.charAt(6) + fecha1.charAt(7));
                fac.getListadeproducto().addAll(ic.getListaproducto());

                break;
            case 6:
                try {
                    fac.Guardar(correoelectronico, nombrecliente, RTN, CAI, fecha, ic.getListaproducto());
                } catch (IOException e) {
                }
                break;
            case 7:
                Ventas ven = new Ventas();
                JOptionPane.showMessageDialog(null, "Total de ventas:" + ven.getTotalventafactura());
                JOptionPane.showMessageDialog(null, "Fecha:" + fecha);
                break;
            case 8:
                break;
            case 9:
                try {
                    InventarioClase.guardar(ic.getListaproducto());
                } catch (IOException e) {
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion NO valida");
        }//fin switch menu
    }//fin main

    public static int menu() {
        int x;
        String op = JOptionPane.showInputDialog(null, " 1) Agregar Producto\n"
                + "2) Listar Producto\n"
                + "3) Eliminar Producto\n"
                + "4) Modificar Producto\n"
                + "5) Crear Factura\n"
                + "6) Lugar para guardar factura\n"
                + "7) Registrar Venta\n"
                + "8) Guardar todo el inventario y Ingresos\n"
                + "9) Imprimir Tabla\n");
        x = Integer.parseInt(op);
        return x;
    }//fin menu

    public static int menuproducto() {
        int x;
        String op = JOptionPane.showInputDialog(null, "1) Agregar Bebida\n"
                + "2) Agregar Comida\n");
        x = Integer.parseInt(op);
        return x;
    }//menuproducto

}//fin class
