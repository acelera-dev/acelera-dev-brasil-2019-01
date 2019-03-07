package org.acelera.saopaulo;

public class Operacoes{
	
	public static int soma(int a, int b) {
		Operacao<Integer, Integer> soma = (x,y) -> { return x+y;};
		return soma.operar(a,b);
	}
	
	public static int subtracao(int a, int b) {
		Operacao<Integer, Integer> subtracao = (x,y) -> { return x-y;};
		return subtracao.operar(a,b);
	}
	
	public static int multiplicacao(int a, int b) {
		Operacao<Integer, Integer> multiplicacao = (x,y) -> {return x*y;};
		return multiplicacao.operar(a,b);
	}
	
	public static int divisao(int a, int b) {
		Operacao<Integer, Integer> divisao = (x,y) -> {
			if(y == 0)
				throw new ArithmeticException("Não é possível realizar divisões por zero !");
			else
				return x/y;
			};
		return divisao.operar(a,b);
	}
	
}
