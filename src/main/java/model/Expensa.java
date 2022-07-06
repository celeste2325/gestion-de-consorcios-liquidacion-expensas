package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Expensa {
    private LocalDate fecha;
    private double valorOrdinario;
    private double valorExtraordinario;
    private double total;

    public Expensa(LocalDate fecha, double valorOrdinario,double valorExtraordinario, double total) {
        this.fecha = fecha;
        this.valorExtraordinario = valorExtraordinario;
        this.valorOrdinario = valorOrdinario;
        this.total = total;
    }
}
