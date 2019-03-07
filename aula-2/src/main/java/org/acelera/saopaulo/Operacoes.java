package org.acelera.saopaulo;

public class Operacoes
{

	public int soma()
	{
		Operacao<Integer, Integer> op = (a, b) ->
		{
			return a + b;
		};
		return op.apply(3, 4);
	}

	public int subtracao()
	{
		Operacao<Integer, Integer> op = (a, b) ->
		{
			return a - b;
		};
		return op.apply(3, 4);
	}

	public int multiplicacao()
	{
		Operacao<Integer, Integer> op = (a, b) ->
		{
			return a * b;
		};
		return op.apply(3, 4);
	}

	public int divisao()
	{
		Operacao<Integer, Integer> op = (a, b) ->
		{
			if (b == 0) throw new ArithmeticException("Não é possível realizar divisões por zero !");
			return a / b;
		};
		return op.apply(3, 4);
	}
}
