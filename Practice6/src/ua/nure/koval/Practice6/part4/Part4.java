package ua.nure.koval.Practice6.part4;

public final class Part4 {

	private Part4() {
	}

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(5, 3);
		graph.addEdge(5, 4);
		System.out.println("Adding edges: 2=4, 2=3, 2=5, 5=3, 5=4");
		graph.print();

		graph.deleteEdge(2, 5);
		System.out.println("Removing edge: 2=5");
		graph.print();
	}

}
