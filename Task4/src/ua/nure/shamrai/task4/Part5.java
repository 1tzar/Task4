package ua.nure.shamrai.task4;

public class Part5 {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<>();
		
		tree.add(new Integer[] { 8, 3, 10, 1, 6, 14, 4, 7, 13 });
		tree.remove(3);
		tree.print();
	}

}
