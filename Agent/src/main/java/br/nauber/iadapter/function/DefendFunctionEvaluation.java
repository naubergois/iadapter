package br.nauber.iadapter.function;

import java.io.File;

import org.apache.catalina.startup.Tomcat;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

public class DefendFunctionEvaluation extends FitnessFunction {

	@Override
	protected double evaluate(IChromosome a_subject) {

		return Double.MAX_VALUE-Judge.requestGameDefend(a_subject);

	}

}
