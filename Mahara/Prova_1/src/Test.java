public class Test {
	
	
	public static void main(String[] args) {
		StaticList<Character> t1 = new StaticList<Character>(10);
		StaticList<Character> t2 = new StaticList<Character>(10);
		char x;
		
		// RECRIA AMBOS T1 E T2
		t1 = new StaticList<Character>(10); t2 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1; t2.insert(x, i); x +=1; }
		
		
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 7:\n");
		t1 = new StaticList<Character>(10); t2 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 7; i++){ t1.insert(x, i); x += 1; t2.insert(x, i); x +=1; }
		System.out.println(t1);
		t1.flip();
		System.out.println(t1);
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 8:\n");
		t1 = new StaticList<Character>(10); t2 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1; t2.insert(x, i); x +=1; }
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		t1.insert(t2,1);
		System.out.println("DEPOIS:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 9:\n");
		t1 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		t1.dedup();
		System.out.println("DEPOIS:");
		System.out.println("T1: " + t1);
		
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 10:\n");
		
		t1 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		t2 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 3; i++){ t2.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		System.out.println("Resultado: " + t1.equals(t2) + "\n");
		
		t1 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		t2 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 2; i++){ t2.insert(x, i); x += 1;}
		t2.insert('D',2);
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		System.out.println("Resultado: " + t1.equals(t2) + "\n");
		
		t1 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		t2 = new StaticList<Character>(10);
		x = 'A'; for (int i=0; i< 2; i++){ t2.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		System.out.println("Resultado: " + t1.equals(t2) + "\n");
		
		
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 11:\n");
		t1 = new StaticList<Character>(10); t2 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 3; i++){ t1.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		t2 = t1.clone();
		System.out.println("DEPOIS:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		
		
		
		
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 12:\n");
		t1 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 9; i++){ t1.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		System.out.println("Foram removidos " + t1.remove(1,6) + " elementos");
		System.out.println("DEPOIS:");
		System.out.println("T1: " + t1);
		
		
		
		
		System.out.println("\n\n####################################################");
		System.out.println("Exercicio 13:\n");
		t1 = new StaticList<Character>(10); x = 'A'; for (int i=0; i< 9; i++){ t1.insert(x, i); x += 1;}
		System.out.println("ANTES:");
		System.out.println("T1: " + t1);
		t2 = (StaticList<Character>) t1.split(5);
		System.out.println("DEPOIS:");
		System.out.println("T1: " + t1);
		System.out.println("T2: " + t2);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}
