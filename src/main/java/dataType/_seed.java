package dataType;

public class _seed {
	private String value;
	private int index;
	
	public _seed(String s) {
		this.value = s;
		index = -1;
	}
	
	public char getChar() {
		index ++;
		if (index >= value.length()) index = 0;
		//System.out.println(value.charAt(index));
		return value.charAt(index);
	}
}
