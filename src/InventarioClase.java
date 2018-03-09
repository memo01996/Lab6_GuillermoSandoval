
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class InventarioClase {

    private ArrayList<Producto> listaproducto = new ArrayList();
    private File archivo = null;

    public ArrayList<Producto> getListaproducto() {
        return listaproducto;
    }

    public void setListaproducto(ArrayList<Producto> listaproducto) {
        this.listaproducto = listaproducto;
    }

    public File getArchivo() {
        archivo = new File("./inventario.txt");
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
        archivo = new File("./");
    }

    public InventarioClase() {
    }

    @Override
    public String toString() {
        return "InventarioClase{" + "listaproducto=" + listaproducto + '}';
    }

    public static void guardar(ArrayList listaproducto) throws IOException {

        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            String lugar = JOptionPane.showInputDialog("Donde desea guardar la factura:");
            archivo = new File(lugar + "/Inventario.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Object temp : listaproducto) {
                bw.write((String) temp);
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
}
