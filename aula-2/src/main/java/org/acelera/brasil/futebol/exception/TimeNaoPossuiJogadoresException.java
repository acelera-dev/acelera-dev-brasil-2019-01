package org.acelera.brasil.futebol.exception;

/**
 * Classe responsável pela representação da exceção que ocorre, caso seja
 * solicitado algum jogador de um time que não possui jogadores.
 * 
 * @author edmilson.santana
 *
 */
public class TimeNaoPossuiJogadoresException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5827961688675816532L;
	private static final String MSG_TIME_NAO_POSSUI_JOGADORES = "O time não possui jogadores.";

	public TimeNaoPossuiJogadoresException() {
		super(MSG_TIME_NAO_POSSUI_JOGADORES);
	}
}
