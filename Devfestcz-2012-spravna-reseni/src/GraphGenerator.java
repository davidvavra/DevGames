import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphGenerator {

	public static void main(String[] args) {
		/*if (args.length != 4) {
			System.out.println("Run the program with [nodes] [connections] [edges] [full/random/noconn] params.");
			return;
		}*/
		final int NODES = 26;
		final int CONNECTIONS = 1;
		final int EDGES = 120;
		final String type = "random";
		if ("full".equals(type.toLowerCase())) {
			makeFullGraph(NODES, CONNECTIONS);
		} else if ("random".equals(type.toLowerCase())) {
			makeRandomGraph(NODES, EDGES);
		} else {
			makeNotConnectableFullGraph(NODES, CONNECTIONS);
		}

	}

	public static void makeRandomGraph(int NODES, int EDGES) {
		StringBuilder sb = new StringBuilder();
		List<Character> nodes = new ArrayList<Character>();
		for (int i=0;i<NODES;i++) {
			nodes.add((char)(i+65));
		}
		Random random = new Random();
		List<E> edges = new ArrayList<E>();
		for (int i = 0; i <= EDGES; i++) {
			char x = nodes.get(random.nextInt(NODES));
			char y = nodes.get(random.nextInt(NODES));
			E e = new E(x, y);
			if (x == y || isEdge(edges, e)) {
				i--;
				continue;
			}
			edges.add(e);
			sb.append(x);
			sb.append(" ");
			sb.append(y);
			sb.append(" ");
			sb.append(getWeight(true));
			sb.append("\n");
		}
		sb.append("xxx\n");
		System.out.println(sb.toString());
	}

	public static void makeNotConnectableFullGraph(int NODES, int CONNECTIONS) {
		final boolean random = true;
		StringBuilder sb = new StringBuilder();
		sb.append(NODES + CONNECTIONS + 1);
		sb.append("\n");
		sb.append(CONNECTIONS);
		sb.append("\n");
		for (int i = 1; i <= NODES; i++) {
			for (int y = 1; y <= NODES; y++) {
				if (i != y) {
					sb.append(y);
					sb.append(" ");
					sb.append(i);
					sb.append(" ");
					sb.append(getWeight(random));
					sb.append("\n");
				}
			}
		}
		sb.append("0 0 0\n");
		System.out.println(sb.toString());
	}

	public static void makeFullGraph(int NODES, int CONNECTIONS) {
		final boolean random = true;
		StringBuilder sb = new StringBuilder();
		sb.append(NODES);
		sb.append("\n");
		sb.append(CONNECTIONS);
		sb.append("\n");
		for (int i = 1; i <= NODES; i++) {
			for (int y = 1; y <= NODES; y++) {
				if (i != y) {
					sb.append(y);
					sb.append(" ");
					sb.append(i);
					sb.append(" ");
					sb.append(getWeight(random));
					sb.append("\n");
				}
			}
		}
		sb.append("0 0 0\n");
		System.out.println(sb.toString());
	}

	public static int getWeight(boolean random) {
		if (random) {
			return (int) (Math.random() * 99 + 1);
		} else {
			return 10;
		}
	}
	
	public static class E {
		public E(char x, char y) {
			this.source = x;
			this.dest = y;
		}
		public Character source;
		public Character dest;
		
		@Override
		public boolean equals(Object obj) {
			E another = (E) obj;
			return (source == another.source && dest==another.dest);
		}
	}
	
	public static boolean isEdge(List<E> list, E e) {
		for (E listItem : list) {
			if (e.equals(listItem)) {
				return true;
			}
		}
		return false;
	}

}
