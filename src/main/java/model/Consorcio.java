package model;

import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Getter
public class Consorcio {
    // si no vamos a crear la clase administrador hay que sacar esta lista
    //TODO
    private String nombre;
    @Setter
    private String cuit;
    private String cbu;
    private String alias;
    private List<Gasto> gastos;
    private List<UnidadFuncional> unidadesFuncionales;
    private Map<TipoExpensa, Double> valorExpensa = new HashMap<>();

    public Consorcio(String cbu, String alias, String nombre, String cuit) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.cbu = cbu;
        this.alias = alias;
        this.unidadesFuncionales = new ArrayList<>();
        this.gastos = new ArrayList<>();
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
        double total = this.gastos.stream().filter(g-> g.isTipoExpensa(tipoExpensa)).mapToDouble(Gasto::getMonto).sum();
        addMapValorExpensa(tipoExpensa,total);
        return total;
    }
    public void addMapValorExpensa(TipoExpensa tipo, double totalGasto) {
        valorExpensa.put(tipo,totalGasto);
    }

}
