package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		boom.printPreorder();
		System.out.println("- Pre Order");
		boom.printInorder();
		System.out.println("- In Order");
		boom.printPostorder();
		System.out.println("- Post Order");
		System.out.println("Aantal Nodes: " + boom.countNodes());
		System.out.println("De diepte is: " + boom.getDepth());
		System.out.println("De boom boom is " + (boom.isLeaf()?"een ":"geen ")+ "blad.");
		System.out.println("De boom boom heeft " + boom.countLeaves() + " blaadjes.");
		boom.getDataLeaves();
		System.out.println("- Data Leaves");
		System.out.println("De boom boom bevat het punt" + (boom.contains("D")?" D":" D niet"));
		System.out.println("De boom boom bevat het punt" + (boom.contains("H")?" H":" H niet"));
		System.out.println("De boom boom bevat het punt" + (boom.contains("F")?" F":" F niet"));
		System.out.println("De boom boom bevat het punt" + (boom.contains("Q")?" Q":" Q niet"));

	}

}
