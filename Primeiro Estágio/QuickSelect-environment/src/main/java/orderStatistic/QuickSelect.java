package orderStatistic;

/**
 * O quickselect eh um algoritmo baseado no quicksort para
 * descobrir/selectionar, em tempo linear, a k-esima estatistica de ordem
 * (k-esimo menor elemento) de um conjunto de dados.
 * 
 * O quiskselect escolhe um elemento para ser o pivot e particiona o array
 * inicial em dois subarrays da mesma forma que o quicksort (elementos menores
 * que o pivot a esquerda do pivot e elementos maiores que o pivot a direita
 * dele). Entretanto, ao inves de chamar o quicksort recursivo nas duas metades,
 * o quickselect eh executado (recursivamente) apenas na metade que contem o
 * elemento que ele procura (o k-esimo menor elemento). Isso reduz a
 * complexidade de O(n.log n) para O(n)
 * 
 * @author Adalberto
 *
 */
public class QuickSelect<T extends Comparable<T>> {

	/**
	 * O algoritmo quickselect usa a mesma abordagem do quicksort para calclar o
	 * k-esimo menor elemento (k-esima estatistica de ordem) de um determinado array
	 * de dados comparaveis. Primeiro ele escolhe um elemento como o pivot e
	 * particiona os daods em duas partes baseado no pivot (exatemente da mesma
	 * forma que o quicksort). Depois disso, ele chama recursivamente o mesmo
	 * algoritmo em apenas uma das metades (a que contem o k-esimo menor elemento).
	 * Isso redua a completixade de O(n.log n) para O(n).
	 * 
	 * Caso o array seja vazio ou a ordem (posicao) do elemento desejado esteja fora
	 * do tamanho do array, o metodo deve retornar null.
	 * 
	 * 
	 * @param array o array de dados a procurar o k-esimo menor elemento.
	 * @param k     a ordem do elemento desejado. 1 significa primeiro menor
	 *              elemento, 2 significa segundo menor elemento e assim por diante
	 * @return
	 */
	public T quickSelect(T[] array, int k) {
		T retorno;
		if (k <= 0)
			retorno = null;
		else
			retorno = quickSelect(array, k - 1, 0, array.length - 1);

		return retorno;
	}

	private T quickSelect(T[] array, int k, int leftIndex, int rightIndex) {

		T retorno = null;

		if (leftIndex <= rightIndex) {

			int p = partition(array, k, leftIndex, rightIndex);

			
			if (p == k)
				retorno = array[p];
			else if (p > k)
				retorno = quickSelect(array, k, leftIndex, p - 1);
			else
				retorno = quickSelect(array, k, p + 1, rightIndex);
		}
		return retorno;
	}

	private int partition(T[] array, int k, int leftIndex, int rightIndex) {

		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				swap(array, i, j);
			}
		}

		swap(array, leftIndex, i);
		return i;
	}

	private void swap(T[] array, int i, int j) {
		T aux = array[i];
		array[i] = array[j];
		array[j] = aux;
	}

	public static void main(String[] args) {
		QuickSelect<Integer> q = new QuickSelect<Integer>();

		Integer[] array = { 5, 4, 7, 2, 1, 6, 6 };
		System.out.println(q.quickSelect(array, 3));
	}
}
