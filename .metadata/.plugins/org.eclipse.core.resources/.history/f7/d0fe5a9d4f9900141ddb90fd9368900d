package br.nauber.iadapter.function;

import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Genotype;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;

public class Game {

	public static void main(String[] args) {

		Configuration conf = new DefaultConfiguration();

		// Set the fitness function we want to use, which is our
		// MinimizingMakeChangeFitnessFunction that we created earlier.
		// We construct it with the target amount of change provided
		// by the user.
		// ------------------------------------------------------------

		try {
			TomCatChromossome chromosome = new TomCatChromossome();
			conf.setSampleChromosome(chromosome);

			FitnessFunction myFunc = new ServerFunctionEvaluation();

			conf.setFitnessFunction(myFunc);

			conf.setPopulationSize(1);

			Genotype population = Genotype.randomInitialGenotype(conf);

			population.evolve();

		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
