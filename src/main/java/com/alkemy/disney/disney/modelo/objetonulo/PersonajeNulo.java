package com.alkemy.disney.disney.modelo.objetonulo;

import com.alkemy.disney.disney.modelo.Personaje;

public class PersonajeNulo extends Personaje {

    public static Personaje construir() {
        return new PersonajeNulo();
    }

    @Override
    public boolean esNulo() {
        return true;
    }
}
