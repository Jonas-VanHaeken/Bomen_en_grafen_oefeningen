package ui;

import java.util.List;

import domain.Graph;

public class BreadthFirstSearchUI {

	public static void main(String[] args) {

		int data[][] = { 	{ 0, 1, 0, 1, 0, 0, 0 }, 
							{ 0, 0, 1, 0, 0, 0, 0 }, 
							{ 1, 0, 0, 1, 1, 0, 0 },
							{ 0, 0, 0, 0, 1, 1, 0 }, 
							{ 0, 1, 0, 0, 0, 0, 1 }, 
							{ 0, 0, 0, 0, 0, 0, 1 }, 
							{ 0, 0, 0, 0, 0, 0, 0 } }; // verbindingsmatrix van graaf  uit  de slides
		Graph bfs = new Graph(data);

		int start = 1;
		int destination = 7;
		// deelresultaat afdrukken
		System.out.println(bfs.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)));

		start = 7;
		destination = 1;
		// deelresultaat afdrukken
		System.out.println(bfs.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs.findPath(start, destination)));


		System.out.println("\nOefening 7.6\n");
		int data2[][] = { 	{ 0,1,1,1,0,0,0,0 },
							{ 1,0,1,0,1,0,0,0 },
							{ 1,1,0,0,0,1,0,0 },
							{ 1,0,0,0,0,1,1,0 },
							{ 0,1,0,0,0,1,0,1 },
							{ 0,0,1,0,1,0,1,0 },
							{ 0,0,0,1,0,1,0,1 },
							{ 0,0,0,0,1,0,1,0 }}; // verbindingsmatrix van graaf  uit  figuur  1.5  van  cursus
		Graph bfs2 = new Graph(data2);

		start = 1;
		destination = 7;
		// deelresultaat afdrukken
		System.out.println(bfs2.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs2.findPath(start, destination)));

		start = 7;
		destination = 1;
		// deelresultaat afdrukken
		System.out.println(bfs2.geefAncestors(start, destination));
		// eindresultaat
		System.out.println(zetPadOmNaarString(start, destination, bfs2.findPath(start, destination)));

	}

	private static String zetPadOmNaarString(int start, int destination, List<Integer> path) {
		if (path.size() == 0)
			return "Er is geen pad van " + start + " naar " + destination;
		else
			return "Kortste pad van " + start + " naar "+ destination + " is " + path.size() + " knopen lang en bestaat uit volgende knopen  : " + path;
	}
}
