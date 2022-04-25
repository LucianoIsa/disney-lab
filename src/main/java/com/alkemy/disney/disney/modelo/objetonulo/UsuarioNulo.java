package com.alkemy.disney.disney.modelo.objetonulo;

import com.alkemy.disney.disney.modelo.Usuario;

public class UsuarioNulo extends Usuario{

    public static Usuario construir() {
        return new UsuarioNulo();
    }

    @Override
    public boolean esNulo() {
        return true;
    }
}
