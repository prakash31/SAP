package com.sap.co2.emission.calc.service;

import java.math.BigDecimal;

public class CalculatorInputBuilder {

	private String EQUALS_SEPERATOR = "=";
	private String SPACE_SEPERATOR = " ";

	public EmissionCalculatorInput build(String input) {

		EmissionCalculatorInput calculatorInput = new EmissionCalculatorInput();
		String[] inputStrings = input.split("--");

		for (int i = 1; i < inputStrings.length; i++) {
			String val = inputStrings[i];
			String key = null;
			String value = null;

			if (val.contains(EQUALS_SEPERATOR)) {
				String[] keyValue = val.split(EQUALS_SEPERATOR);
				key = keyValue[0] == null ? null : keyValue[0].trim();
				value = keyValue[1] == null ? null : keyValue[1].trim();

			} else if (val.contains(SPACE_SEPERATOR)) {
				String[] keyValue = val.split(SPACE_SEPERATOR);
				key = keyValue[0] == null ? null : keyValue[0].trim();
				value = keyValue[1] == null ? null : keyValue[1].trim();

			}

			switch (key) {
			case "transportation-method":

				if (value != null) {
					calculatorInput.setTransportationMethod(value);
				}

				break;
			case "distance":

				if (value != null) {
					calculatorInput.setDistance(new BigDecimal(value));
				}

				break;

			case "unit-of-distance":

				if (value != null) {
					calculatorInput.setUnitOfDistance(value);
				}
				break;
			case "output":

				if (value != null) {
					calculatorInput.setCo2EquivalentUnit(value);
				}
				break;

			default:
				break;
			}

		}

		return calculatorInput;
	}

}
