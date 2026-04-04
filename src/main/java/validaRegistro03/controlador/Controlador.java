package validaRegistro03.controlador;

import validaRegistro03.modelo.beans.Solicitud;
import validaRegistro03.modelo.procesos.GestionArchivo;
import validaRegistro03.modelo.procesos.GestionSolicitudes;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controlador {

    public void ejecutar() {
        Scanner teclado = new Scanner(System.in);
        GestionArchivo gestionArchivo = new GestionArchivo();
        GestionSolicitudes gestionSolicitudes = new GestionSolicitudes();

        try {
            System.out.print("Nombre del archivo a leer (.txt): ");
            String nombreArchivoLectura = teclado.nextLine().trim();

            HashMap<String, Solicitud> solicitudes = gestionArchivo.cargarArchivo(nombreArchivoLectura);
            gestionSolicitudes.mostrarSolicitudes(solicitudes);

            System.out.print("\nNombre del archivo donde guardar los datos (.ser): ");
            String nombreArchivoEscritura = teclado.nextLine().trim();

            gestionArchivo.escribirArchivo(nombreArchivoEscritura, solicitudes);
            System.out.println("Datos guardados correctamente en '" + nombreArchivoEscritura + "'.");

        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
