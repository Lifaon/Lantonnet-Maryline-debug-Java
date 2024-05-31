package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that will write symptoms data to an output file.
 */
public interface ISymptomWriter {

	/**
	 * Writes the given symptoms to an output file.
	 * 
	 * @param symptoms the map of symptoms, can be sorted or not.
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}
