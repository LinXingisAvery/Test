package test;

public class Cell implements Comparable<Object>,Cloneable{
	int row;
	int col;
	public Cell(){};
	public Cell(int row,int col){
		this.col=col;
		this.row=row;
	}
	@Override
	public String toString() {
		return "(" + row + "," + col + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
	@Override
	public int compareTo(Object o) {
		Cell o1=(Cell)o;
		return col-o1.col;
	}
	public Object clone(){
		Object o=null;
		try{
			o=super.clone();
		}catch(CloneNotSupportedException e){}
		return o;
	}
}
