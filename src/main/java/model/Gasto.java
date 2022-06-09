package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter @Getter
public class Gasto {
    private float monto;
    private String tipoDeGasto;
    private TipoDeExpensa tipoExpensa;
    private boolean isRecurrente;
    private LocalDate fecha;

    public Gasto(float monto, String tipoDeGasto, TipoDeExpensa tipoExpensa, boolean isRecurrente, LocalDate fecha) {
        this.monto = monto;
        this.tipoDeGasto = tipoDeGasto;
        this.tipoExpensa = tipoExpensa;
        this.isRecurrente = isRecurrente;
        this.fecha = fecha;
    }

    public boolean isTipoExpensa(TipoDeExpensa tipoExpensa) {
        return this.getTipoExpensa().equals(tipoExpensa);
    }
}
