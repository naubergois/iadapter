package br.nauber.iadapter.function;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class TomCatPopulation extends Thread {

	private Gene[] genes;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();

		try {

			Configuration conf = new DefaultConfiguration();

			FitnessFunction myFunc = new ServerFunctionEvaluation();

			conf.setFitnessFunction(myFunc);

			Gene[] sampleGenes = new Gene[2];
			sampleGenes[0] = new IntegerGene(conf, 8080, 9090);
			sampleGenes[1] = new IntegerGene(conf, 100, 9090);

			Chromosome chromossome = new Chromosome(conf, sampleGenes);

			conf.setSampleChromosome(chromossome);

			conf.setPopulationSize(2);

			Genotype population = Genotype.randomInitialGenotype(conf);
			
			System.out.println(population.getChromosomes().length);

			population.evolve();

			IChromosome bestSolutionSoFar = population.getFittestChromosome();

			System.out.println("A melhor configuracao � "
					+ bestSolutionSoFar.getGenes()[1] + " para o timeout ");
			double tempo = Long.MAX_VALUE - bestSolutionSoFar.getFitnessValue();
			System.out.println("A melhor configuracao � " + tempo);

		} catch (InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
