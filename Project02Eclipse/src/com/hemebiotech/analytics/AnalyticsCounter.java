package com.hemebiotech.analytics;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Small class implementing the {@link #countSymptoms(List<String>) countSymptoms} method.
 */
public class AnalyticsCounter {

	/**
	 * Counts symptoms occurence in a given list, and sorts them alphabetically.
	 * 
	 * @param	raw_symptoms	the unprocessed raw symptoms list.
	 * @return					the resulting sorted map.
	 */
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
