package org.acelera.saopaulo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OperacoesTest {

	@Test
	public void somaTest() {				
		assertTrue(Operacoes.soma(10, 15) == 25);
		assertFalse(Operacoes.soma(10, 15) == 100);		
	}
	
	@Test
	public void subtracaoTest() {
		assertTrue(Operacoes.subtracao(10, 15) == -5);
		assertFalse(Operacoes.subtracao(10, 15) == 25);
	}
	
	@Test
	public void multiplicacaoTest() {				
		assertTrue(Operacoes.multiplicacao(10, 15) == 150);
		assertFalse(Operacoes.multiplicacao(10, 15) == 5);
	}
	
	@Test
	public void divisaoTest() {	
		assertTrue(Operacoes.divisao(15, 5) == 3);
		assertFalse(Operacoes.divisao(15, 5) == 10);
		assertThrows(ArithmeticException.class,() -> {
			Operacoes.divisao(4, 0);
		});
	}
	
}
