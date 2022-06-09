package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Administrador {
    private String nombre;

    public Administrador(String nombre) {
        this.nombre = nombre;
    }

    //TODO
}
