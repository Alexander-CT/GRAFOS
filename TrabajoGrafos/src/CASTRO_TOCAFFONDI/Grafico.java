package CASTRO_TOCAFFONDI;
//Autor: CASTRO TOCAFFONDI
import java.util.*;

public class Grafico {
    private final Map<Character, List<Vertice>> vertices;

    public Grafico() {
        this.vertices = new HashMap<Character, List<Vertice>>();
    }

    public void addVertice(Character character, List<Vertice> vertex) {
        this.vertices.put(character, vertex);
    }

    public List<Character> getShortestPath(Character start, Character finish) {
        final Map<Character, Integer> distances = new HashMap<Character, Integer>();
        final Map<Character, Vertice> previous = new HashMap<Character, Vertice>();
        PriorityQueue<Vertice> nodes = new PriorityQueue<Vertice>();
        for(Character vertex : vertices.keySet()) {
            if (vertex == start) {
		distances.put(vertex, 0);
		nodes.add(new Vertice(vertex, 0));
            } else {
		distances.put(vertex, Integer.MAX_VALUE);
		nodes.add(new Vertice(vertex, Integer.MAX_VALUE));
            }
            previous.put(vertex, null);
	}
	while (!nodes.isEmpty()) {
            Vertice smallest = nodes.poll();
            if (smallest.getId() == finish) {
                final List<Character> path = new ArrayList<Character>();
                while (previous.get(smallest.getId()) != null) {
                    path.add(smallest.getId());
                    smallest = previous.get(smallest.getId());
                }
                return path;
            }
            if (distances.get(smallest.getId()) == Integer.MAX_VALUE) {
                break;
            }
            for (Vertice neighbor : vertices.get(smallest.getId())) {
		Integer alt = distances.get(smallest.getId()) + neighbor.getDistancia();
		if (alt < distances.get(neighbor.getId())) {
                    distances.put(neighbor.getId(), alt);
                    previous.put(neighbor.getId(), smallest);
                    forloop:
                    for(Vertice n : nodes) {
			if (n.getId() == neighbor.getId()) {
                            nodes.remove(n);
                            n.setDistancia(alt);
                            nodes.add(n);
                            break forloop;
			}
                    }
		}
            }
	}
	return new ArrayList<Character>(distances.keySet());
    }
}
