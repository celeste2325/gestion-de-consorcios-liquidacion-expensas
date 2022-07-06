package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter @Setter
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private boolean isPropietario;
    private List<Notificacion> mediosNotificacion;
    private Notificacion medioNotificacion;

    public Persona(String nombre, String apellido, String documento, String email, String telefono, boolean isPropietario, Notificacion medioNotificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = documento;
        this.email = email;
        this.telefono = telefono;
        this.isPropietario = isPropietario;
        this.medioNotificacion = medioNotificacion;
        this.mediosNotificacion = new ArrayList<>();
    }

    public void enviarNotificacionAlMedio(Expensa expensa){
        if(this.medioNotificacion != null){this.medioNotificacion.enviarNotificacion(LocalDateTime.now(),this, expensa);}
    }

    public void addMedios(Notificacion...mediosDeNotificacion) {
        Collections.addAll(this.mediosNotificacion, mediosDeNotificacion);
    }
}
