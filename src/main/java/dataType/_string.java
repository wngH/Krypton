package dataType;

import java.util.ArrayList;
import java.util.List;

public class _string {
	
	// Value
	private List<_character> value;
	
	// Constructor
	public _string(String s) {
		value = new ArrayList<_character>();
		for (int i = 0; i < s.length(); i++) 
			value.add(new _character(s.charAt(i)));
	}
	public _string() {
		value = new ArrayList<_character>();
	}
	public _string(List<_character> value) {
		this.value = value;
	}
	
	// Getter and Setter
	public void add(_character c) {
		this.value.add(c);
	}
	
	public void add(int index, _character c) {
		this.value.add(index, c);
	}
	
	public void set(List<_character> v) {
		this.value = v;
	}
	
	public List<_character> get() {
		return this.value;
	}
	
	public int length() {
		return this.value.size();
	}
	
	public String getStringValue() {
		String out = "";
		for (int i = 0; i < this.value.size(); i++) {
			out += this.value.get(i).toChar();
		}
		return out;
	}

	public _character get(int index) {
		return this.value.get(index);
	}
	
	// _string method
	private static String generateRule(double param_1, boolean canBeTrace) {
		String s = String.format("%.14f", param_1);
		int[] num = new int[7];
		int index = 0;
		String temp = "";
		for (int i = 2; i < 16; i++) {
			temp += s.charAt(i);
			if (temp.length() >= 2) {
				num[index] = Integer.parseInt(temp);
				index ++;
				temp = "";
			}
		}
		
		String rule = "";
		if (!canBeTrace)
			for (int i = 0; i < 7; i++) {
				switch (num[i] % 4) {
					case 0:
						rule += "A";
						break;
					case 1:
						rule += "O";
						break;
					case 2:
						rule += "X";
						break;
					case 3:
						rule += 'p';
						break;
					default:
						System.out.println("Converting to rule failed");
				}
			}
		else 
			for (int i = 0; i < 7; i++) {
				switch (num[i] % 2) {
					case 0:
						rule += "X";
						break;
					case 1:
						rule += "p";
						break;
					default:
						System.out.println("Converting to rule failed");
				}
			}
		return rule;
	}
	
	private static double f_rule(double i) {
		return Math.abs(Math.sin(i));
	}
	
	private int getSumOfCode(String s) {
		int o = 0;
		for (int i = 0; i < s.length(); i++) {
			o += (int) s.charAt(i);
		}
		return o;
	}
	
	public void grow(int length, String seedCode) {
		List<_character> value = new ArrayList<_character>();
		_seed seed = new _seed(seedCode);
		char c;
		int i;
		String buffer = this.getStringValue();
		value.addAll(this.value);
		for (i = 0; i < length; i++) {
			if (i < value.size()) {
				c = seed.getChar();
				buffer += c;
				value.set(
					i, _character.combine(
							new _character(c), 
							value.get(i), 
							_string.generateRule( _string.f_rule(i + this.getSumOfCode(buffer)),false)
						)
				);
			}
			else 
				value.add(
						i, _character.combine(
								new _character(seed.getChar()), 
								value.get(i - 1), 
								_string.generateRule(_string.f_rule(i + this.getSumOfCode(buffer)),false)
							)
					);
		}
		this.value = value;
	}
	
	public static _string combine(_string s1, _string s2) {
		_string s = new _string();
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				s.add(_character.combine(s1.get(i), s2.get(i), _string.generateRule(_string.f_rule(i),true)));
			}
		}
		return s;
	}
	
	public void encrypt(String seedCode, String password) {
		if (this.value.size() >= password.length()) {
			_string KEY = new _string(password);
			KEY.grow(this.value.size(), seedCode);
			this.value = _string.combine(this,KEY).get();
		}
	}
	
	public void deEncrypt(String seedCode, String password) {
		_string KEY = new _string(password);
		KEY.grow(this.value.size(), seedCode);
		this.value = _string.combine(this,KEY).get();
	}
}
