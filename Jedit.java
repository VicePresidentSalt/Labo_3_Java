import java.io.*;
public class Jedit
{
	
   public void editer( String args[] )
   {
      PrintWriter writer;
	   String nomFichier
	   		
	   		if(args[2] == "-n")
	    	nomFichier = args[3]; // Nom du Ficher est contenu dans l'argument 3 exemple java Jedit -n exemple.txt
	   		else
	   		nomFichier = args[2]; // Nom du Ficher est contenu dans l'argument 2 exemple java Jedit exemple.txt
	   try
	   {
	   		writer = new PrintWriter(
	   					new BufferedWriter(
	   						new FileWriter(nomFicher)));
	   					
	   		if(nomFichier.exists())
	   		{
	   			System.out.println("Le fichier existe deja .")
	   			System.out.println("Voulez-vous le remplacer? O(oui) N(non)")
	   			
	   		}
	   		
	   			
	   }
   }
   
   public static void main( String args[] )
   {
	  Jedit app = new Jedit();
      app.editer( args );
   }
}