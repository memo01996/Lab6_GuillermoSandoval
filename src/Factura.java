
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class Factura {

    private ArrayList<Producto> listadeproducto = new ArrayList();
    private String Correoelectronico;
    private String nombrecliente;
    private String RTN;
    private String CAI;
    private Date fecha = new Date();

    public Factura() {
    }

    public Factura(String Correoelectronico, String nombrecliente, String RTN, String CAI) {
        this.Correoelectronico = Correoelectronico;
        this.nombrecliente = nombrecliente;
        this.RTN = RTN;
        this.CAI = CAI;
    }

    public ArrayList<Producto> getListadeproducto() {
        return listadeproducto;
    }

    public void setListadeproducto(ArrayList<Producto> listadeproducto) {
        this.listadeproducto = listadeproducto;
    }

    public String getCorreoelectronico() {
        return Correoelectronico;
    }

    public void setCorreoelectronico(String Correoelectronico) {
        this.Correoelectronico = Correoelectronico;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getRTN() {
        return RTN;
    }

    public void setRTN(String RTN) {
        this.RTN = RTN;
    }

    public String getCAI() {
        return CAI;
    }

    public void setCAI(String CAI) {
        this.CAI = CAI;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void Guardar(String correoelectronico, String nombrecliente, String rtn, String cai, Date fecha, ArrayList listaproducto) throws IOException {
        int flag = 1;
        Producto pro = new Producto();
        ArrayList lista = new ArrayList();
        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String lugar = JOptionPane.showInputDialog("Donde desea guardar la factura:");
            archivo = new File(lugar + "/factura.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            lista.add("Dunking Donuts");
            lista.add(cai);
            lista.add(rtn);
            lista.add(fecha);
            lista.add(correoelectronico);
            lista.add(nombrecliente);
            lista.add("Productos");
            lista.add(listaproducto);
            lista.add(pro.getSubtotal());
            lista.add(pro.getImp());
            lista.add(pro.getTotal());
            for (Object temp : lista) {
                bw.write((String) temp);
                if (temp.equals(listaproducto)) {
                    bw.write("producto: " + flag + (String) temp);
                    flag++;
                } else {
                    bw.newLine();
                }
            }
            bw.flush();
            flag = 1;
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
}
