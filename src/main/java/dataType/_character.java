package dataType;

public class _character {
	
	// Value in bit
	private _bit[] value;
	
	// Constructor
	
	public _character(char chr) {
		value = new _bit[7];
		int code = (int) chr;
		for (int i = 6; i >= 0; i--) {
			value[i] = new _bit(code % 2);
			code = (int) code / 2;
		}
	}
	
	public _character() {
		value = new _bit[7];
	}
	
	// Getter & Setter
	public _bit[] val() {
		return this.value;
	}
	public _bit bitAt(int index) {
		return value[index];
	}
	
	public void set(int index, _bit value) {
		this.value[index] = value;
	}
	
	// char method
	public static char toChar(String bins) {
		int val = 0;
		for (int i = 0; i < bins.length(); i++) {
			val = val * 2 + Character.getNumericValue(bins.charAt(i));
		}
		return (char) val;
	}
	public char toChar() {
		int val = 0;
		for (int i = 0 ; i < this.value.length; i++) {
			val = val * 2 + this.value[i].getNumericValue();
		}
		return (char) val;
	}
	
	
	public static _character combine(_character c1, _character c2, String seed) {
		_character output = new _character();
		_rule s = new _rule(seed);
		for (int i = 0; i < 7; i++) {
			switch (s.getRule()) {
				case 'A':
					output.set(i, _bit._AND(c1.bitAt(i),c2.bitAt(i)));
					break;
				case 'p':
					output.set(i, _bit._pXOR(c1.bitAt(i),c2.bitAt(i)));
					break;
				case 'X':
					output.set(i, _bit._XOR(c1.bitAt(i),c2.bitAt(i)));
					break;
				case 'O':
					output.set(i, _bit._OR(c1.bitAt(i),c2.bitAt(i)));
					break;
				default:
					System.out.println("WARN: Converting failed");
					output.set(i, null);
			};
		}
		return output;
	}
}
