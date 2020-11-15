package com.sap.co2.emission.calc.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.sap.co2.emission.util.TramsportatioMethodConfigReader;
import com.sap.co2.emission.util.UnitConversionConfigReader;

public class Co2EmissionCalculator {

	private static String DEFAULT_DISTANCE_UNIT = "km";
	private static String DEFAULT_CO2_EQUIVALENT_UNIT = "kg";
	private static Set<TransportationmethodConfig> transportationmethodConfigs;
	private static Set<UnitConversion> unitConversions;

	public Co2EmissionCalculator() throws IOException {

		transportationmethodConfigs = new HashSet<>(new TramsportatioMethodConfigReader().get());
		unitConversions = new HashSet<>(new UnitConversionConfigReader().get());
	}

	public String calcuateco2(String transportationMethod, BigDecimal distance, String unitOfDistance,
			String co2EquivalentUnit) {
		unitOfDistance = unitOfDistance == null ? DEFAULT_DISTANCE_UNIT : unitOfDistance;
		co2EquivalentUnit = co2EquivalentUnit == null ? DEFAULT_CO2_EQUIVALENT_UNIT : co2EquivalentUnit;

		BigDecimal co2value = calcuate(transportationMethod, distance, unitOfDistance, co2EquivalentUnit);

		StringBuilder sb = new StringBuilder("Your trip caused ").append(co2value).append(co2EquivalentUnit)
				.append(" of CO2-equivalent.");
		return sb.toString();
	}

	public BigDecimal calcuate(String transportationMethod, BigDecimal distance, String unitOfDistance,
			String co2EquivalentUnit) {

		// Always convert distance to kilometers for simplified calculation
		final UnitConversion distanceConverion = new UnitConversion();
		distanceConverion.setFromUnit(unitOfDistance);
		distanceConverion.setToUnit(DEFAULT_DISTANCE_UNIT);


		Optional<UnitConversion> element = unitConversions.stream().filter(p -> p.equals(distanceConverion))
				.findFirst();
		UnitConversion distanceConverionOut = element.isPresent() ? element.get() : null;
		BigDecimal distanceInKm = distance.multiply(distanceConverionOut.getMultiplier());

		// Get transportation Method avg value per km
		final TransportationmethodConfig transportationmethodConfig = new TransportationmethodConfig();
		transportationmethodConfig.setTransportationMethod(transportationMethod);

		Optional<TransportationmethodConfig> element1 = transportationmethodConfigs.stream()
				.filter(p -> p.equals(transportationmethodConfig)).findFirst();
		TransportationmethodConfig transportationmethodConfigOut = element1.isPresent() ? element1.get() : null;

		// calculate co2 Emission
		BigDecimal co2Avg = distanceInKm.multiply(transportationmethodConfigOut.getCo2avg());

		// Convert to output unit
		final UnitConversion weightConverion = new UnitConversion();
		weightConverion.setFromUnit(transportationmethodConfigOut.getCo2AvgUnit());
		weightConverion.setToUnit(co2EquivalentUnit);
		Optional<UnitConversion> weightele = unitConversions.stream().filter(p -> p.equals(weightConverion))
				.findFirst();
		UnitConversion weightConverionOut = weightele.isPresent() ? weightele.get() : null;

		BigDecimal output = co2Avg.multiply(weightConverionOut.getMultiplier());
		
		output=output.setScale(weightConverionOut.getRound(), BigDecimal.ROUND_HALF_UP);

		return output;

	}

}
