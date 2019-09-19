package problems;

import java.util.Arrays;

public class ClosestSumImpl implements ClosestSum {

	/**
	 * Restricoes: - voce nao pode usar nenhum metodo pronto de qualquer biblioteca.
	 */
	public ParIndices closestSum(Integer[] array, Integer x) {
		ParIndices p = new ParIndices(null, null);

		if (array.length > 1) {
			Integer primeiro = array[0];
			Integer segundo = array[1];

			int soma = array[0] + array[1];

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					Integer aux = array[i] + array[j];
					if (i != j) {
						if (Math.abs(x - aux) < Math.abs(x - soma)) {
							soma = aux;
							primeiro = array[i];
							segundo = array[j];

						}

					}

				}
			}
			p.setPrimeiro(primeiro);
			p.setSegundo(segundo);
		}

		return p;
	}

	public static void main(String[] args) {
		ClosestSumImpl c = new ClosestSumImpl();
		Integer[] array = { 1,3,13 };
		System.out.println(c.closestSum(array, 12));
	}
}
