package br.nauber.iadapter.function;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class ScriptFunctionEvaluation extends FitnessFunction {

	@Override
	protected double evaluate(IChromosome a_subject) {

		
		return Judge.requestGame(a_subject,true);
	}

}
