package model;

import java.time.LocalDateTime;

public abstract class Notificacion {
    public abstract void enviarNotificacion(LocalDateTime fechaYhora, Persona persona, Expensa expensa);
}
