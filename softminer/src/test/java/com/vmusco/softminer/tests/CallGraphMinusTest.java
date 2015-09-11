package com.vmusco.softminer.tests;

import org.junit.Test;

import com.vmusco.softminer.graphs.Graph;

public class CallGraphMinusTest extends CallGraphAbstractTest {

	private GraphBuilderObtainer localHelper() {
		return DepGraphTestHelper.testPkgAndGenerateBuilderMinusCallGraphFactory();
	}
	
	public CallGraphMinusTest() {
		super(DepGraphTestHelper.testPkgAndGenerateBuilderMinusCallGraphFactory());
	}
	
	@Test
	public void testVariableUsage() throws Exception{

	}

	@Test
	public void testInterfaceAndLinking() throws Exception{

	}

	@Test
	public void testAbstractAndInheritanceClasses() throws Exception {

	}

	@Test
	public void testInterfaceAndInheritance() throws Exception {

	}

	@Override
	public void testSimpleInheritanceConnectedToAbstract() throws Exception {
		CallGraphFTest t = new CallGraphFTest();
		t.setGraphBuilderObtainer(localHelper());
		t.testSimpleInheritanceConnectedToAbstract();
	}

	@Override
	public void testSimpleInheritanceConnectedToImplementation() throws Exception {
		DepGraphTestHelper dgth = new DepGraphTestHelper(getGraphBuilderObtainer(), com.vmusco.softminer.tests.cases.testSimpleInheritanceConnectedToImplementation.Impl.class);
		Graph dg = dgth.getGraph();
		
		String abs = dgth.formatAtom("Abs()");
		String impl = dgth.formatAtom("Impl()");
		String impl_fct = dgth.formatAtom("Impl.fct()");
		String abs_foo = dgth.formatAtom("Abs.foo()");
		String impl_foo = dgth.formatAtom("Impl.foo()");
		
		dgth.fullAssertGraph(3, 2);
		
		dgth.fullAssertNode(
				impl_fct, 
				new String[]{}, 
				new String[]{impl});

		dgth.fullAssertNode(
				impl, 
				new String[]{impl_fct}, 
				new String[]{abs});
		

		dgth.fullAssertNode(
				abs, 
				new String[]{impl}, 
				new String[]{});
		
	}
}
