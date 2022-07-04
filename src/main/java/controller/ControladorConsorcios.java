package controller;

import lombok.Getter;
import model.Consorcio;
import model.Gasto;
import model.TipoExpensa;

import java.util.*;
@Getter
public class ControladorConsorcios {

    private List<Consorcio> consorcios;

    private Map <TipoExpensa, Double> valorExpensa = new HashMap<>();

    public ControladorConsorcios() {
        this.consorcios = new ArrayList<>();
    }

    public void cargarGastos(String cuitConsorcio, Gasto...gastos) {
        Consorcio consorcio = getConsorcioByCuit(cuitConsorcio);
        if(consorcio != null) {
            consorcio.addGastos(gastos);
        } else {
            System.out.println("no se encontro el consorcio");
        }
    }
    public void addConsorcios(Consorcio ...consorcios) {
        Collections.addAll(this.consorcios,consorcios);
    }

    private Consorcio getConsorcioByCuit(String cuitConsorcio) {
        return this.consorcios.stream().filter(c->c.isConsorcio(cuitConsorcio)).findFirst().get();
    }

    public double sumarGastosPorTipoExpensa(String cuitConsorcio, TipoExpensa tipoExpensa) {
        Consorcio consorcio = getConsorcioByCuit(cuitConsorcio);
        if(consorcio != null) {
            double totalGasto = consorcio.sumarGastosPorTipoExpensa(tipoExpensa);
            addMapValorExpensa(tipoExpensa,totalGasto);
            return totalGasto;
        } else {
            System.out.println("no se encontro el consorcio");
        }
        return 0;
    }
    public void addMapValorExpensa(TipoExpensa tipo, double totalGasto) {
        valorExpensa.put(tipo,totalGasto);
    }

}
