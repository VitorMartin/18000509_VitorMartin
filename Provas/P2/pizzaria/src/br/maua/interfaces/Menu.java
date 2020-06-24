package br.maua.interfaces;

import br.maua.classes.Usuario;
import br.maua.maps.Pagamentos;

public interface Menu {

    static void login(){
        System.out.println(
            "\nDigite seu nome, email e senha, apertando [ENTER] entre cada um: \n"
        );
    }

    static void saudacao(Usuario usr){
        // Template de como essa string deve ficar:
        /*
        Bem-vindo, ${NOME}!
        Voce ${NAO} esta registrado como Admin.
         */
        String str = "\nBem-vindo, " + usr.getNome() + "!\nVoce";
        str += usr.isAdmin ? "" : " NAO";
        str += " esta registrado como Admin.\n";

        System.out.println(str);
    }

    static void despedida(){
        System.out.println("Ate mais!");
    }

    static void opcoesDePagamento(){
        System.out.println("Formas de pagamento:");
        System.out.println(Pagamentos.mapToString());
    }

    static void menuPrincipal() {
        System.out.println(
            "\nPizzaria o Rato que Ri:" + '\n' +
            "1 - Novo pedido" + '\n' +
            "2 - Mostrar pedidos" + '\n' +
            "3 - Alterar estado do pedido" + '\n' +
            "9 - Sair"
        );
    }
}
