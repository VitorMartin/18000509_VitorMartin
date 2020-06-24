package br.maua.interfaces;

import br.maua.funcionario.Usuario;

public interface Menu {

    static void login(){
        System.out.println(
            "Digite seu nome, email e senha, apertando [ENTER] entre cada um: "
        );
    }

    static void saudacao(Usuario usr){
        // Template de como essa string deve ficar:
        /*
        Bem-vindo, ${NOME}!
        Voce ${NAO} esta registrado como Admin.
         */
        String str = "Bem-vindo, " + usr.getNome() + "!\nVoce";
        str += usr.isAdmin ? "" : " NAO";
        str += " esta registrado como Admin.";

        System.out.println(str);
    }

    static void menuPrincipal() {
        System.out.println(
            "Pizzaria o Rato que Ri:" + '\n' +
            "1 - Novo pedido" + '\n' +
            "2 - Mostrar pedidos" + '\n' +
            "3 - Alterar estado do pedido" + '\n' +
            "9 - Sair"
        );
    }
}
