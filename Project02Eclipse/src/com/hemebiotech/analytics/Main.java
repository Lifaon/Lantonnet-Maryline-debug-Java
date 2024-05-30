package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String args[]) {
		try {
			System.out.println("Reading symptoms file...");
			final ISymptomReader read = new ReadSymptomDataFromFile("../symptoms.txt");
			final List<String> raw_symptoms = read.GetSymptoms();

			System.out.println("Counting symptoms...");
			final AnalyticsCounter counter = new AnalyticsCounter();
			final SortedMap<String, Integer> symptoms = counter.countSymptoms(raw_symptoms);
			
			System.out.println("Writing output...");
			final ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms(symptoms);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}