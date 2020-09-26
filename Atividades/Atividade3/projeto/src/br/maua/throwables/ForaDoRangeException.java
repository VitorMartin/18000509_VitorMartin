package br.maua.throwables;

/**
 * {@link Exception} para quando o número inputado pelo usúario está fora do intervalo exigido.
 */
public class ForaDoRangeException extends Exception {

	public ForaDoRangeException(){}

	public ForaDoRangeException(String msgm){ super(msgm); }
}
