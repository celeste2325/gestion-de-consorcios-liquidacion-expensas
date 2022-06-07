package model;

import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consorcio {
    // si no vamos a crear la clase administrador hay que sacar esta lista
    private List<Administrador> administradores;
    private List<Gasto> gastos;
    private List<UnidadFuncional> unidadesFuncionales;
    private String cuentaBancaria;
    @Setter
    private float saldoActual;
    //consultar si es necesario que el consorcio tenga una lista de expensas

    public Consorcio(String cuentaBancaria, float saldoActual) {
        this.cuentaBancaria = cuentaBancaria;
        this.saldoActual = saldoActual;
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
}
