package com.sap.co2.emission.calc.service;

import java.math.BigDecimal;

public class UnitConversion {

	private String fromUnit;
	private String toUnit;
	private BigDecimal multiplier;
	private Integer round;

	public String getFromUnit() {
		return fromUnit;
	}

	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}

	public String getToUnit() {
		return toUnit;
	}

	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}

	public BigDecimal getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(BigDecimal multiplier) {
		this.multiplier = multiplier;
	}

	public Integer getRound() {
		return round;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromUnit == null) ? 0 : fromUnit.hashCode());
		result = prime * result + ((multiplier == null) ? 0 : multiplier.hashCode());
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
		UnitConversion other = (UnitConversion) obj;
		if (fromUnit == null) {
			if (other.fromUnit != null)
				return false;
		} else if (!fromUnit.equals(other.fromUnit))
			return false;
		if (multiplier == null) {
			if (other.multiplier != null)
				return false;
		} else if (!multiplier.equals(other.multiplier))
			return false;
		return true;
	}

	public void setRound(Integer round) {
		this.round = round;
	}

}
