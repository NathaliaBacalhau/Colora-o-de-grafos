package main;

import java.util.HashMap;
import java.util.Map;

public class ColoracaoGrafo {
	// Matriz de adjacencia
	private int[][] G;
	// Dicionário, keys: vertices e values:cores
	private Map<Integer, Integer> K = new HashMap<>();
	// Quantidade de vertices em G
	private int ordem;

	public ColoracaoGrafo(int[][] G) {
		this.G = G;
		this.ordem = G.length;
		for (int i = 0; i < ordem; i++) {
			K.put(i, 0);
		}

	}

	public void colorir() {
		int corTemp = 0;
		int adjacencia = 0;
		for (int i = 0; i < ordem; i++) {
			for (int j = 0; j < ordem; j++) {
				if (G[i][j] == 1) {

					if (K.get(j) == corTemp) {
						if (adjacencia == corTemp + 1) {
							adjacencia++;
							corTemp += 2 / adjacencia;
						} else
							corTemp++;
						K.put(i, corTemp);
					}

				}
			}
			adjacencia = 0;
			corTemp = 0;
		}
	}

}