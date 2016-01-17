/*
 * Josh Marasigan
 * Erphun Ranjbar
 * [Render]
 * <Node.java>
 * */
package render;

/* ------------------------------ */
/* Node (Element) class for Array */
/* ------------------------------ */
public class Node {
	// Node Fields
	private int index;
	private Integer intVal;
	
	// Constructor
	public Node(int ind, Integer intVal) {
		this.index = ind;
		this.intVal = intVal;
	}
	
	// Null Param Constructor
	public Node(){
		this.index = 0;
		this.intVal = 0;
	}
	
	// Node getters and setters
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Integer getIntVal() {
		return intVal;
	}
	public void setIntVal(Integer intVal) {
		this.intVal = intVal;
	}
}
