import java.io.*; 
import java.util.LinkedList; 
import java.util.ArrayList; 
import java.util.Scanner;
/**
 * Write a description of class MoonLanding here.
 * 
 * @author (Eric Y. Chou) 
 * @version (06/26/2016)
 */
public class MoonLanding
{   
   public static void main(String[] args) throws IOException{    
      //File ifile = new File("usdeclaration.txt"); 
      File ifile = new File("jfk.txt"); 
      Scanner input= new Scanner(ifile); 
    
      /*
       * Read the whole file into a string.
       */
      String textfile = ""; 
      while (input.hasNext()){
           //System.out.println("I am here."); 
           String token = input.nextLine(); // System.out.println(token); 
           textfile += token;  
        }
   
      /*
       * convert all words to lower case.
       */
      textfile = textfile.toLowerCase();  
      /*
       * keep only the alphanumeric letters and digits.
       */
      textfile = textfile.replaceAll("[^a-zA-Z0-9 ]", "");
      /*
       * Convert the words into array words[]
       */
      String[] words = textfile.split("\\s+"); 
     
      ArrayList<String>  wlist = new ArrayList<String>(); 
      ArrayList<Integer> clist = new ArrayList<Integer>(); 
    
      for (int i=0; i<words.length; i++){ // scan through the whole words array
           boolean found = false; 
           
           words[i] = words[i].trim(); 
           for (int j=0; j<wlist.size() && !found; j++){ 
               if (wlist.get(j).equals(words[i])){ // check if the word in already in the word list
                   found = true; 
                   clist.set(j, clist.get(j)+1);  // if yse, increase the word occurrence count. 
                }
            }
            
           if (!found) { // if the word in not in the word list, add it in. 
               wlist.add(words[i]); 
               clist.add(1); 
            }
        }
        
      //Now, perform the word sorting on it.  
      // Sort it in descending order 
      // put a new element in front of an element which has lower occurrence count. 
      LinkedList<String>  sWList = new LinkedList<String>(); 
      LinkedList<Integer> sCList = new LinkedList<Integer>(); 
      
      // Put the first elements in the new list. 
      if (wlist.size() !=0){
        sWList.add(wlist.get(0));
        sCList.add(clist.get(0)); 
      }
      
      for (int i=1; i<wlist.size(); i++){ // put the second and other elements into the arralist
            boolean found = false;        // default: not in the list yet. 
            for (int j=0; j<sWList.size() && !found; j++){  // insert an element to the right location
               if (sCList.get(j) < clist.get(i)){   // find the location that has a smaller count
                     found = true; 
                     sWList.add(j, wlist.get(i)); 
                     sCList.add(j, clist.get(i)); 
                } 
            }
            if (!found) {  // if no element is of fewer occurrence. 
                sWList.add(wlist.get(i)); 
                sCList.add(clist.get(i)); 
            }
        }      
        
      for (int i=0; i< sWList.size(); i++){
          System.out.println(sWList.get(i)+" "+sCList.get(i)); 
        }
    }
}