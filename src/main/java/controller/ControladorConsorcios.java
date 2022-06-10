package controller;

import model.Consorcio;
import model.Gasto;
import model.TipoExpensa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorConsorcios {
    private List<Consorcio> consorcios;

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

    private Consorcio getConsorcioByCuit(String cuitConsorcio) {
        return this.consorcios.stream().filter(c->c.isConsorcio(cuitConsorcio)).findFirst().get();
    }

    public double sumarGastos(String cuitConsorcio, TipoExpensa tipoExpensa) {
        Consorcio consorcio = getConsorcioByCuit(cuitConsorcio);
        if(consorcio != null) {
            return consorcio.sumarGastosPorTipoExpensa(tipoExpensa);
        } else {
            System.out.println("no se encontro el consorcio");
        }
        return 0;
    }

    public void addConsorcios(Consorcio ...consorcios) {
        Collections.addAll(this.consorcios,consorcios);
    }

}
