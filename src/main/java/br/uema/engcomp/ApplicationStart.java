package br.uema.engcomp;

import br.uema.engcomp.apresentation.Login;
import br.uema.engcomp.models.query.QUsuario;

public class ApplicationStart {
    public static void main(String args[]){
        Login login = new Login();
        login.setVisible(true);
    }
}
