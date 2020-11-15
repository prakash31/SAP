package com.sap.co2.emission.calc.service;

import java.io.IOException;

public interface IView {

	public String read() throws IOException;

	public void print(String output);

}
