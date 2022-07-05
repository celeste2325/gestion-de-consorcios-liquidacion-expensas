package model;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class UnidadFuncional {
    private Consorcio consorcio;
    private float metrosCuadrados;
    private List<Persona> inquilinos;
    private List<Expensa> expensas;
    private float porcentajeAPagar;
    private float deuda;

    public UnidadFuncional(Consorcio consorcio, float metrosCuadrados, float porcentajeAPagar) {
        this.consorcio = consorcio;
        this.metrosCuadrados = metrosCuadrados;
        this.inquilinos = new ArrayList<>();
        this.porcentajeAPagar = porcentajeAPagar;
    }

    public void addInquilinos(Persona ...personas) {
        Collections.addAll(this.inquilinos, personas);
    }
    public void addExpensas(Expensa...expensas) {
        Collections.addAll(this.expensas, expensas);
    }

    public void enviarNotificacionExpensa(Double monto) {
        this.inquilinos.forEach(i -> i.enviarNotificacionAlMedio(monto));
    }
}
