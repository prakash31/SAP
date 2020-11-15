package com.sap.co2.emission.calculator;

import java.io.IOException;

import com.sap.co2.emission.calc.service.Co2EmissionCalculatorDemo;

import junit.framework.TestCase;

public class Co2EmissionCalculatorTest extends TestCase {

	public void testCalcuatewithTrnsmtdDistanceAndUnit() throws IOException {

		assertEquals("Your trip caused 2.6kg of CO2-equivalent.", Co2EmissionCalculatorDemo
				.execute("--transportation-method medium-diesel-car --distance 15 --unit-of-distance km"));

	}

	public void testCalcuatewithTrnsmtdDistancediffOrder() throws IOException {

		assertEquals("Your trip caused 507.7kg of CO2-equivalent.",
				Co2EmissionCalculatorDemo.execute("--distance 1800.5 --transportation-method large-petrol-car"));

	}

	public void testCalcuatewithTrnsmtdDistanceAndUnitM() throws IOException {

		assertEquals("Your trip caused 0.1kg of CO2-equivalent.", Co2EmissionCalculatorDemo
				.execute("--transportation-method train --distance 14500 --unit-of-distance m"));

	}

	public void testCalcuatewithTrnsmtdDistanceAndOutputUnit() throws IOException {

		assertEquals("Your trip caused 0.1kg of CO2-equivalent.", Co2EmissionCalculatorDemo
				.execute("--transportation-method train --distance 14500 --unit-of-distance m --output kg"));

	}

	public void testCalcuatewithEqualsSeparator() throws IOException {

		assertEquals("Your trip caused 2.6kg of CO2-equivalent.", Co2EmissionCalculatorDemo
				.execute("--unit-of-distance=km --distance 15 --transportation-method=medium-diesel-car"));

	}

}
