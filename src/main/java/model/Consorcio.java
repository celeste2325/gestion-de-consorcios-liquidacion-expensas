package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consorcio {
    // si no vamos a crear la clase administrador hay que sacar esta lista
    //TODO
    private List<Administrador> administradores;
    private List<Gasto> gastos;
    private List<UnidadFuncional> unidadesFuncionales;
    private String cuentaBancaria;
    private float saldoActual;
    //consultar si es necesario que el consorcio tenga una lista de expensas

    //saque del constructor el saldo actual. Con el cbu lo calcula
    //el token es un atributo o como se pasa para calcular el saldo?
    public Consorcio(String cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        this.administradores = new ArrayList<Administrador>();
        this.gastos = new ArrayList<Gasto>();
    }
    public void addAdministradores(Administrador ...administradores) {
        Collections.addAll(this.administradores, administradores);
    }
    public void addGastos(Gasto ...gastos) {
        Collections.addAll(this.gastos, gastos);
    }
    public void addUnidadesFuncionales(UnidadFuncional ...unidadesFuncionales) {
        Collections.addAll(this.unidadesFuncionales, unidadesFuncionales);
    }
    public double sumarGastosPorTipoExpensa(TipoDeExpensa tipoExpensa) {
        return this.gastos.stream().filter(g-> g.isTipoExpensa(tipoExpensa)).mapToDouble(Gasto::getMonto).sum();
    }
}
