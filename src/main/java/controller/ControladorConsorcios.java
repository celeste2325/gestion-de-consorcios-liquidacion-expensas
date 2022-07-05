package controller;

import lombok.Getter;
import model.Consorcio;
import model.Gasto;
import model.TipoExpensa;

import java.util.*;
@Getter
public class ControladorConsorcios {
    private static ControladorConsorcios contConsorcio = null;
    CalculadorExpensa calcExpensa = new CalculadorExpensa();
    private List<Consorcio> consorcios;
    private ControladorConsorcios() {
        this.consorcios = new ArrayList<>();
    }

    public static ControladorConsorcios getInstance() {
        if (contConsorcio == null) {
            contConsorcio = new ControladorConsorcios();
        }
        return contConsorcio;
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
            return consorcio.sumarGastosPorTipoExpensa(tipoExpensa);
        } else {
            System.out.println("no se encontro el consorcio");
        }
        return 0;
    }

    public void calcularExpensa(String cuitConsorcio) {
        Consorcio consorcio = this.getConsorcioByCuit(cuitConsorcio);
        if (consorcio != null) {
            this.calcExpensa.calcularExpensa(consorcio);
        }else {
            System.out.println("el consorcio no existe");
        }

    }

}
