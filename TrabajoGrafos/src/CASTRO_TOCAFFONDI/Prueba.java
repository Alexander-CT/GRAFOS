package CASTRO_TOCAFFONDI;
//Autor: CASTRO TOCAFFONDI
import java.util.Arrays;
public class Prueba {
    public static void main(String[] args) {
        Grafico g = new Grafico();
	g.addVertice('A', Arrays.asList(new Vertice('B', 7), new Vertice('C', 8)));
	g.addVertice('B', Arrays.asList(new Vertice('A', 7), new Vertice('F', 2)));
	g.addVertice('C', Arrays.asList(new Vertice('A', 8), new Vertice('F', 6), new Vertice('G', 4)));
	g.addVertice('D', Arrays.asList(new Vertice('F', 8)));
	g.addVertice('E', Arrays.asList(new Vertice('H', 1)));
	g.addVertice('F', Arrays.asList(new Vertice('B', 2), new Vertice('C', 6), new Vertice('D', 8), new Vertice('G', 9), new Vertice('H', 3)));
	g.addVertice('G', Arrays.asList(new Vertice('C', 4), new Vertice('F', 9)));
	g.addVertice('H', Arrays.asList(new Vertice('E', 1), new Vertice('F', 3)));
	System.out.println(g.getShortestPath('A', 'H'));
    }
}
