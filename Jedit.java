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
	   			char reponse = input.nextchar();
	   			if(reponse == n || reponse == N)
	   			{
	   				System.out.println("Le fichier ne sera pas modifi� / Refus")	
	   			}
	   			if(reponse == o || reponse == O)
	   			{
	   				System.out.println("Le fichier sera modifi� / Fichier �cras�")
	   				//R��criture du fichier a faire
	   			}
	   		}
	   		if(args[]<2)
	   		{
	   			System.out.println("Aucun Fichier cr�� / Aucun param�tres")	
	   		}
	   		if(args[]>3)
	   		{
	   			System.out.println("Aucun Fichier cr�� / Trop de param�tres")	
	   		}
	   		if(args[2] != "-n")
	   		{
	   			System.out.println("Aucun Fichier cr�� / Option invalide")		
	   		}
	   		
	   		
	   		
	   			
	   }
   }
   
   public static void main( String args[] )
   {
	  Jedit app = new Jedit();
      app.editer( args );
   }
}