package com.sap.co2.emission.calc.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements IView {

	public String read() throws IOException {
		BufferedReader reader = null;
		reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		return input;

	}

	public void print(String output) {

		System.out.println(output);

	}

}
