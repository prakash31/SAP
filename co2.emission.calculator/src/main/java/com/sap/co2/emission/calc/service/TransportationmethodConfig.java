package com.sap.co2.emission.calc.service;

import java.math.BigDecimal;

public class TransportationmethodConfig {

	private String transportationMethod;
	private BigDecimal co2avg;
	private String co2AvgUnit;

	public String getTransportationMethod() {
		return transportationMethod;
	}

	public void setTransportationMethod(String transportationMethod) {
		this.transportationMethod = transportationMethod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transportationMethod == null) ? 0 : transportationMethod.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransportationmethodConfig other = (TransportationmethodConfig) obj;
		if (transportationMethod == null) {
			if (other.transportationMethod != null)
				return false;
		} else if (!transportationMethod.equals(other.transportationMethod))
			return false;
		return true;
	}

	public BigDecimal getCo2avg() {
		return co2avg;
	}

	public void setCo2avg(BigDecimal co2avg) {
		this.co2avg = co2avg;
	}

	public String getCo2AvgUnit() {
		return co2AvgUnit;
	}

	public void setCo2AvgUnit(String co2AvgUnit) {
		this.co2AvgUnit = co2AvgUnit;
	}

	@Override
	public String toString() {
		return "TransportationmethodConfig [transportationMethod=" + transportationMethod + ", co2avg=" + co2avg
				+ ", co2AvgUnit=" + co2AvgUnit + "]";
	}

}
