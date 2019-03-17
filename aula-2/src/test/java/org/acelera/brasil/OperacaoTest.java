package org.acelera.brasil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Classe responsável pelo teste das operações matemáticas definidas em {@link Operacoes}.
 * 
 * @author edmilson.santana
 *
 */
@RunWith(JUnitPlatform.class)
public class OperacaoTest {

	private Operacao soma;
	private Operacao subtracao;
	private Operacao multiplicacao;
	private Operacao divisao;
	
	@BeforeEach
	public void setUp() {
		soma = Operacoes.SOMA;
		subtracao = Operacoes.SUBTRACAO;
		multiplicacao = Operacoes.MULTIPLICACAO;
		divisao = Operacoes.DIVISAO;
	}
	
	@Test
	public void deveRealizarSomaDeNumeroPositivo() {
		assertEquals(7, soma.operar(5, 2));
	}
	
	@Test
	public void deveRealizarSomaDeNumeroNegativo() {
		assertEquals(3, soma.operar(5, -2));
	}
	
	@Test
	public void deveRealizarSubtracaoDeNumeroPositivo() {
		assertEquals(3, subtracao.operar(5, 2));
	}
	
	@Test
	public void deveRealizarSubtracaoDeNumeroNegativo() {
		assertEquals(3, subtracao.operar(2, -1));
	}
	
	@Test
	public void deveRealizarMultiplicacaoDeNumeroPositivo() {
		assertEquals(10, multiplicacao.operar(2, 5));
	}
	
	@Test
	public void deveRealizarMultiplicacaoDeNumeroNegativo() {
		assertEquals(-10, multiplicacao.operar(-2, 5));
	}
	
	@Test
	public void deveRealizarDivisaoDeNumeroPositivo() {
		assertEquals(10, divisao.operar(20, 2));
	}
	
	@Test
	public void deveRealizarDivisaoDeNumeroNegativo() {
		assertEquals(-2, divisao.operar(-6, 3));
	}
	
	@Test
	public void deveOcorrerErroQuandoDividirPorZero() {
		assertThrows(IllegalArgumentException.class, () -> divisao.operar(-6, 0));
	}
	
}
