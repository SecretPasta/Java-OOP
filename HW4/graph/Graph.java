package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph<V> {

	private Set<V> vertices;
	private Map<V, Set<V>> edges;

	// Constructor to initialize the class
	public Graph() {
		this.vertices = new HashSet<>();
		this.edges = new HashMap<>();
	}

	// method to add a Vertex to the vertices HashSet if it exists throws an
	// exception
	public void addVertex(V v) throws GraphException {
		if (vertices.contains(v))
			throw new GraphException("Vertex Exitsts!\n");
		else {
			vertices.add(v);
			edges.put(v, new HashSet<>());
		}
	}

	// method the add an edge of two connecting vertices to the HashMap
	public void addEdge(V v1, V v2) throws GraphException {
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("One of the Verticies does not Exist!\n");
		else if (edges.get(v1).contains(v2))
			throw new GraphException("The edge already Exists!\n");
		else {
			edges.get(v1).add(v2);
			edges.get(v2).add(v1);
		}
	}

	// checks if v1 and v2 are connected
	public boolean hasEdge(V v1, V v2) {
		return (edges.get(v1).contains(v2));
	}

	// checks if you can get from v1 to v2 using DFS Algorithm if one the points
	// don't exist it throws an exception
	public boolean connected(V v1, V v2) throws GraphException {
		Set<V> visited = new HashSet<>();
		if (!vertices.contains(v1) || !vertices.contains(v2))
			throw new GraphException("One of the verticies does not Exist!\n");
		return dfs(v1, v2, visited);
	}

	// Recursive method that checks if two vertices are connected by neighbors
	private boolean dfs(V current, V dest, Set<V> visited) {
		visited.add(current);
		if (current.equals(dest))
			return true;
		for (V currentVertex : edges.get(current))
			if (!visited.contains(currentVertex))
				if (dfs(currentVertex, dest, visited))
					return true;
		return false;
	}
}
