package br.maua.interfaces;

public interface Menu {

    static void login(){
        System.out.println(
            "Digite seu nome, email e senha, apertando [ENTER] entre cada um: "
        );
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
