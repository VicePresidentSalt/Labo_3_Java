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
      else if (args.length > 2)
      {
         System.out.println("Aucun Fichier créé / Trop de paramètres");
         onContinue = false;
      }
      else if (!args[0].equals("-n") && args.length == 2)
      {
         System.out.println("Aucun Fichier créé / Option invalide");
         onContinue = false;
      }
      if (onContinue) // nous avons ici l'assurance que le nombre de parametre est valide et que l'option demande si tel est le cas est -n
      {
         String nomFichier;
         File fichier;

         if (args.length == 2) //verification de ou est le nom de fichier
            nomFichier = args[1]; // Nom du Ficher est contenu dans l'argument 1 exemple java Jedit -n exemple.txt
         else
            nomFichier = args[0]; // Nom du Ficher est contenu dans l'argument 0 exemple java Jedit exemple.txt

         fichier = new File(nomFichier);
         if (fichier.exists())
         {
            System.out.println("Le fichier existe deja .");
            System.out.println("Voulez-vous le remplacer? O(oui) N(non)");
            try
            {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // should be working now have to try
               char reponse = (char)br.read();

               if (reponse == 'o' || reponse == 'O')
               {
                  System.out.println("Le fichier sera modifié / Fichier écrasé");

                  lireetecrire(args.length, args);
               }
               else
               {
                  System.out.println("Refus / le fichier ne sera pas modifié / opération annulée");
               }
            }
            catch (IOException ioe)
            {
               System.err.println(ioe);
               System.exit(1);
            }
         }
         else
         {
            lireetecrire(args.length, args);
         }
      }
   }

   private void lireetecrire(int nbarguments, String[] args)
   {
      boolean numero;
      String nomFichier;
      if (nbarguments == 1)
      {
         numero = false;
         nomFichier = args[0];
      }
      else
      {
         numero = true;
         nomFichier = args[1];
      }
      try
      {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter writer = new PrintWriter(
            new BufferedWriter(
            new FileWriter(nomFichier)));


         int compteur = 1;
         String ligne = reader.readLine();

         while (!ligne.trim().isEmpty())
         {
            if (numero)
            {
               if (compteur > 1)
               {
                  writer.print("\n" + compteur + ": " + ligne);
               }
               else
               {
                  writer.print(compteur + ": " + ligne);
               }
               ++compteur;
               ligne = reader.readLine();
            }
            else
            {
               writer.print(ligne);
               ligne = "\n" + reader.readLine();
            }
         }

         writer.close();
      }
      catch (IOException ioe)
      {
         System.err.println(ioe);
         System.exit(1);
      }



   }

   public static void main(String args[])
   {
      Jedit app = new Jedit();
      app.editer(args);
   }
}


