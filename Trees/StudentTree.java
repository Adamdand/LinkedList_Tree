package Trees;

public class StudentTree {
	
	private StudentNode root;
	
	public StudentTree() {
		setRoot(null);
	}
	
	public void insert(StudentNode node) {
		// first check if node is null or not
		if(node == null)
			return;
		
		// make sure both left and the right of the node are null
		node.setLeft(null);
		node.setRight(null);
		
		if(root == null)
			root = node;
		else {
			// start with the root and look for a spot to insert
			// i.e. traverse the tree and look for the perper spot to insert the node
			StudentNode cursor = getRoot(); //start cursor at the root, traverse to find location to input new node
			while(true) {
				
				StudentNode parent = cursor; // <-- used to keep track of where the cursor was originally
				// question: insert to the left or right?
				if(node.getId() < cursor.getId()) {
					cursor = cursor.getLeft(); // need to remember where the cursor was originally
					// if the left child has no children, insert!
					if(cursor == null) {
						parent.setLeft(node);
						return;
					}
				}
				else if(node.getId() > cursor.getId()) {
					cursor = cursor.getRight();
					// if the right child has no children, Insert!
					if(cursor == null) {
						parent.setRight(node);
						return;
					}			
				}
				else {
					System.out.println("This student already exists");
					return;	// the node is not added if the id already exists			
				}
			}
		}
	}
	
	public void printInOrder() {	// create this function to call the traverseInOrder function, so we dont need to call root node in the treeApp
		TraverseInOrder(getRoot());	
	}
	public void printPreOrder() {	// create this function to call the traverseInOrder function, so we dont need to call root node in the treeApp
		TraversePreOrder(getRoot());	
	}
	public void printPostOrder() {	// create this function to call the traverseInOrder function, so we dont need to call root node in the treeApp
		TraversePostOrder(getRoot());	
	}
	
	
	private void TraverseInOrder(StudentNode cursor) { // Traverse in order , left, Node, right
		
		if(cursor != null) {
			TraverseInOrder(cursor.getLeft());	// left node
			System.out.println(cursor);			// current node
			TraverseInOrder(cursor.getRight());	// right node		
		}
	}
	
	private void TraversePostOrder(StudentNode cursor) { // Traverse post order, left, right , node
		
		if(cursor != null) {
			TraversePostOrder(cursor.getLeft());	// left node
			TraversePostOrder(cursor.getRight());	// right node
			System.out.println(cursor);			// current node			
		}
	}
	
	private void TraversePreOrder(StudentNode cursor) { // Traverse pre Order, node, leftsubtree, rightsubtree
		
		if(cursor != null) {
			System.out.println(cursor);			// current node
			TraversePreOrder(cursor.getLeft());	// left node
			TraversePreOrder(cursor.getRight());	// right node		
		}
	}
	
	// Homework! I NEED TO COMPLETE
	public StudentNode search(int key) { //(StudentNode cursor, int key) 
		StudentNode cursor = root;
		while(cursor != null) {
			if (key == cursor.getId()) 		// current.getId()
				return cursor;				// found
			else if (key < cursor.getId())
				cursor = cursor.getLeft();	//current.getleft()
			else
				cursor = cursor.getRight();
		}
		return cursor;						//not found
	}
	
	//get parent of a node
	public StudentNode findParent(StudentNode child) {
		return parentHelper(root,child);
	}
	public StudentNode parentHelper(StudentNode currentNode, StudentNode child) {
		if (root == null || root == child) {
			return null;
		}
		else {
			if(currentNode.getLeft() == child || currentNode.getRight() == child)
				return currentNode;
			else {
				if (currentNode.getId() < child.getId()) {
					return parentHelper(currentNode.getRight(), child);
				}else {
					return parentHelper(currentNode.getLeft(), child);
				}
			}
		}
	}

	// Homework! I NEED TO COMPLETE
	public StudentNode delete(int key) {
		//return what was just deleted
		if (root == null)
			return null;
		//first you have to search for the key
		StudentNode myNode = search(key);
		if(myNode == null)
			return null;
		
		//here you delete!
		// if the deleted node has no children
		else if(myNode.getLeft() == null && myNode.getRight() == null) {	//if deleted node is a leaf
			System.out.println("" + myNode + findParent(myNode) );
			if (findParent(myNode).getId()>myNode.getId())					//if leaf is on left
				findParent(myNode).setLeft(null);
			else if (findParent(myNode).getId()<myNode.getId())					//if leaf is on right
				findParent(myNode).setRight(null);
		}
		// if the deleted node has 1 child
		else if((myNode.getLeft() != null && myNode.getRight() == null)|| (myNode.getLeft() == null && myNode.getRight() != null)) {
			if(myNode.getLeft() != null) {
				findParent(myNode).setLeft(myNode.getLeft());	//set parent to look at the child of myNode
				myNode.setLeft(null);						//set myNode to look at null now, to delete
			}
			else if(myNode.getRight() != null) {
				findParent(myNode).setRight(myNode.getRight());	//set parent to look at the child of myNode
				myNode.setRight(null);						//set myNode to look at null now, to delete
			}
		}
		// if the deleted node has 2 children, need to re-connect pointers, and pivot
		else if(myNode.getLeft() != null && myNode.getRight() != null){
			if(findParent(myNode).getId()< myNode.getId()) {	//if deleting a node on the right of the parent
				findParent(myNode).setRight(myNode.getLeft());	//parentNode.Right connects to deletedNode.left, and that left node now connects to deletedNode.right
				myNode.getLeft().setRight(myNode.getRight());	//and that left node now connects to deletedNode.right
				myNode.setRight(null);	//set deleted node pointers to null
				myNode.setLeft(null);	//set deleted node pointers to null
			}else {												//if deleting a node on the left of the parent
				findParent(myNode).setLeft(myNode.getRight());	//parentNode.Left connects to deletedNode.right (pivot)
				myNode.getRight().setLeft(myNode.getLeft());	//and that right node now connects to deletedNode.left
				myNode.setRight(null);	//set deleted node pointers to null
				myNode.setLeft(null);	//set deleted node pointers to null
			}	
		}
		return myNode;	
	}

	

	public StudentNode getRoot() {
		return root;
	}

	public void setRoot(StudentNode root) {
		this.root = root;
	}
	

}
