package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	
	/**
	 * Reads symptoms from file, counts and sorts them, then outputs the result to a file.
	 * Logs each step.
	 */
	public static void main(String args[]) {
		try {
			System.out.println("Reading symptoms file...");
			final ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
			final List<String> raw_symptoms = reader.getSymptoms();

			System.out.println("Counting symptoms...");
			final SortedMap<String, Integer> symptoms = AnalyticsCounter.countSymptoms(raw_symptoms);
			
			System.out.println("Writing output...");
			final ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms(symptoms);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}