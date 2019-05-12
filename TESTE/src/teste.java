public class teste {
	
	
	public static void permutation(String str) {
		permutation(str, "");
	}
	
	public static void permutation(String str, String prefix) {
		if (str.length() == 0 ) {
			System.out.println(prefix);
			return;
		}
		else {
			for (int i = 0; i < str.length(); i++) {
				char a = str.charAt(i);
				String new_str = str.substring(0,i) + str.substring(i+1);
				permutation(new_str, prefix + a );
			}
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String x = "glo";
		
		//System.out.println(x);
		
		
		permutation(x);
		
	}
	
	
	
}
