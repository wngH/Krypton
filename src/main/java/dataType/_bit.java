package dataType;

public class _bit {
	
	// Value of bit
	private boolean value;
	
	// Constructor
	// @param can accept both boolean, char or integer
	public _bit(boolean value){
		this.value = value;
	}
	public _bit(char x) {
		if (x == '0') value = false;
		else if (x == '1') value = true;
		else System.out.print("Initializing failed");
	}
	public _bit(int num) {
		if (num == 0) value = false;
		else if (num == 1) value = true;
		else System.out.println("Initializing failed");
	}
	
	// Getter
	public boolean val() {
		return this.value;
	}
	
	public int getNumericValue() {
		if (this.value) return 1;
		else return 0;
	}
	
	// Operating on Bit
	public static _bit _AND(_bit b1, _bit b2) {
		return new _bit(b1.val() && b2.val());
	}
	
	public static _bit _OR(_bit b1, _bit b2) {
		return new _bit(b1.val() || b2.val());
	}
	
	public static _bit _XOR(_bit b1, _bit b2) {
		if (b1.val() == b2.val()) return new _bit(true);
		else return new _bit(false);
	}
	
	
	public static _bit _pXOR(_bit b1, _bit b2) {
		if (b1.val() == b2.val()) return new _bit(false);
		else return new _bit(true);
	}
}
