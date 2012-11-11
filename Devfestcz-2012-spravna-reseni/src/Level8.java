import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Level8 {

	static List<Vertex> vertices;

	public static void main(String args[]) throws Exception {
		// read input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		vertices = new ArrayList<Vertex>();
		while (!(line = in.readLine()).equals("xxx")) {
			String[] parts = line.split(" ");
			Vertex source = findVertex(parts[0]);
			Vertex dest = findVertex(parts[1]);
			int distance = Integer.parseInt(parts[2]);
			source.adjacencies.add(new Edge(dest, distance));
		}
		// compute
		int optimalDistance = Integer.MAX_VALUE;
		String optimalNode = "";
		for (Vertex start : vertices) {
			for (Vertex vertex : vertices) {
				vertex.minDistance = Integer.MAX_VALUE;
			}
			computePaths(start);
			int maxDistance = Integer.MIN_VALUE;
			for (Vertex v : vertices) {
				//System.out.println("Distance to " + v + ": " + v.minDistance);
				if (v.minDistance > maxDistance) {
					maxDistance = v.minDistance;
				}
			}
			//System.out.println("max distance:" + maxDistance);
			if (maxDistance < optimalDistance) {
				optimalDistance = maxDistance;
				optimalNode = start.name;
			}
		}
		System.out.println(optimalNode+" "+optimalDistance);
	}

	public static Vertex findVertex(String name) {
		for (Vertex vertex : vertices) {
			if (vertex.name.equals(name)) {
				return vertex;
			}
		}
		Vertex vertex = new Vertex(name);
		vertices.add(vertex);
		return vertex;
	}

	static class Vertex implements Comparable<Vertex> {
		public final String name;
		public List<Edge> adjacencies;
		public int minDistance = Integer.MAX_VALUE;
		public Vertex previous;

		public Vertex(String argName) {
			name = argName;
			adjacencies = new ArrayList<Edge>();
		}

		public String toString() {
			return name;
		}

		public int compareTo(Vertex other) {
			return Integer.compare(minDistance, other.minDistance);
		}

	}

	static class Edge {
		public final Vertex target;
		public final int weight;

		public Edge(Vertex argTarget, int argWeight) {
			target = argTarget;
			weight = argWeight;
		}
	}

	public static void computePaths(Vertex source) {
		source.minDistance = 0;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);

		while (!vertexQueue.isEmpty()) {
			Vertex u = vertexQueue.poll();

			// Visit each edge exiting u
			for (Edge e : u.adjacencies) {
				Vertex v = e.target;
				int weight = e.weight;
				int distanceThroughU = u.minDistance + weight;
				if (distanceThroughU < v.minDistance) {
					vertexQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					vertexQueue.add(v);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> path = new ArrayList<Vertex>();
		for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
			path.add(vertex);

		Collections.reverse(path);
		return path;
	}
}
