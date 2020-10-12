package Trees;

public class StudentNode {
	private int id; //key
	private String name;
	public StudentNode left;
	public StudentNode right;
	public int height;
	
	public StudentNode(String name, int id) {
		
		setName(name);
		setId(id);
		setLeft(null);
		setRight(null);
	}
	
	@Override //over riding superclass, from inheritance
	public String toString() {
		return name + ", " + id;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StudentNode getLeft() {
		return left;
	}
	public void setLeft(StudentNode left) {
		this.left = left;
	}
	public StudentNode getRight() {
		return right;
	}
	public void setRight(StudentNode right) {
		this.right = right;
	}
	
	//because all are private, create getters and setters

}
