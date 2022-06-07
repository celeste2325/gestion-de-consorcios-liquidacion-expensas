package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        this.inquilinos = new ArrayList<Persona>();
        this.porcentajeAPagar = porcentajeAPagar;
    }

    public void addInquilinos(Persona ...personas) {
        Collections.addAll(this.inquilinos, personas);
    }
    public void addExpensas(Expensa ...expensas) {
        Collections.addAll(this.expensas, expensas);
    }

}
