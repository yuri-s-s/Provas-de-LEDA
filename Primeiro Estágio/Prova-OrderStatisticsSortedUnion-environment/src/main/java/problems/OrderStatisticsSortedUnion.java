package problems;

/**
 * Dado dois arrays ordenados em ordem crescente, encontrar a k-esima
 * estatistica de ordem da uniao ordenada deles.
 * 
 * Restricoes: - os arrays nao possuem elementos em comum e nem repetidos - k eh
 * um numero compreendido entre 1 e array1.length + array2.length - caso o
 * k-esima estatistica de ordem nao exista, o metodo deve retornar null - voce
 * nao pode usar memoria extra - seu algoritmo deve ter complexidade
 * O(array1.length + array2.length). - voce nao pode usar nenhum metodo pronto
 * de manipulacao de arrays, exceto length.
 * 
 * @author adalbertocajueiro
 *
 */
public class OrderStatisticsSortedUnion<T extends Comparable<T>> {
	public T statisticsOrder(T[] array1, T[] array2, int k) {

		T menor = null;
		int cont1 = 0;
		int cont2 = 0;

		while (k > 0 && cont1 < array1.length && cont2 < array2.length) {

			if (array1[cont1].compareTo(array2[cont2]) < 0) {
				menor = array1[cont1];
				cont1++;
			} else {
				menor = array2[cont2];
				cont2++;
			}

			k--;
		}

		while (k > 0 && cont1 < array1.length) {
			menor = array1[cont1];
			cont1++;
			k--;
		}

		while (k > 0 && cont2 < array2.length) {
			menor = array2[cont2];
			cont2++;
			k--;
		}

		if (k > 0)
			return null;
		return menor;
	}

	public static void main(String[] args) {
		OrderStatisticsSortedUnion<Integer> o = new OrderStatisticsSortedUnion<Integer>();
		Integer[] array1 = { 1, 2, 3, 4, 5, 12 };
		Integer[] array2 = { 0, 7, 15, 16 };

		System.out.println(o.statisticsOrder(array1, array2, 8));
	}
}
