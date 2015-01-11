package br.nauber.iadapter.function;

import org.jgap.Gene;
import org.jgap.impl.IntegerGene;

public class Game {

	public static void main(String[] args) {

		Gene[] sampleGenes = new Gene[4];

	

		TomCatPopulation population = new TomCatPopulation();
		population.start();

		// Set the fitness function we want to use, which is our
		// MinimizingMakeChangeFitnessFunction that we created earlier.
		// We construct it with the target amount of change provided
		// by the user.
		// ------------------------------------------------------------

	}

}
