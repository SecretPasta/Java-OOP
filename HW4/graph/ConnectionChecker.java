package graph;

import java.util.HashSet;
import java.util.Set;

public class ConnectionChecker<V> {
	private GraphInterface<V> g;

	// Constructor to initialize the class
	public ConnectionChecker(GraphInterface<V> g) {
		this.g = g;
	}

	// checks if you can get to v2 from v1
	public boolean check(V v1, V v2) {
		Set<V> visited = new HashSet<>();
		return dfs(v1, v2, visited);
	}

	// recursive method that checks if two vertices are connected by neighbors
	private boolean dfs(V current, V dest, Set<V> visited) {
		visited.add(current);
		if (current.equals(dest))
			return true;
		for (V nextVertex : g.neighbours(current))
			if (!visited.contains(nextVertex))
				if (dfs(nextVertex, dest, visited))
					return true;
		return false;
	}
}
