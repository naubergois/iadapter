package br.nauber.iadapter.function;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class AtackFunctionEvaluation extends FitnessFunction {

	@Override
	protected double evaluate(IChromosome a_subject) {

		
		return Judge.requestGameAtaque(a_subject,true);
	}

}
