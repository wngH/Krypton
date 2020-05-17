package encrypter;

import dataType._string;

public class Encrypt {
	// Constructor
	public static String encrypt(String target, String password, String seed) {
		_string s = new _string(target);
		_string s_p = new _string(password);
		if (target.length() > password.length()) {
			s_p.grow(target.length(), seed);
			return _string.combine(s, s_p).getStringValue();
		}
		else return target;
	}
	
	// In the case there's no seed, password will be the seed
	public static String encrypt(String target, String password) {
		_string s = new _string(target);
		_string s_p = new _string(password);
		if (target.length() > password.length()) {
			s_p.grow(target.length(), password);
			return _string.combine(s, s_p).getStringValue();
		}
		else return target;
	}
}
