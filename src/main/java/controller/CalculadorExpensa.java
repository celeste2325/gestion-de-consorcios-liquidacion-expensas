package controller;

import model.Consorcio;
import model.TipoExpensa;
import model.UnidadFuncional;

import java.util.HashMap;
import java.util.Map;

public class CalculadorExpensa{
    private Map <UnidadFuncional, Double> unidadFuncionalValorApagar = new HashMap<>();
    //TODO
    /*aplicar patron singleton a ControladorConsorcios, crearlo como atributo aqui y en vez de llamarlo
    por parametro desde los metodos de esta clase llamarlo con this. */
    private ControladorConsorcios contConsorcio = new ControladorConsorcios();

    public void calcularExpensa(ControladorConsorcios contConsorcio) {
        double sumaTotalGastos = totalGastos(contConsorcio.getValorExpensa());
        montoPorUnidadFuncional(contConsorcio, sumaTotalGastos);


    }

    public double totalGastos(Map <TipoExpensa, Double> valorExpensa) {
        double valorSuma =0;
        for (Map.Entry<TipoExpensa, Double> tipoExpensaDoubleEntry : valorExpensa.entrySet()) {
            valorSuma += tipoExpensaDoubleEntry.getValue();
        }
        System.out.println("valores sumados"+valorSuma);
        return valorSuma;
    }
    public Map<UnidadFuncional, Double> montoPorUnidadFuncional(ControladorConsorcios contConsorcio, double totalGastos) {
        for (Consorcio consorcio : contConsorcio.getConsorcios()) {
            for (UnidadFuncional unidadesFuncional : consorcio.getUnidadesFuncionales()) {
                this.unidadFuncionalValorApagar.put(unidadesFuncional,
                        (totalGastos * unidadesFuncional.getPorcentajeAPagar()) / 100);
            }
        }
        for (Map.Entry<UnidadFuncional, Double> valorPoUnidadFuncional : this.unidadFuncionalValorApagar.entrySet()) {
            System.out.println("unidadFuncional porcentaje a pagar" + valorPoUnidadFuncional.getKey().getPorcentajeAPagar() +
                    "valor a pagar: " + valorPoUnidadFuncional.getValue());
        }

        return this.unidadFuncionalValorApagar;
    }
}
