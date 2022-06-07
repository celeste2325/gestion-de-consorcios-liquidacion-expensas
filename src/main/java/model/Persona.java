package model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private String email;
    private String telefono;
    private boolean isPropietario;

    public Persona(String nombre, String apellido, String documento, String email, String telefono, boolean isPropietario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.telefono = telefono;
        this.isPropietario = isPropietario;
    }
}
