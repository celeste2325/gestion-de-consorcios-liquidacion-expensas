package controller;

import model.Consorcio;
import model.SaldoCuenta;
import model.TipoExpensa;
import model.UnidadFuncional;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CalculadorExpensa{

    private SaldoCuenta saldo;
    public void calcularExpensa(Consorcio consorcio) {
        double saldoActual = this.saldo.devolverSaldoActual(consorcio.getCbu(),"6666", LocalDate.now());

        double sumaTotalGastos = totalGastos(consorcio.getValorExpensa()) - saldoActual;
        Map <UnidadFuncional, Double> unidadFuncional_monto = new HashMap<>();
        unidadFuncional_monto = this.montoPorUnidadFuncional(sumaTotalGastos, consorcio);
        this.enviarNotificacion(unidadFuncional_monto);
    }

    private void enviarNotificacion(Map<UnidadFuncional, Double> unidadFuncional_monto) {
        for (Map.Entry<UnidadFuncional, Double> valorPoUnidadFuncional : unidadFuncional_monto.entrySet()) {
            valorPoUnidadFuncional.getKey().enviarNotificacionExpensa(valorPoUnidadFuncional.getValue());
        }
    }

    public double totalGastos(Map <TipoExpensa, Double> valorExpensa) {
        double valorSuma =0;
        for (Map.Entry<TipoExpensa, Double> tipoExpensaDoubleEntry : valorExpensa.entrySet()) {
            valorSuma += tipoExpensaDoubleEntry.getValue();
        }
        System.out.println("valores sumados"+valorSuma);
        return valorSuma;
    }
    public Map<UnidadFuncional, Double> montoPorUnidadFuncional(double totalGastos, Consorcio consorcio) {
        Map <UnidadFuncional, Double> unidadFuncionalValorApagar = new HashMap<>();

            for (UnidadFuncional unidadesFuncional : consorcio.getUnidadesFuncionales()) {
                unidadFuncionalValorApagar.put(unidadesFuncional,
                        (totalGastos * unidadesFuncional.getPorcentajeAPagar()) / 100);
            }
        for (Map.Entry<UnidadFuncional, Double> valorPoUnidadFuncional : unidadFuncionalValorApagar.entrySet()) {
            System.out.println("unidadFuncional porcentaje a pagar" + valorPoUnidadFuncional.getKey().getPorcentajeAPagar() +
                    "valor a pagar: " + valorPoUnidadFuncional.getValue());
        }

        return unidadFuncionalValorApagar;
    }
}
