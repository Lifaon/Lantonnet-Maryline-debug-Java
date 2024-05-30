package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;

public class WriteSymptomDataToFile implements ISymptomWriter {
	
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try {

			FileWriter writer = new FileWriter("result.out");
		
			for (var entry : symptoms.entrySet()) {
				writer.write(entry.getKey() + ": " + entry.getValue() + '\n');
			}

			writer.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
