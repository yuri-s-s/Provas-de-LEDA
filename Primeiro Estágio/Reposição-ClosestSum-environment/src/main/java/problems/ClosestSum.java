package problems;

/**
 * Dado um array arbitrario nao necessariamente ordenado de inteiros (Integer) e um parametro x, 
 * closestSum(array,x) retorna o par de elementos diferentes do array cuja soma 
 * mais se aproxima de x. 
 * 
 * Exemplo: closestSum([4,6,8,10],7) = (4,6) porque 4 + 6 eh a soma que mais se aproxima de 7
 * closestSum([4,6,8,10],12) = (4,8) porque 4 + 8 eh a soma que mais se aproxima de 12
 * 
 * @author Adalberto e Campelo
 *
 */
public interface ClosestSum {
	/**
	 * Retorna o par de elementos do array (i,j), tal que i + j  
	 *  mais se aproxima de x. Caso exista mais de uma resposta, retorne a primeira que encontrar.
	 * 
	 * @param array
	 * @return .
	 * 
	 * Restricoes:
	 * - voce pode assumir que o array nao tem elementos repetidos
	 * - todo e qualquer codigo que voce escrever/precisar deve estar na sua classe de implementacao.
	 * - caso a soma procurada nao exista no array, o metodo deve retornar um par sem nenhum dos 
	 *   numeros preenchidos.
	 * OBSERVE AS RESTRICOES ESPECIFICAS NA CLASSE QUE VOCE VAI IMPLEMENTAR!
	 */
	public ParIndices closestSum(Integer[] array, Integer x);

}

/**
 * Classe usada para retornar o par de elementos. Use-a para retornar sua resposta.
 * @author adalbertocajueiro
 *
 */
class ParIndices{
	Integer primeiro;
	Integer segundo;
	
	public ParIndices(Integer primeiro, Integer segundo) {
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	
	public Integer getPrimeiro() {
		return primeiro;
	}


	public void setPrimeiro(Integer primeiro) {
		this.primeiro = primeiro;
	}


	public Integer getSegundo() {
		return segundo;
	}


	public void setSegundo(Integer segundo) {
		this.segundo = segundo;
	}


	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof ParIndices) {
			result = this.primeiro.equals(((ParIndices) obj).getPrimeiro())
					&& this.segundo.equals(((ParIndices) obj).getSegundo());
		}
		return result;
	}


	@Override
	public String toString() {
		
		return "(" + this.getPrimeiro() + "," + this.getSegundo() + ")";
	}
	
	
	
}
