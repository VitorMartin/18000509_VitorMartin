package br.maua.throwables;

/**
 * {@link Exception} para quando a entrada procurada não se encontra na DB.
 */
public class EntradaNaoEncontradaException extends Exception {

	public  EntradaNaoEncontradaException(){}

	public EntradaNaoEncontradaException(String message) { super(message); }
}
