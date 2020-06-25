package br.maua.interfaces;

import br.maua.classes.Pedido;
import br.maua.classes.Usuario;
import br.maua.maps.Estados;
import br.maua.maps.Pagamentos;

import java.util.ArrayList;

/**
 * Interface para o menu. Responsável por apresentar todos os menus e opções ao usuário.
 * Essa classe apenas imprime conteúdos na tela, pois quem é responsável por coletar as informações
 * que o usuário digita é a classe Main
 *
 * @see br.maua.Main
 */

public interface Menu {

    /**
     * Menu de login do usuário
     */
    static void login(){
        System.out.println(
            "\nFaca seu login:"
        );
    }

    /**
     * Menu de saudação ao usuário. Também diz se ele é administrador ou não.
     * @param usr Instância de Usuario.
     * @see Usuario
     */
    static void saudacao(Usuario usr){
        // Template de como essa string deve ficar:
        /*
        Bem-vindo, ${NOME}!
        Voce ${NAO} esta registrado como Admin.
         */
        String str = "\nBem-vindo, " + usr.getNome() + "!\nVoce";
        str += usr.isAdmin ? "" : " NAO";
        str += " esta registrado como Admin.";

        System.out.println(str);
    }

    /**
     * Despedida do usuário.
     */
    static void despedida(){
        System.out.println("Ate mais!");
    }

    /**
     * Opçoes de pagamento.
     *
     * @see Pagamentos
     */
    static void opcoesDePagamento(){
        System.out.println("Formas de pagamento:");
        System.out.println(Pagamentos.mapToString());
    }

    /**
     * Opções do estado de um pedido.
     *
     * @see Estados
     */
    static void opcoesDeEstado() {
        System.out.println("Estados possiveis:");
        System.out.println(Estados.mapToString());
    }

    /**
     * Mostra a lista de pedidos criados.
     * @param pedidos ArrayList que guarda todos os pedidos criados.
     */
    static void mostrarPedidos(ArrayList<Pedido> pedidos) {
        StringBuilder str = new StringBuilder();
        for (Pedido p : pedidos) {
            str.append(p.toString()).append("\n");
        }
        System.out.println(str);
    }

    /**
     * Mostra o menu principal.
     */
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
