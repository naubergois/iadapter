package br.nauber.iadapter.function;

import java.io.FileInputStream;
import java.util.List;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;

import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;

public class JMeterThread extends Thread {
	
	private long time;
	
	public JMeterThread(String script){
		this.scriptJMeter=script;
	}

	private String scriptJMeter;

	public String getScriptJMeter() {
		return scriptJMeter;
	}

	public void setScriptJMeter(String scriptJMeter) {
		this.scriptJMeter = scriptJMeter;
	}

	@Override
	public void run() {

		try {
			// JMeter Engine
			StandardJMeterEngine jmeter = new StandardJMeterEngine();

			String workingDir = System.getProperty("user.dir");

			// get location of workspace (java.io.File)

			// Initialize Properties, logging, locale, etc.
			JMeterUtils.loadJMeterProperties(workingDir
					+ "/apache-jmeter-2.12/bin/jmeter.properties");
			JMeterUtils.setJMeterHome(workingDir + "/apache-jmeter-2.12/bin");
			JMeterUtils.initLogging();// you can comment this line out to see
										// extra log messages of i.e. DEBUG
										// level
			JMeterUtils.initLocale();

			// Initialize JMeter SaveService
			SaveService.loadProperties();

			// Load existing .jmx Test Plan
			FileInputStream in = new FileInputStream(this.scriptJMeter);
			HashTree testPlanTree = SaveService.loadTree(in);
			in.close();

			// Run JMeter Test
			jmeter.configure(testPlanTree);
			jmeter.run();
			
			System.out.println(testPlanTree);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		// TODO Auto-generated method stub
		super.run();
	}
	
	public static void main(String args[]){
		try {
			// JMeter Engine
			StandardJMeterEngine jmeter = new StandardJMeterEngine();

			String workingDir = System.getProperty("user.dir");
			
			System.out.println(workingDir);

			// get location of workspace (java.io.File)

			// Initialize Properties, logging, locale, etc.
			JMeterUtils.loadJMeterProperties(workingDir
					+ "/apache-jmeter-2.12/bin/jmeter.properties");
			
			
			JMeterUtils.setJMeterHome(workingDir + "/apache-jmeter-2.12/");
			JMeterUtils.initLogging();// you can comment this line out to see
										// extra log messages of i.e. DEBUG
										// level
			
			ListenerJMeter listener=new ListenerJMeter();
			JMeterUtils.initLocale();

			//JMeterUtils.loadProperties(workingDir
				//	+ "/apache-jmeter-2.12/bin/saveservice.properties");
			// Initialize JMeter SaveService
			SaveService.loadProperties();

			// Load existing .jmx Test Plan
			FileInputStream in = new FileInputStream(workingDir
					+ "/apache-jmeter-2.12/script1.jmx");
			HashTree testPlanTree = SaveService.loadTree(in);
			testPlanTree.add("monitor", listener);
			in.close();

			// Run JMeter Test
			jmeter.configure(testPlanTree);
			jmeter.run();
			
			System.out.println(testPlanTree);
			Object[] objects=testPlanTree.getArray();
			
			TestPlan plan=(TestPlan) objects[0];
			
		
			
			
			
			for (Object object : objects) {
				System.out.println(object);	
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
