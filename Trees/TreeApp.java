package Trees;

public class TreeApp {

	public static void main(String[] args) {
		System.out.println("Tree App");
		
		StudentTree myTree = new StudentTree();
		/**
		myTree.insert(new StudentNode("Sarah",10));
		myTree.insert(new StudentNode("Bob",5));
		myTree.insert(new StudentNode("Sam",2));
		myTree.insert(new StudentNode("Joe",7));
		
		myTree.insert(new StudentNode("Adam",17));
		myTree.insert(new StudentNode("Tim",12));
		myTree.insert(new StudentNode("Ted",20));
		*/
		
		myTree.insert(new StudentNode("60",60));
		myTree.insert(new StudentNode("40",40));
		myTree.insert(new StudentNode("80",80));
		myTree.insert(new StudentNode("20",20));
		myTree.insert(new StudentNode("50",50));
		myTree.insert(new StudentNode("95",95));
		
		myTree.insert(new StudentNode("10",10));
		myTree.insert(new StudentNode("30",30));
		myTree.insert(new StudentNode("5",5));
		
		
		
		/**
		 * Original Tree:      60
		 * 				     /    \
		 *                 40      80
		 *               /   \       \
		 *            20      50       95
		 *          /    \         
		 *        10      30
		 *       /
		 *      5
		 *      
		 *      
		 * After deleting "20":60
		 * 				     /    \
		 *                 40      80
		 *               /   \       \
		 *            30      50       95
		 *          /             
		 *        10      
		 *       /
		 *      5  
		 */
		
		
		//Print in order
		myTree.printPreOrder(); // set cursor to print, then it prints in order
		
		/**
		 * Testing deleting a node with children (deleting 20)
		 */
		System.out.println("--------Deleting Node 20--------");
		myTree.delete(20);
		
		
		/**
		 * printing out each parent and their 2 children, so see how tree gets re-organized
		 */
		System.out.println("-------root---------");

		System.out.println(myTree.search(60).getRight());
		System.out.println(myTree.search(60).getLeft());
		
		
		System.out.println("--------80--------");
		
		System.out.println(myTree.search(80).getRight());
		System.out.println(myTree.search(80).getLeft());
		
		System.out.println("---------40--------");
		
		System.out.println(myTree.search(40).getRight()); 
		System.out.println(myTree.search(40).getLeft()); //20 is no long to the left of 40, instead 30 is now.
		
		System.out.println("----------30-------");
		
		System.out.println(myTree.search(30).getRight()); 
		System.out.println(myTree.search(30).getLeft());
		
		System.out.println("---------10--------");
		
		System.out.println(myTree.search(10).getRight()); //checking if 50 still exists (id doesnt, looks good)
		System.out.println(myTree.search(10).getLeft());
		
	}

}
