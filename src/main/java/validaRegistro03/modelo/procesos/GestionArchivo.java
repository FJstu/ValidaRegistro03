package validaRegistro03.modelo.procesos;

import validaRegistro03.modelo.beans.Solicitud;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;

public class GestionArchivo {

    public HashMap<String, Solicitud> cargarArchivo(String nombreArchivo) throws InputMismatchException {
        HashMap<String, Solicitud> solicitudes = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(":");
                if (partes.length == 5) {
                    Solicitud solicitud = new Solicitud(
                            partes[0], partes[1], partes[2], partes[3], partes[4]);
                    if (solicitud.esValida()) {
                        solicitudes.put(solicitud.getLogin(), solicitud);
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error: el archivo '" + nombreArchivo + "' no existe.");
        } catch (IOException ioe) {
            System.out.println("Error de lectura: " + ioe.getMessage());
        }

        return solicitudes;
    }

    public void escribirArchivo(String nombreArchivo, HashMap<String, Solicitud> solicitudes)
            throws InputMismatchException {
        try (ObjectOutputStream inputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            inputStream.writeObject(solicitudes);
        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        }
    }
}
