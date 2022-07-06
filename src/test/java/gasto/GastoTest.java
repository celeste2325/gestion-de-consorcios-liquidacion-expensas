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
    private Gasto luz;
    private Gasto agua;
    private Gasto gas;
    private Gasto mantAscensores;
    private Gasto mantPartesComunes;


    @BeforeEach
    public void init() {

        Persona inquilino1 = new Persona("Camila", "Rodriguez", "9584712", "camila@gmail.com", "1151745896", false, null);

        Persona inquilino2 = new Persona("Candela", "Perez", "91785412", "candela@gmail.com", "1196325412", false, null);
        Persona propietario1 = new Persona("Josue", "Velasquez", "9354785", "josue@gmail.com", "1156987424", true, null);
        Persona propietario2 = new Persona("Tomas", "Benitez", "90542871", "tomas@gmail.com", "1156398741", true, null);

        this.consorcio = new Consorcio("000000", "pepito", "pepitoA", "27896421");

        UnidadFuncional unidFunc1 = new UnidadFuncional(consorcio, 25, 25);
        unidFunc1.addInquilinos(inquilino1, inquilino2, propietario1);
        UnidadFuncional unidFunc2 = new UnidadFuncional(consorcio, 20, 20);
        unidFunc2.addInquilinos(inquilino2, propietario2);

        consorcio.addUnidadesFuncionales(unidFunc1, unidFunc2);

        this.controladorConsorcio = ControladorConsorcios.getInstance();
        this.controladorConsorcio.addConsorcios(this.consorcio);

        this.luz = new Gasto(8000, TipoExpensa.ORDINARIA, true, LocalDate.now());
        this.agua = new Gasto(12000, TipoExpensa.ORDINARIA, true, LocalDate.now());
        this.gas = new Gasto(15000, TipoExpensa.ORDINARIA, true, LocalDate.now());

        this.mantAscensores = new Gasto(6000, TipoExpensa.EXTRAORIDINARIA, false, LocalDate.now());
        this.mantPartesComunes = new Gasto(30000, TipoExpensa.EXTRAORIDINARIA, false, LocalDate.now());
    }

    @Test
    public void sumaGastosDeExpensaOrdinariaDevuelve3500() {
        this.controladorConsorcio.cargarGastos(this.consorcio.getCuit(), luz, agua, gas);
        Assertions.assertEquals(35000, this.controladorConsorcio.sumarGastosPorTipoExpensa(this.consorcio.getCuit(), TipoExpensa.ORDINARIA));
    }

    @Test
    public void sumaGastosDeExpensaExtraOrdinariaDevuelve36000() {
        this.controladorConsorcio.cargarGastos(this.consorcio.getCuit(), mantAscensores, mantPartesComunes);
        Assertions.assertEquals(36000, this.controladorConsorcio.sumarGastosPorTipoExpensa(this.consorcio.getCuit(), TipoExpensa.EXTRAORIDINARIA));
    }

    @Test
    public void devuelveTotalDeGastosGenerales_56000() {
        this.sumaGastosDeExpensaOrdinariaDevuelve3500();
        this.sumaGastosDeExpensaExtraOrdinariaDevuelve36000();
        Assertions.assertEquals(70700.0, this.controladorConsorcio.calcularExpensa(this.consorcio.getCuit()));
    }

}

