package dataType;

public class _rule {
	private char[] value;
	public _rule(String str) {
		value = new char[str.length()];
		index = -1;
		
		//
		for (int i = 0; i < str.length(); i++) {
			value[i] = str.charAt(i);
		}
	}
	
	private int index;
	public char getRule() {
		index++;
		if (index >= value.length) index = 0;
		return value[index];
	}
}
