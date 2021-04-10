package grokking.algorithms;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class BFS {

	/**
	 * Most important thing is the usage of the Queue here (Deque or LinkedList)
	 *
	 */
	public static String bfs(Map<String, List<String>> graph, String key) {
		var deque = new ArrayDeque<>(graph.get(key)); // Or LinkedList()
		while (!deque.isEmpty()) {
			var person = deque.pop();
			System.out.printf("Checking person %s\n", person);
			if (isMangoSeller(person)) {
				System.out.println("Found a mango seller!");
				return person;
			}
			deque.addAll(graph.get(person));
		}
		return "Not found";
	}

	private static boolean isMangoSeller(String person) {
		return person.endsWith("m");
	}

	public static void main(String[] args) {
		Map<String, List<String>> graph = Map.of(
			"you", List.of("alice", "bob", "claire"),
			"bob", List.of("anuj", "peggy"),
			"alice", List.of("peggy"),
			"claire", List.of("thom", "jonny"),
			"anuj", Collections.emptyList(),
			"peggy", Collections.emptyList(),
			"thom", Collections.emptyList(),
			"jonny", Collections.emptyList()
		);
		System.out.println(bfs(graph, "you"));
	}
}
