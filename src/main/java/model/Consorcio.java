package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consorcio {
    // si no vamos a crear la clase administrador hay que sacar esta lista
    //TODO
    private String nombre;
    @Getter
    @Setter
    private String cuit;
    @Getter
    private List<Gasto> gastos;
    private List<UnidadFuncional> unidadesFuncionales;
    private String cuentaBancaria;
    private float saldoActual;
    //consultar si es necesario que el consorcio tenga una lista de expensas
    //TODO
    //saque del constructor el saldo actual. Con el cbu lo calcula
    //se mockea en el test para pedir al componente saldo cuenta
    public Consorcio(String cuentaBancaria, String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.cuentaBancaria = cuentaBancaria;
        this.unidadesFuncionales = new ArrayList<UnidadFuncional>();
        this.gastos = new ArrayList<Gasto>();
    }
    public void addGastos(Gasto ...gastos) {
        Collections.addAll(this.gastos, gastos);
    }
    public void addUnidadesFuncionales(UnidadFuncional ...unidadesFuncionales) {
        Collections.addAll(this.unidadesFuncionales, unidadesFuncionales);
    }
    public boolean isConsorcio(String cuitConsorcio) {
        if (this.cuit.equals(cuitConsorcio)) {
            return true;
        }
        return false;
    }

    public double sumarGastosPorTipoExpensa(TipoExpensa tipoExpensa) {
        return this.gastos.stream().filter(g-> g.isTipoExpensa(tipoExpensa)).mapToDouble(Gasto::getMonto).sum();
    }

}
