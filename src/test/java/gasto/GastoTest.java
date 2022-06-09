package gasto;

import controller.ControladorConsorcios;
import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GastoTest {
    private ControladorConsorcios controladorConsorcio;
    private Consorcio consorcio;
    private TipoDeExpensa expensaOrdinaria;
    private TipoDeExpensa expensaExtraordinaria;
    private Gasto luz;
    private Gasto agua;
    private Gasto gas;
    private Gasto mantAscensores;
    private Gasto mantPartesComunes;


@BeforeEach
public void init() {
    Administrador celeste = new Administrador("Rosanne");
    Administrador rosanne = new Administrador("Rosanne");

    Persona inquilino1 = new Persona("Camila","Rodriguez", "9584712", "camila@gmail.com", "1151745896", false);
    Persona inquilino2 = new Persona("Candela","Perez", "91785412", "candela@gmail.com", "1196325412", false);
    Persona propietario1 = new Persona("Josue","Velasquez", "9354785", "josue@gmail.com", "1156987424", true);
    Persona propietario2 = new Persona("Tomas","Benitez", "90542871", "tomas@gmail.com", "1156398741", true);

    this.consorcio = new Consorcio("000000", "boedo 1625", "27896421");

    UnidadFuncional unidFunc1 = new UnidadFuncional(consorcio, 25,25);
    unidFunc1.addInquilinos(inquilino1,inquilino2,propietario1);
    UnidadFuncional unidFunc2 = new UnidadFuncional(consorcio, 20,20);
    unidFunc2.addInquilinos(inquilino2,propietario2);

    consorcio.addUnidadesFuncionales(unidFunc1,unidFunc2);
    consorcio.addAdministradores(celeste, rosanne);

    this.controladorConsorcio = new ControladorConsorcios();
    this.controladorConsorcio.addConsorcios(this.consorcio);

    // consultar si puede ser un enum igual los tipos de gastos y como se relacionarian
    this.expensaOrdinaria = new TipoDeExpensa("ordinaria");
    this.expensaExtraordinaria = new TipoDeExpensa("extraordinaria");

    this.luz = new Gasto(8000,"recurrente", expensaOrdinaria, true, LocalDate.now());
    this.agua = new Gasto(12000,"recurrente", expensaOrdinaria, true, LocalDate.now());
    this.gas = new Gasto(15000,"recurrente", expensaOrdinaria, true, LocalDate.now());

    this.mantAscensores = new Gasto(6000,"mensual", expensaExtraordinaria, false, LocalDate.now());
    this.mantPartesComunes = new Gasto(30000,"mensual", expensaExtraordinaria, false, LocalDate.now());
}
@Test
public void sumaGastosDeExpensaOrdinariaDevuelve3500() {
    this.controladorConsorcio.cargarGastos(this.consorcio.getCuit(),luz,agua,gas);
    Assertions.assertEquals(35000,this.controladorConsorcio.sumarGastos(this.consorcio.getCuit(), this.expensaOrdinaria));
}

@Test
public void sumaGastosDeExpensaExtraOrdinariaDevuelve36000() {
    this.controladorConsorcio.cargarGastos(this.consorcio.getCuit(),mantAscensores,mantPartesComunes,luz,agua);
    Assertions.assertEquals(36000,this.controladorConsorcio.sumarGastos(this.consorcio.getCuit(), this.expensaExtraordinaria));
    }

}

