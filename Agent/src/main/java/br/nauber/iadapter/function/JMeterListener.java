package br.nauber.iadapter.function;

import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.testelement.AbstractTestElement;
import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.testelement.TestElementTraverser;
import org.apache.jmeter.testelement.property.JMeterProperty;
import org.apache.jmeter.testelement.property.PropertyIterator;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.visualizers.MonitorGuiListener;
import org.apache.jmeter.visualizers.MonitorModel;
import org.apache.jmeter.visualizers.SimpleDataWriter;
import org.apache.jmeter.visualizers.Visualizer;

public class JMeterListener extends SimpleDataWriter implements
		MonitorGuiListener, Visualizer, TestElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void updateGui() {
		// TODO Auto-generated method stub

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public void updateGui(MonitorModel arg0) {

		System.out.print("teste");
		// TODO Auto-generated method stub

	}

	@Override
	public void add(SampleResult arg0) {

		System.out.print("teste 1");
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStats() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addTestElement(TestElement arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearTestElementChildren() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getComment() {
		// TODO Auto-generated method stub
		return "Teste";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Teste";
	}

	@Override
	public JMeterProperty getProperty(String arg0) {
		System.out.print("teste 1");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getPropertyAsBoolean(String arg0) {
		System.out.print("teste 2");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPropertyAsBoolean(String arg0, boolean arg1) {
		System.out.print("test 3e");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getPropertyAsDouble(String arg0) {
		System.out.print("teste 4");
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float getPropertyAsFloat(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPropertyAsInt(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getPropertyAsInt(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPropertyAsLong(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPropertyAsLong(String arg0, long arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPropertyAsString(String arg0) {
		System.out.print("teste THREAD");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPropertyAsString(String arg0, String arg1) {
		System.out.print("teste THREAD");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JMeterContext getThreadContext() {
		System.out.print("teste THREAD");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getThreadName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRunningVersion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTemporary(JMeterProperty arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PropertyIterator propertyIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void recoverRunningVersion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProperty(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setComment(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(JMeterProperty arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, long arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, long arg1, long arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRunningVersion(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTemporary(JMeterProperty arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setThreadContext(JMeterContext arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setThreadName(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traverse(TestElementTraverser arg0) {
		// TODO Auto-generated method stub

	}

}
