package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private String email;
    private String telefono;
    private boolean isPropietario;
    private Notificacion medioNotificacion;

    public Persona(String nombre, String apellido, String documento, String email, String telefono, boolean isPropietario, Notificacion medioNotificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;
        this.telefono = telefono;
        this.isPropietario = isPropietario;
        this.medioNotificacion = medioNotificacion;
    }

    public void enviarNotificacionAlMedio(double monto){
        if(this.medioNotificacion != null){this.medioNotificacion.enviarNotificacion(monto, LocalDate.now());}

    }
}
