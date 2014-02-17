import java.io.*;
public class Jedit {

   public void editer(String args[])
   {
      boolean onContinue = true;
      if (args.length == 0)
      {
         System.out.println("Aucun Fichier créé / Aucun paramètres");
         onContinue = false;
      }
      else if (args.length>2)
      {
         System.out.println("Aucun Fichier créé / Trop de paramètres");
         onContinue = false;
      }
      else if (args[0].equals("-n"))
      {
         System.out.println("Aucun Fichier créé / Option invalide");
         onContinue = false;
      }
      if (onContinue) // nous avons ici l'assurance que le nombre de parametre est valide et que l'option demande si tel est le cas est -n
      {
         String nomFichier
         File fichier;
         PrintWriter writer;
         BufferedReader Reader;
         boolean pasFini = true;
         String ligne;

         if (args.length == 2) //verification de ou est le nom de fichier
            nomFichier = args[1]; // Nom du Ficher est contenu dans l'argument 1 exemple java Jedit -n exemple.txt
         else
            nomFichier = args[0]; // Nom du Ficher est contenu dans l'argument 0 exemple java Jedit exemple.txt

         fichier = new File(nomFichier)
         if (fichier.exists())
         {
            System.out.println("Le fichier existe deja .");
            System.out.println("Voulez-vous le remplacer? O(oui) N(non)");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // should be working now have to try
            char reponse = (char)br.read();
            if (reponse == 'n' || reponse == 'N')
            {
               System.out.println("Le fichier ne sera pas modifié / Refus");
            }
            if (reponse == 'o' || reponse == 'O')
            {
               System.out.println("Le fichier sera modifié / Fichier écrasé");

               lireetecrire(args.length);
            }
         }
         else
         {
            lireetecrire(args.length);
         }
            // pas fou mais jaime pas i think i have a better idea TBV
         //if (args.length == 2)
         //{
         //   for (int i = 1; i < nomFichier.length; i++)
         //   {
         //      System.out.println(i + ":");//ligne de texte);
         //   }
         //}
      }
         //catch (IOException ioe)
         //{
         //   System.err.println(ioe);
         //   System.exit(1);
         //}
      }
   }

   private void lireetecrire(int nbarguments)
   {



   }

   public static void main( String args[] )
   {
      Jedit app = new Jedit();
      app.editer(args);
   }
}

