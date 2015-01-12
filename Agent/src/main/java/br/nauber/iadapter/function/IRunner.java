package br.nauber.iadapter.function;

import org.jgap.IChromosome;

public interface IRunner {

	public double run(IChromosome chromosome);

	public double stop(IChromosome chromosome);
}
