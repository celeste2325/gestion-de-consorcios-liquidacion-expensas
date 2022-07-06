package controller;

import model.*;

import java.time.LocalDate;
import java.util.Map;

public class CalculadorExpensa{
    private double totalExpensa;
    private SaldoCuenta saldo;
    public void calcularExpensa(Consorcio consorcio) {
       // double saldoActual = this.saldo.devolverSaldoActual(consorcio.getCbu(),"6666", LocalDate.now());
        double sumaTotalGastos = totalGastos(consorcio.getValorExpensa()) - 300;
        System.out.println("total"+sumaTotalGastos);
        this.generarExpensa(consorcio, sumaTotalGastos);
    }

    private void generarExpensa(Consorcio consorcio, double sumaGastos) {
        double valorOrdinario = consorcio.sumarGastosPorTipoExpensa(TipoExpensa.ORDINARIA);
        double valorExtraOrdinario = consorcio.sumarGastosPorTipoExpensa(TipoExpensa.EXTRAORIDINARIA);

        for (UnidadFuncional unidadesFuncional : consorcio.getUnidadesFuncionales()) {
            this.totalExpensa = ((sumaGastos * unidadesFuncional.getPorcentajeAPagar()) / 100) + unidadesFuncional.getDeuda();
            Expensa expensa = new Expensa(LocalDate.now(),valorOrdinario, valorExtraOrdinario, this.totalExpensa);
            this.enviarNotificacion(unidadesFuncional,expensa);
        }
    }

    private void enviarNotificacion(UnidadFuncional unidadFuncional, Expensa expensa) {
        unidadFuncional.enviarNotificacionExpensa(expensa);
    }

    public double totalGastos(Map <TipoExpensa, Double> valorExpensa) {
        double valorSuma =0;
        for (Map.Entry<TipoExpensa, Double> tipoExpensaDoubleEntry : valorExpensa.entrySet()) {
            valorSuma += tipoExpensaDoubleEntry.getValue();
        }
        System.out.println("valores sumados"+valorSuma);
        return valorSuma;


    }
    /*public Map<UnidadFuncional, Double> montoPorUnidadFuncional(double totalGastos, Consorcio consorcio) {
        Map <UnidadFuncional, Double> unidadFuncionalValorApagar = new HashMap<>();

            for (UnidadFuncional unidadesFuncional : consorcio.getUnidadesFuncionales()) {
                this.totalExpensa = ((totalGastos * unidadesFuncional.getPorcentajeAPagar()) / 100) + unidadesFuncional.getDeuda();
                unidadFuncionalValorApagar.put(unidadesFuncional,
                        this.totalExpensa);
            }
        for (Map.Entry<UnidadFuncional, Double> valorPoUnidadFuncional : unidadFuncionalValorApagar.entrySet()) {
            System.out.println("unidadFuncional porcentaje a pagar" + valorPoUnidadFuncional.getKey().getPorcentajeAPagar() +
                    "valor a pagar: " + valorPoUnidadFuncional.getValue());
        }

        return unidadFuncionalValorApagar;
    }*/
}
