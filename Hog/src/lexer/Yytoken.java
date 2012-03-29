package lexer;

/** A single scanner token. */
public class Yytoken {
	
	public boolean is_separator = false;
	public boolean is_int = false;
	public boolean is_token = false;

	public char separator;
	public String token = null;
	public int value = 0;

	/** Default for range separator. */
	public Yytoken(char c) {
		is_separator = true;
		separator = c;
	}

	public Yytoken(int value) {
		is_int = true;
		this.value = value;
	}

	public Yytoken(String token) {
		is_token = true;
		this.token = token;
	}

	public String toString() {
		if (is_separator)
			return "Range Token(" + separator + ")";
		else if (is_int)
			return "Int Token(" + value + ")";
		else
			return "Token (" + token + ")";
	}
}