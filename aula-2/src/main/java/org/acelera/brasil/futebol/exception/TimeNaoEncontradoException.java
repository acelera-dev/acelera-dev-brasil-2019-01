package org.acelera.brasil.futebol.exception;

/**
 * Classe responsável pela representação da exceção que ocorre, caso seja
 * solicitado um time que não existe.
 * 
 * @author edmilson.santana
 *
 */
public class TimeNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 134845337538014468L;
	private static final String MSG_TIME_NAO_ENCONTRADO = "O time não foi encontrado.";

	public TimeNaoEncontradoException() {
		super(MSG_TIME_NAO_ENCONTRADO);
	}

}
