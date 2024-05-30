package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String args[]) {
		try {
			System.out.println("Reading symptoms file...");
			final ISymptomReader read = new ReadSymptomDataFromFile("../symptoms.txt");
			final List<String> raw_symptoms = read.GetSymptoms();

			System.out.println("Counting symptoms...");
			final SortedMap<String, Integer> symptoms = countSymptoms(raw_symptoms);
			
			System.out.println("Writing output...");
			final ISymptomWriter writer = new WriteSymptomDataToFile();
			writer.writeSymptoms(symptoms);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SortedMap<String, Integer> countSymptoms(List<String> raw_symptoms) {
		var ret = new TreeMap<String, Integer>();

		try {
			for (String symptom : raw_symptoms) {
				final var count = ret.get(symptom);
				ret.put(symptom, count == null ? 1 : count + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
}
