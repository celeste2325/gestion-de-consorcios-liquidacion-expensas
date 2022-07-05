package model;

import java.time.LocalDate;

public interface SaldoCuenta {
    double devolverSaldoActual(String alias_cbu, String token, LocalDate fecha);
    }

