package br.maua.throwables;

public class ForaDoRangeException extends Exception {

	public ForaDoRangeException(){} // Construtor SEM mensagem personalizada

	public ForaDoRangeException(String msgm){ super(msgm); } // Construtor COM mensagem personalizada
}
