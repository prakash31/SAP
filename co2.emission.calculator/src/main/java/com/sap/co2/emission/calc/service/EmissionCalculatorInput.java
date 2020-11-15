package com.sap.co2.emission.calc.service;

import java.math.BigDecimal;

public class EmissionCalculatorInput {

	private String transportationMethod;
	private BigDecimal distance;
	private String unitOfDistance;
	private String co2EquivalentUnit;

	public String getTransportationMethod() {
		return transportationMethod;
	}

	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}

	public BigDecimal getDistance() {
		return distance;
	}

	public void setDistance(BigDecimal distance) {
		this.distance = distance;
	}

	public String getUnitOfDistance() {
		return unitOfDistance;
	}

	public void setUnitOfDistance(String unitOfDistance) {
		this.unitOfDistance = unitOfDistance;
	}

	public String getCo2EquivalentUnit() {
		return co2EquivalentUnit;
	}

	public void setCo2EquivalentUnit(String co2EquivalentUnit) {
		this.co2EquivalentUnit = co2EquivalentUnit;
	}

	@Override
	public String toString() {
		return "EmissionCalculatorInput [transportationMethod=" + transportationMethod + ", distance=" + distance
				+ ", unitOfDistance=" + unitOfDistance + ", co2EquivalentUnit=" + co2EquivalentUnit + "]";
	}

}
