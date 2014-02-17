import java.io.*;
public class Jedit
{
	
   public void editer( String args[] )
   {
      PrintWriter writer;
	  String nomFichier
	  BufferedReader Reader;
	  boolean pasFini = true;
	  String ligne;
	   		
	   		if(args[2] == "-n")
	    	nomFichier = args[3]; // Nom du Ficher est contenu dans l'argument 3 exemple java Jedit -n exemple.txt
	   		else
	   		nomFichier = args[2]; // Nom du Ficher est contenu dans l'argument 2 exemple java Jedit exemple.txt
	   try
	   {
	   		reader = new BufferedReader(
	   				     new FileReader(nomFichier));
	   		
	   		while(pasFini)	
	   		{
	   			ligne = reader.readLine();
	   			if( ligne != null)
	   			{
	   				System.out.println(ligne)
	   			}
	   			else
	   			{
	   				pasFini = false;
	   			}	
	   		}
	   		
	   		
	   		
	   		writer = new PrintWriter(
	   					new BufferedWriter(
	   						new FileWriter(nomFichier)));
	   		for(int i= 0; i < proverbes.length; i++)
	   		{
	   			writer.println(nomFichier[i]) ;
	   		}
	   		writer.close();
	   					
	   		
	   		if(args[2] == "-n")
	   		{
	   			for(int i=1 ; i < nomFichier.length ; i++)
	   			{
	   				System.out.println(i+":"+//ligne de texte);
	   			}
	   		}
	   		
	   		
	   		if(nomFichier.exists())
	   		{
	   			
	   			System.out.println("Le fichier existe deja .")
	   			System.out.println("Voulez-vous le remplacer? O(oui) N(non)")
	   			char reponse = input.nextchar();
	   			if(reponse == n || reponse == N)
	   			{
	   				System.out.println("Le fichier ne sera pas modifié / Refus")	
	   			}
	   			if(reponse == o || reponse == O)
	   			{
	   				System.out.println("Le fichier sera modifié / Fichier écrasé")
	   				//Réécriture du fichier a faire
	   			}
	   		}
	   		if(args[]<2)
	   		{
	   			System.out.println("Aucun Fichier créé / Aucun paramètres")	
	   		}
	   		if(args[]>3)
	   		{
	   			System.out.println("Aucun Fichier créé / Trop de paramètres")	
	   		}
	   		if(args[2] != "-n")
	   		{
	   			System.out.println("Aucun Fichier créé / Option invalide")		
	   		}
	   		
   
   	
   		}
   catch(IOException ioe)
   {
   		System.err.println(ioe);
   		System.exit(1);
   }
   	
   			
	 }
 }
   
   public static void main( String args[] )
   {

	  Jedit app = new Jedit();
      app.editer( args );

   }
}