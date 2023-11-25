
package lab7p2_ayleenescobar;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministrarUsuarios {
    private ArrayList<Usuario> listaUsuarios = new ArrayList();
    private File archivo = null;

    public AdministrarUsuarios(String path) {
        archivo = new File(path);
    }
    

    public ArrayList<Usuario> getlistaUsuarios() {
        return listaUsuarios;
    }

    public void setlistaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public String toString() {
        return "listaUsuarios=" + listaUsuarios;
    }
    
    public void setUsuario(Usuario u) {
        this.listaUsuarios.add(u);
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Usuario t : listaUsuarios) {
                bw.write(t.getName() + ";");
                bw.write(t.getUser() + ";");
                bw.write(t.getPassword() + ";");
                bw.write(t.getSaldo_Compras() + "");
                bw.newLine();
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }
    
    public void cargarArchivo() {
        Scanner sc = null;
        listaUsuarios = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    String name = sc.next();
                    String user = sc.next();
                    String password = sc.next();
                    double saldoCompras = Double.parseDouble(sc.next());

                    Usuario usuario = new Usuario(name, user, password, saldoCompras);
                    listaUsuarios.add(usuario);
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    
    public Usuario autenticarUsuario(String user, String password) {
    for (Usuario usuario : listaUsuarios) {
        if (usuario.getUser().equals(user) && usuario.getPassword().equals(password)) {
            return usuario;
        }
    }
    return null;
}
}
