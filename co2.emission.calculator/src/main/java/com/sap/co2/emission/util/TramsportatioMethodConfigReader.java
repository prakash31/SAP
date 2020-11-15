package com.sap.co2.emission.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sap.co2.emission.calc.service.TransportationmethodConfig;

public class TramsportatioMethodConfigReader {

	private static String fileName = "TransmthdtoCo2configration.txt";

	public List<TransportationmethodConfig> get() throws IOException {

		List<TransportationmethodConfig> configs = new ArrayList<>();
		File file = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			TransportationmethodConfig config = new TransportationmethodConfig();
			String[] values = st.split(":");
			config.setTransportationMethod(values[0].trim());
			String numericstr = values[1].trim();
			config.setCo2avg(new BigDecimal(numericstr.substring(0, numericstr.length() - 1)));
			config.setCo2AvgUnit(numericstr.substring(numericstr.length()-1));
			configs.add(config);
		}
		br.close();
		return configs;
	}

	public static void main(String[] args) throws IOException {
		TramsportatioMethodConfigReader configReader = new TramsportatioMethodConfigReader();

		System.err.println(configReader.get());
	}
}
