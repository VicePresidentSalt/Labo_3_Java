import java.io.*;
public class Jedit {

   public void editer(String args[])
   {
      boolean onContinue = true;
      // Gestion des erreurs
      if (args.length == 0)
      {
         System.out.println("Aucun Fichier cree / Aucun parametres");
         onContinue = false;
      }
      else if (args.length > 2)
      {
         System.out.println("Aucun Fichier cree / Trop de parametres");
         onContinue = false;
      }
      else if (!args[0].equals("-n") && args.length == 2)
      {
         System.out.println("Aucun Fichier cree / Option invalide");
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

         //Vérification si le fichier existe ou non
         fichier = new File(nomFichier);
         if (fichier.exists())
         {
            System.out.println("Le fichier existe deja .");
            System.out.println("Voulez-vous le remplacer? O(oui) N(non)");
            try
            {
               BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // should be working now have to try
               char reponse = (char)br.read();

               //Si existe écraser
               if (reponse == 'o' || reponse == 'O')
               {
                  System.out.println("Le fichier sera modifie / Fichier ecrase");

                  lireetecrire(args.length, args);
               }
               // Refus de remplacer
               else
               {
                  System.out.println("Refus / le fichier ne sera pas modifie / opération annulee");
               }
            }
            catch (IOException ioe)
            {
               System.err.println(ioe);
               System.exit(1);
            }
         }
         // Si n'existe pas écrire
         else
         {
            lireetecrire(args.length, args);
         }
      }
   }
   //Fonction de lecture et d'écriture
   private void lireetecrire(int nbarguments, String[] args)
   {
      boolean numero;
      String nomFichier;
      // Évaluer le nombre d'argument si implementation de  # de ligne est requise
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
         //Lecture & Écriture
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
         PrintWriter writer = new PrintWriter(
            new BufferedWriter(
            new FileWriter(nomFichier)));

         //Compteur a 1 pour # de ligne
         int compteur = 1;
         // Lecture de la ligne entré
         String ligne = reader.readLine();
         //Pendant que la ligne lu n'est pas vide
         while (!ligne.trim().isEmpty())
         {
            //Si # de ligne est requis
            if (numero)
            {
               //1ere ligne avec #
               if (compteur > 1)
               {
                  writer.print("\n" + compteur + ": " + ligne);
               }
               //le reste avec #
               else
               {
                  writer.print(compteur + ": " + ligne);
               }
               ++compteur;
               ligne = reader.readLine();
            }
            //Sans # -> Écriture
            else
            {
               writer.print(ligne);
               ligne = "\n" + reader.readLine();
            }
         }
         //Fermeture du flux
         writer.close();
      }
      catch (IOException ioe)
      {
         System.err.println(ioe);
         System.exit(1);
      }



   }
   //Main
   public static void main(String args[])
   {
      Jedit app = new Jedit();
      app.editer(args);
   }
}


