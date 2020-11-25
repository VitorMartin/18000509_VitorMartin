package br.maua.classes;

import br.maua.interfaces.Seguranca;


/**
 * Classe Usuario, onde é guardado as informações do usuário.
 */

public class Usuario implements Seguranca {

    /**
     * Nome do usuário.
     */
    private final String nome;
    /**
     * Email do usuário.
     */
    private final String email;
    /**
     * Senha do usuário. Essa senha será comparada com a senha mestre.
     * Se for igual, o atributo Usuario.isAdmin será true, se não for, será falso.
     * 
     * @see #autenticarSenha(String) 
     */
    private final String senha;
    /**
     * Se usuario tem privilégios de administrador ou não.
     * 
     * @see #autenticarSenha(String)
     */
    public  final boolean isAdmin;

    /**
     * Construtor da classe Usuario. Apenas preenche os atributos da classe.
     *
     * @param nome {@link #nome}
     * @param email {@link #email}
     * @param senha {@link #senha}
     */
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.isAdmin = autenticarSenha(senha);
    }

    // SETTERS E GETTERS
    /**
     * Getter para o atributo Usuario.nome
     *
     * @return Retorna o nome do usuário instanciado.
     * @see #nome
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Override to método Object.toString().
     *
     * @return Retorna a instância da classe Usuario em forma de String.
     * @see Usuario
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", existe='" + isAdmin + '\'' +
                '}';
    }

    /**
     * Método para autenticar a senha que essa instância do usuário possui.
     * <p>
     * Se for igual à senha mestre, o atributo Usuario.isAdmin se torna true, se não for, se torna false.
     *
     * @param senha Senha do usuário.
     * @return Retorna true ou false para a comparação entre a senha do usuário e a senha mestre.
     * @see Seguranca#autenticarSenha(String) 
     */
    @Override
    public boolean autenticarSenha(String senha) {
        String senhaMestre = "123456";
        return senha.equals(senhaMestre);
    }
}
