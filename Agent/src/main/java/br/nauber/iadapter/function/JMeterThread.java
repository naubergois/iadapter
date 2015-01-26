package br.nauber.iadapter.function;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.save.SaveService;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jmeter.visualizers.SimpleDataWriter;
import org.apache.jmeter.visualizers.ViewResultsFullVisualizer;
import org.apache.jorphan.collections.HashTree;

public class JMeterThread extends Thread {
	
	public JMeterThread(int users){
		this.users=users;
	}

	private long time;
	
	private int users;

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getUsers() {
		return users;
	}

	public void setUsers(int users) {
		this.users = users;
	}

	public JMeterThread(String script,int users) {
		this.scriptJMeter = script;
		this.users=users;
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
			JMeterUtils.setJMeterHome(workingDir + "/apache-jmeter-2.12/");
			JMeterUtils.initLogging();// you can comment this line out to see
										// extra log messages of i.e. DEBUG
										// level
			
			JMeterUtils.setProperty("Gthreads", String.valueOf(users));
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

	public static void main(String args[]) {
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
			JMeterUtils.setProperty("Gthreads", "2");

			JMeterUtils.initLocale();

			// JMeterUtils.loadProperties(workingDir
			// + "/apache-jmeter-2.12/bin/saveservice.properties");
			// Initialize JMeter SaveService
			SaveService.loadProperties();

			// Load existing .jmx Test Plan
			FileInputStream in = new FileInputStream(workingDir
					+ "/apache-jmeter-2.12/script1.jmx");
			HashTree testPlanTree = SaveService.loadTree(in);
			Object[] objects = testPlanTree.getArray();

			TestPlan plan = (TestPlan) objects[0];
			
			SimpleDataWriter writer=new SimpleDataWriter();
			writer.setFile(workingDir+"/teste.csv");
			

			testPlanTree.add("monitor", writer);
			in.close();

			// Run JMeter Test
			
			jmeter.configure(testPlanTree);
			
			jmeter.run();

			System.out.println(testPlanTree);

			for (Object object : objects) {
				System.out.println(object);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
