package com.sap.co2.emission.calc.service;

import java.io.IOException;
import java.math.BigDecimal;

public class Co2EmissionCalculatorDemo {

	public static void main(String[] args) {

		IView iView = new Console();

		while (true) {
			try {
				// STEP1 : read input
				String input = iView.read();

				// STEP2:build input for Calculator
				CalculatorInputBuilder builder = new CalculatorInputBuilder();
				EmissionCalculatorInput calculatorInput = builder.build(input);

				Co2EmissionCalculator co2EmissionCalculator = new Co2EmissionCalculator();
				BigDecimal co2Value = co2EmissionCalculator.calcuate(calculatorInput.getTransportationMethod(),
						calculatorInput.getDistance(), calculatorInput.getUnitOfDistance(),
						calculatorInput.getCo2EquivalentUnit());

				// STEPN: print output
				iView.print("Your trip caused 507.7kg of CO2-equivalent");
				continue;
			} catch (IOException e) {
				iView.print("Eorror during I/O Operations" + e.getMessage());
				break;
			}

		}

	}

}
