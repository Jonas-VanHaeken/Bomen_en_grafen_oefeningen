package ui;


import domain.*;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeE1 = new BinaryTree<>("E");
		BinaryTree<String> nodeE2 = new BinaryTree<>("E");
		BinaryTree<String> nodeE3 = new BinaryTree<>("E");
		BinaryTree<String> nodeE4 = new BinaryTree<>("E");
		BinaryTree<String> nodeAEind = new BinaryTree<>("A");

		// Rechtse tak
		BinaryTree<String> nodeHRechts = new BinaryTree<>("H",null,nodeE1);
		BinaryTree<String> nodeI1 = new BinaryTree<>("I",nodeHRechts,nodeE2);
		BinaryTree<String> nodeG1 = new BinaryTree<>("G",null,nodeI1);

		//Linkse tak
		BinaryTree<String> nodeC1 = new BinaryTree<>("C",null,nodeE3);
		BinaryTree<String> nodeHLinksRechts = new BinaryTree<>("H",nodeC1,nodeE4);
		BinaryTree<String> nodeHLinks = new BinaryTree<>("H",nodeAEind,nodeHLinksRechts);

		//root
		BinaryTree<String> boom1 = new BinaryTree<>("A",nodeHLinks,nodeG1);


		//Aantal voorkomens
		System.out.println("Aantal voorkomens van I = " + boom1.count("I"));
		System.out.println("Aantal voorkomens van A = " + boom1.count("A"));
		System.out.println("Aantal voorkomens van H = " + boom1.count("H"));
		System.out.println("Aantal voorkomens van E = " + boom1.count("E"));
		System.out.println("Aantal voorkomens van Q = " + boom1.count("Q"));

		//Get nodes at distance
		System.out.println("Datavelden van knopen verwijderd op een afstand van 0 van de root = " + boom1.getNodesAtDistance(0));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 1 van de root = " + boom1.getNodesAtDistance(1));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 2 van de root = " + boom1.getNodesAtDistance(2));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 3 van de root = " + boom1.getNodesAtDistance(3));
		System.out.println("Datavelden van knopen verwijderd op een afstand van 4 van de root = " + boom1.getNodesAtDistance(4));

		//Mystery
		System.out.println(boom1.mystery(1));
		System.out.println(boom1.mystery(2));
		System.out.println(boom1.mystery(3));
		System.out.println(boom1.mystery(4));
		System.out.println(boom1.mystery(5));

		//BST Persoon
		Persoon els = new Persoon("Els","Adams",176,86); //bmi = 28
		Persoon an = new Persoon("Anne","Janssen",176,68); //bmi = 22
		Persoon tom = new Persoon("Tom","Frederiks",185,105); // bmi = 31
		Persoon tim = new Persoon("Tim","Anders",185,85); //bmi = 25
		Persoon joke = new Persoon("Joke","Alders",176,86); //bmi = 28


		//4.20
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
		BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
		BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);
		BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);
		BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);
		System.out.println("\nVolledige boom preorder:");
		boom.printPreorder();
		System.out.println("\nVolledige boom inorder:");
		boom.printInorder();
		BinaryTree<String> boomZonderI = boom.deelZonder("I");
		System.out.println("\nBoom zonder I preorder: ");
		boomZonderI.printPreorder();
		System.out.println("\nBoom zonder I inorder: ");
		boomZonderI.printInorder();
		BinaryTree<String> boomZonderB = boom.deelZonder("B");
		System.out.println("\nBoom zonder B preorder: ");
		boomZonderB.printPreorder();
		System.out.println("\nBoom zonder B inorder: ");
		boomZonderB.printInorder();

	}

}
