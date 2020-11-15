package com.sap.co2.emission.calc.service;

import java.io.IOException;

public class Co2EmissionCalculatorDemo {

	public static void main(String[] args) {

		IView iView = new Console();

		while (true) {
			try {
				// STEP1 : read input
				String input = iView.read();

				// STEP2:build input for Calculator
				String co2Value = execute(input);

				// STEP3: print output
				iView.print(co2Value);
				continue;
			} catch (IOException e) {
				iView.print("Eorror during I/O Operations" + e.getMessage());
				break;
			}

		}

	}

	public static String execute(String input) throws IOException {
		CalculatorInputBuilder builder = new CalculatorInputBuilder();
		EmissionCalculatorInput calculatorInput = builder.build(input);

		Co2EmissionCalculator co2EmissionCalculator = new Co2EmissionCalculator();
		String co2Value = co2EmissionCalculator.calcuateco2(calculatorInput.getTransportationMethod(),
				calculatorInput.getDistance(), calculatorInput.getUnitOfDistance(),
				calculatorInput.getCo2EquivalentUnit());
		return co2Value;
	}

}
