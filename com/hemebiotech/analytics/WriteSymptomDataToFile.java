package com.hemebiotech.analytics;

import java.util.Map;
import java.io.FileWriter;

/**
 * Basic implementation
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * Writes the given symptoms to a file named 'result.out'.
	 * Whether the map is sorted or not, the output will be in the order of the map.
	 * One line per entry.
	 *
	 * @param symptoms the map of symptoms.
	 */
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
