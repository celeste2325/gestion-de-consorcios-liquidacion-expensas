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

}
