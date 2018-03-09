
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Memo
 */
public class Ingresos {

    private ArrayList<Ventas> listaventas = new ArrayList();
    private File archivo = null;

    public Ingresos() {
    }

    public ArrayList<Ventas> getListaventas() {
        return listaventas;
    }

    public void setListaventas(ArrayList<Ventas> listaventas) {
        this.listaventas = listaventas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void Guardar() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Ingresos.txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            for (Object temp : listaventas) {
                bw.write((String) temp);
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }
}
