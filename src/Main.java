
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
        double totalventas;
        String fecha1, preciocosto1, precioventa1, nombre, estado, tamano, tipo, tipocomida, posicion, correoelectronico = "", nombrecliente = "", RTN = "", CAI = "";
        Date fecha = new Date();
        InventarioClase ic = new InventarioClase();
        Factura fac = new Factura();
        Ingresos ing = new Ingresos();
        Ventas ven = new Ventas();
        Producto pro = new Producto();
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
                fecha1 = JOptionPane.showInputDialog("Ingrese Fecha (yy/MM/dd):");
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
                fecha1 = JOptionPane.showInputDialog("Ingrese Fecha (yy/MM/dd):");
                fecha.setYear(fecha1.charAt(0) + fecha1.charAt(1));
                fecha.setMonth(fecha1.charAt(3) + fecha1.charAt(4));
                fecha.setDate(fecha1.charAt(6) + fecha1.charAt(7));
                JOptionPane.showMessageDialog(null, "Venta Registrada");
                ing.getListaventas().add(new Ventas(ven.getTotalventafactura(), fecha));
                break;
            case 8:

                File archivo = null;
                FileWriter fw = null;
                BufferedWriter bw = null;
                try {
                    archivo = new File("./InventarioyIngresos.txt");
                    fw = new FileWriter(archivo, true);
                    bw = new BufferedWriter(fw);
                    bw.write("Inventario");
                    bw.newLine();
                    for (Object temp : ic.getListaproducto()) {
                        bw.write((String) temp);
                    }
                    bw.newLine();
                    bw.write("Ingresos");
                    for (Object temp1 : ing.getListaventas()) {
                        bw.write((String) temp1);
                    }
                    bw.newLine();
                    bw.flush();
                } catch (Exception e) {
                }
                bw.close();
                fw.close();

                break;

            case 9:
                System.out.println("Ventas de la Compañia");
                System.out.print("Total" + ven.getTotalventafactura());
                System.out.println("");
                System.out.print("Impuesto" + pro.getImp());
                System.out.println("");
                System.out.print(fecha);
                
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
