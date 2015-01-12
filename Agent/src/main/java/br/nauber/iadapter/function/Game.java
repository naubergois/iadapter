package br.nauber.iadapter.function;

import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

public class Game {

	private int initalPopulation;

	public static Population defendPopulation;
	public static Population atackPopulation;

	private static List<IRunner> runnersAtack = new ArrayList();

	private static List<IRunner> runnersDefend = new ArrayList();

	

	public static List<IRunner> getRunnersAtack() {
		return runnersAtack;
	}

	public static void setRunnersAtack(List<IRunner> runnersAtack) {
		Game.runnersAtack = runnersAtack;
	}

	public static List<IRunner> getRunnersDefend() {
		return runnersDefend;
	}

	public void setRunnersDefend(List<IRunner> runnersDefend) {
		Game.runnersDefend = runnersDefend;
	}

	public static void init(List<TestGene> sampleGenesAtackList,
			List<TestGene> sampleGenesDefendList, int populationSize)
			throws InvalidConfigurationException {
		Configuration conf = new DefaultConfiguration();

		FitnessFunction myFunc = new DefendFunctionEvaluation();

		conf.setFitnessFunction(myFunc);

		Gene[] sampleGenesDefend = new Gene[sampleGenesDefendList.size()];

		int counter = 0;

		for (TestGene gene : sampleGenesDefendList) {
			if (gene instanceof IntGene) {
				sampleGenesDefend[counter] = new IntegerGene(conf,
						((IntGene) gene).getMin(), ((IntGene) gene).getMax());
				counter++;
			}

		}

		Chromosome chromossome = new Chromosome(conf, sampleGenesDefend);

		conf.setSampleChromosome(chromossome);

		conf.setPopulationSize(populationSize);

		Genotype population = Genotype.randomInitialGenotype(conf);

		Configuration.reset();
		Configuration confScript = new DefaultConfiguration();

		FitnessFunction myFuncScript = new AtackFunctionEvaluation();

		confScript.setFitnessFunction(myFuncScript);

		Gene[] sampleGenesAtack = new Gene[sampleGenesAtackList.size()];

		counter = 0;

		for (TestGene gene : sampleGenesAtackList) {
			if (gene instanceof IntGene) {
				sampleGenesAtack[counter] = new IntegerGene(conf,
						((IntGene) gene).getMin(), ((IntGene) gene).getMax());
				counter++;
			}

		}

		Chromosome chromossomeScript = new Chromosome(confScript,
				sampleGenesAtack);

		confScript.setSampleChromosome(chromossomeScript);

		confScript.setPopulationSize(populationSize);

		Genotype populationScript = Genotype.randomInitialGenotype(confScript);

		Game.defendPopulation = population.getPopulation();
		Game.atackPopulation = populationScript.getPopulation();

		populationScript.evolve();
	}

	public static void main(String[] args) throws InvalidConfigurationException {

		Game.getRunnersAtack().add(new SeleniumRunner());
		Game.getRunnersDefend().add(new TomCatRunner());

		List<TestGene> listDefend = new ArrayList();
		listDefend.add(new IntGene(8080, 9090));
		listDefend.add(new IntGene(1, 9090));

		List<TestGene> listAtack = new ArrayList();
		listAtack.add(new IntGene(8080, 9090));
		listAtack.add(new IntGene(1, 9090));

		Game.init(listAtack, listDefend, 2);

	}

}
