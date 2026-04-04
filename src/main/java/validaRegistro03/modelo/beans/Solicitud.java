package validaRegistro03.modelo.beans;

import java.io.Serializable;

public class Solicitud implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login; // (Es el nombre que usa el usuario para acceder al sistema.)
    private String clave;
    private String email;
    private String nombre;
    private String apellidos;

    public Solicitud(String login, String clave, String email, String nombre, String apellidos) {
        this.login = login;
        this.clave = clave;
        this.email = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() { return apellidos; }

    public boolean esValida() {
        return login != null &&
                clave != null &&
                email != null &&
                nombre != null &&
                apellidos != null &&
                login.length() >= 5 &&
                clave.length() >= 5 &&
                email.length() >= 5 &&
                email.contains("@") &&
                nombre.length() >= 5 &&
                apellidos.length() >= 5;
    }

    @Override
    public String toString() {
        return this.login+":"+this.clave+":"+this.email+":"+this.nombre+":"+this.apellidos;
    }
}