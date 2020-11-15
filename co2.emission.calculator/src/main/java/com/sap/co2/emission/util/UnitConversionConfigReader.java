package com.sap.co2.emission.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.sap.co2.emission.calc.service.UnitConversion;

public class UnitConversionConfigReader {
	private static String fileName = "UnitConversionConfig.txt";

	public List<UnitConversion> get() throws IOException {

		List<UnitConversion> configs = new ArrayList<>();
		File file = new File(fileName);

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			UnitConversion config = new UnitConversion();
			String[] values = st.split(":");
			config.setFromUnit(values[0].trim());
			config.setToUnit(values[1].trim());
			config.setMultiplier(new BigDecimal(values[2].trim()));
			config.setRound(new Integer(values[3].trim()));
			configs.add(config);
		}
		br.close();
		return configs;
	}

//	public static void main(String[] args) throws IOException {
//		UnitConversionConfigReader configReader = new UnitConversionConfigReader();
//		List<UnitConversion> distanceConverions = configReader.get();
//		
//		Set<UnitConversion> hasset=new HashSet<>(distanceConverions);
//		
//		Optional<UnitConversion> element = hasset.stream().filter(p -> p.equals())
//				.findFirst();
//		UnitConversion distanceConverionOut = element.isPresent() ? element.get() : null;
//	}
}
