package br.uema.engcomp;

import br.uema.engcomp.models.query.QUsuario;

public class ApplicationStart {
    public static void main(String args[]){
        System.out.println("Teste");
        System.out.println(new QUsuario().findOne());
    }
}
