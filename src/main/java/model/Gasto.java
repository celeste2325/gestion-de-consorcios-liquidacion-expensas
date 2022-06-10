package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Setter @Getter
public class Gasto {
    private float monto;
    private TipoExpensa tipoExpensa;
    private boolean isRecurrente;
    private LocalDate fecha;

    public Gasto(float monto, TipoExpensa tipo, boolean isRecurrente, LocalDate fecha) {
        this.monto = monto;
        this.tipoExpensa = tipo;
        this.isRecurrente = isRecurrente;
        this.fecha = fecha;
    }

    public boolean isTipoExpensa(TipoExpensa tipoExpensa) {
        return this.getTipoExpensa().equals(tipoExpensa);
    }
}
