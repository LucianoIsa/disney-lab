package com.alkemy.disney.disney.modelo.objetonulo;

import com.alkemy.disney.disney.modelo.Audiovisual;

public class AudiovisualNulo extends Audiovisual {

    public static Audiovisual contruir() {
        return new AudiovisualNulo();
    }

    @Override
    public boolean esNula() {
        return true;
    }
}
