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

	private static int numberMaxPlayers;

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

	public List<IChromosome> getAtacantes() {
		return atacantes;
	}

	public void setAtacantes(List<IChromosome> atacantes) {
		this.atacantes = atacantes;
	}

	public static int getNumberMaxPlayers() {
		return numberMaxPlayers;
	}

	public static void setNumberMaxPlayers(int numberMaxPlayers) {
		Game.numberMaxPlayers = numberMaxPlayers;
	}

	public List<IChromosome> getDefensores() {
		return defensores;
	}

	public void setDefensores(List<IChromosome> defensores) {
		this.defensores = defensores;
	}

	private int numberOfPlayers;

	private List<IChromosome> atacantes = new ArrayList<IChromosome>();
	private List<IChromosome> defensores = new ArrayList<IChromosome>();;

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	public static void main(String[] args) throws InvalidConfigurationException {

		Game.getRunnersAtack().add(new SeleniumRunner());
		Game.getRunnersDefend().add(new TomCatRunner());

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

		Configuration.reset();
		Configuration confScript = new DefaultConfiguration();
		confScript.reset();

		FitnessFunction myFuncScript = new ScriptFunctionEvaluation();

		confScript.setFitnessFunction(myFuncScript);

		Gene[] sampleGenesScript = new Gene[2];
		sampleGenesScript[0] = new IntegerGene(confScript, 8080, 9090);
		sampleGenesScript[1] = new IntegerGene(confScript, 100, 9090);

		Chromosome chromossomeScript = new Chromosome(confScript,
				sampleGenesScript);

		confScript.setSampleChromosome(chromossomeScript);

		confScript.setPopulationSize(3);

		Genotype populationScript = Genotype.randomInitialGenotype(confScript);

		System.out.println(populationScript.getChromosomes().length);
		System.out.println(population.getChromosomes().length);

		Game.defendPopulation = population.getPopulation();
		Game.atackPopulation = populationScript.getPopulation();

		populationScript.evolve();

	}

}
