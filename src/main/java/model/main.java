package model;

import controller.CalculadorExpensa;
import controller.ControladorConsorcios;

import java.time.LocalDate;


//los datos de esta clase deben ir en ExpensaTest //TODO
public class main {
    private ControladorConsorcios controladorConsorcio;
    private Consorcio consorcio;
    private Gasto luz;
    private Gasto agua;
    private Gasto gas;
    private Gasto mantAscensores;
    private Gasto mantPartesComunes;
    public static void main(String[] args) {
        ControladorConsorcios controladorConsorcio;
        Consorcio consorcio;
        Persona inquilino1 = new Persona("Camila","Rodriguez", "9584712", "camila@gmail.com", "1151745896", false);
        Persona inquilino2 = new Persona("Candela","Perez", "91785412", "candela@gmail.com", "1196325412", false);
        Persona propietario1 = new Persona("Josue","Velasquez", "9354785", "josue@gmail.com", "1156987424", true);
        Persona propietario2 = new Persona("Tomas","Benitez", "90542871", "tomas@gmail.com", "1156398741", true);

        consorcio = new Consorcio("000000", "boedo 1625", "27896421");

        UnidadFuncional unidFunc1 = new UnidadFuncional(consorcio, 25,70);
        unidFunc1.addInquilinos(inquilino1,inquilino2,propietario1);
        UnidadFuncional unidFunc2 = new UnidadFuncional(consorcio, 20,30);
        unidFunc2.addInquilinos(inquilino2,propietario2);

        consorcio.addUnidadesFuncionales(unidFunc1,unidFunc2);

        controladorConsorcio = new ControladorConsorcios();
        controladorConsorcio.addConsorcios(consorcio);

        Gasto luz = new Gasto(8000, TipoExpensa.ORDINARIA, true, LocalDate.now());
        Gasto agua = new Gasto(12000, TipoExpensa.ORDINARIA, true, LocalDate.now());
        Gasto gas = new Gasto(15000, TipoExpensa.ORDINARIA, true, LocalDate.now());

        Gasto mantAscensores = new Gasto(6000, TipoExpensa.EXTRAORIDINARIA, false, LocalDate.now());
        Gasto mantPartesComunes = new Gasto(30000, TipoExpensa.EXTRAORIDINARIA, false, LocalDate.now());

        controladorConsorcio.cargarGastos(consorcio.getCuit(),mantAscensores,mantPartesComunes,luz,agua);
        double sumaExtraordinaria = controladorConsorcio.sumarGastosPorTipoExpensa(consorcio.getCuit(), TipoExpensa.EXTRAORIDINARIA);
        double sumaOrdinaria = controladorConsorcio.sumarGastosPorTipoExpensa(consorcio.getCuit(), TipoExpensa.ORDINARIA);

        System.out.println(sumaExtraordinaria);
        System.out.println(sumaOrdinaria);

        Expensa docExpensa = new Expensa(LocalDate.now());
        CalculadorExpensa calcExpensa = new CalculadorExpensa();
        calcExpensa.calcularExpensa(controladorConsorcio);
    }
}
