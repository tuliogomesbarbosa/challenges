package grokking.algorithms;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreedySetCovering {

	private static Set<String> setCovering(Set<String> statesNeeded, Map<String, Set<String>> statesByStationMap) {
		final Set<String> finalStations = new HashSet<>();
		while (!statesNeeded.isEmpty()) {
			Set<String> statesCovered = new HashSet<>();
			String bestStation = null;
			for (var entry : statesByStationMap.entrySet()) {
				String station = entry.getKey();
				Set<String> states = entry.getValue();
				Set<String> covered = new HashSet<>(statesNeeded);
				covered.retainAll(states);
				if (covered.size() > statesCovered.size()) {
					bestStation = station;
					statesCovered = covered;
				}
			}
			finalStations.add(bestStation);
			statesNeeded.removeAll(statesCovered);
		}
		return finalStations;
	}

	public static void main(String[] args) {
		Set<String> statesNeeded = new HashSet<>(Set.of("mt", "wa", "or", "id", "nv", "ut", "ca", "az"));
		Map<String, Set<String>> statesByStationMap = Map.of(
			"kone", Set.of("id", "nv", "ut"),
			"ktwo", Set.of("wa", "id", "mt"),
			"kthree", Set.of("or", "nv", "ca"),
			"kfour", Set.of("nv", "ut"),
			"kfive", Set.of("ca", "az")
		);

		System.out.println(setCovering(statesNeeded, statesByStationMap));

	}
}
