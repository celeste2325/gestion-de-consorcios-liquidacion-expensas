package controller;

import model.*;

import java.time.LocalDate;
import java.util.Map;

public class CalculadorExpensa{
    private SaldoCuenta saldo;

    public double calcularExpensa(Consorcio consorcio) {
       // double saldoActual = this.saldo.devolverSaldoActual(consorcio.getCbu(),"6666", LocalDate.now());
        double sumaTotalGastos = totalGastos(consorcio.getValorExpensa()) - 300;
        this.generarExpensa(consorcio, sumaTotalGastos);
        return sumaTotalGastos;
    }

    public void generarExpensa(Consorcio consorcio, double sumaGastos) {
        double valorOrdinario = consorcio.sumarGastosPorTipoExpensa(TipoExpensa.ORDINARIA);
        double valorExtraOrdinario = consorcio.sumarGastosPorTipoExpensa(TipoExpensa.EXTRAORIDINARIA);

        for (UnidadFuncional unidadesFuncional : consorcio.getUnidadesFuncionales()) {
            double totalExpensa = ((sumaGastos * unidadesFuncional.getPorcentajeAPagar()) / 100) + unidadesFuncional.getDeuda();
            Expensa expensa = new Expensa(LocalDate.now(),valorOrdinario, valorExtraOrdinario, totalExpensa);
            unidadesFuncional.addExpensas(expensa);
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
        return valorSuma;
    }

}
