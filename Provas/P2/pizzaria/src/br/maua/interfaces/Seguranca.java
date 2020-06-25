package br.maua.interfaces;

/**
 * Interface responsável por autenticar usuários.
 */

public interface Seguranca {

    /**
     * Autentica o usuário. Cada classe é responsável por implementar seu próprio método de
     * autenticação, pois ele pode variar.
     *
     * @param senha Senha passada pelo usuario.
     * @return Retorna verdadeiro ou falso, dependendo da forma que a autenticação foi implementada.
     */
    boolean autenticarSenha(String senha);

}
