package grokking.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {

	private static void dijkstra(GraphContext context) {
		var processed = new ArrayList<String>();
		var node = findLowestCostNode(context.costs, processed);
		while (node != null) {
			var cost = context.costs.get(node);
			var neighbors = context.graph.get(node);
			for (var neighbor : neighbors.keySet()) {
				float newCost = cost + neighbors.get(neighbor);
				if (context.costs.get(neighbor) > newCost) {
					context.costs.put(neighbor, newCost);
					context.parents.put(neighbor, node);
				}
			}
			processed.add(node);
			node = findLowestCostNode(context.costs, processed);
		}
	}

	private static String findLowestCostNode(Map<String, Float> costs, List<String> processed) {
		return costs.entrySet()
			.stream()
			.filter(e -> !processed.contains(e.getKey()))
			.min(Map.Entry.comparingByValue())
			.map(Map.Entry::getKey)
			.orElse(null);
	}

	public static void main(String[] args) {
		Map<String, Map<String, Float>> graph = Map.of(
			"start", new HashMap<>(Map.of("a", 6f, "b", 2f)),
			"a", new HashMap<>(Map.of("fin", 1f)),
			"b", new HashMap<>(Map.of("a", 3f, "fin", 5f)),
			"fin", new HashMap<>()
		);
		Map<String, Float> costs = new HashMap<>(Map.of(
			"a", 6f, "b", 2f, "fin", Float.POSITIVE_INFINITY
		));
		Map<String, String> parents = new HashMap<>(Map.of(
			"a", "start", "b", "start", "fin", "null"
		));

		dijkstra(GraphContext.of(graph, costs, parents));

		System.out.println(parents);
	}

	private static class GraphContext {
		Map<String, Map<String, Float>> graph;
		Map<String, Float> costs;
		Map<String, String> parents;

		public GraphContext(Map<String, Map<String, Float>> graph, Map<String, Float> costs, Map<String, String> parents) {
			this.graph = graph;
			this.costs = costs;
			this.parents = parents;
		}

		public static GraphContext of(Map<String, Map<String, Float>> graph, Map<String, Float> costs, Map<String, String> parents) {
			return new GraphContext(graph, costs, parents);
		}
	}
}