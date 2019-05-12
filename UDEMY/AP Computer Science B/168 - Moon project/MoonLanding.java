import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.List;



class MoonLanding
{
	
	
	
	public static void main(String[] args) throws Exception
	
	{
		File file = new File("jfk.txt");
		Scanner sc = new Scanner(file);
		
		
		String text = "";
		while ( sc.hasNext() )
		{
			text += sc.nextLine();
		}
		
		//System.out.println(text + "\n");
		
		text = text.toLowerCase();
		text = text.replaceAll("[^a-zA-Z0-9 ]", " ");
		
		//text = text.replaceAll("  ", " ");
		//text = text.replaceAll("  ", " ");
		
		//System.out.println(text);
		
		
		// It means ONE or MORE spaces
		String[] words = text.split("\\s+");
		
		
		ArrayList<String> wlist = new ArrayList<>();
		ArrayList<Integer> clist = new ArrayList<>();
		
		
		for (String word : words)
		{
			
			try
			{
				clist.set( wlist.indexOf(word), clist.get( wlist.indexOf(word) ) + 1 );
			}
			catch (Exception ex)
			{
				wlist.add(word);
				clist.add(1);
			}
		}
		
		// wlist.add("Arroz");
		// clist.set( wlist.indexOf("Arroz"), clist.get(wlist.indexOf("Arroz")) + 1);
		
		
		for (int i = 0; i < wlist.size(); i++)
		{
			System.out.println( wlist.get(i) + " : " + clist.get(i) );
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
