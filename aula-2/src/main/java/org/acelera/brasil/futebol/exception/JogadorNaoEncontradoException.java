package org.acelera.brasil.futebol.exception;
/**
 * Classe responsável pela representação da exceção que ocorre, caso seja
 * solicitado um jogador que não existe.
 *
 * @author michael.ulguim
 *
 */
public class JogadorNaoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 4312021490860658316L;
    private static final String MSG_JOGADOR_NAO_ENCONTRADO = "O jogador não foi encontrado.";

    public JogadorNaoEncontradorException() {
        super(MSG_JOGADOR_NAO_ENCONTRADO);
    }
}
