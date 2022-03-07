package br.gov.rj.detran.devops.lib.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.gov.rj.detran.devops.lib.properties.app.PropertiesApp;
import br.gov.rj.detran.devops.lib.properties.exception.PropertieNotFound;

public class PropertiesTest {

	private static final String VALUE = "teste";
	private static final String KEY = "testProperties";

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void before() {
		System.setProperty(KEY, VALUE);
	}

	@Test
	public void testProperties() {
		assertEquals(VALUE, PropertiesApp.instance().getPropertie(KEY).getValue());
	}

	@Test
	public void testPropertiesErro() {
		exceptionRule.expect(PropertieNotFound.class);
		PropertiesApp.instance().getPropertie("xxxx").getValue();
	}

}
