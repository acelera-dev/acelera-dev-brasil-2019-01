package org.acelera.saopaulo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class App3
{
	public static void main(String[] args)
	{
		List<Integer> numeros = new ArrayList<>();
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		
//		for (int index = 1; index <= 1_000; index++)
//		{
//			numeros.add(index);
//		}
//
//		numeros.forEach(x ->
//		{
//			if (x % 2 == 0)
//			{
//				pares.add(x);
//			}
//			else
//			{
//				impares.add(x);
//			}
//		});

		Stream.iterate(1, n -> ++n).limit(1_000).forEach(n ->
		{
			numeros.add(n);
			if (n % 2 == 0) { pares.add(n); }
			else { impares.add(n); }
		});
		
		System.out.println("numeros ");
		numeros.forEach(System.out::println);
		
		System.out.println("pares ");
		pares.forEach(System.out::println);
		
		System.out.println("impares ");
		impares.forEach(System.out::println);
	}
}
