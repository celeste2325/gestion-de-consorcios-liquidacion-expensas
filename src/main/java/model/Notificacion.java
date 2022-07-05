package model;

import java.time.LocalDate;

public abstract class Notificacion {
    public abstract void enviarNotificacion(double monto, LocalDate fecha);
}
