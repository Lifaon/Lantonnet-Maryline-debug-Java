package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class AnalyticsCounter {

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
