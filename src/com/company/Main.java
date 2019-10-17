package com.company;

import java.util.Scanner;

public class Main {
    // La classe utilitaire java.util.Scanner permet de parcourir un flux et d'en extraire son contenu en utilisant des expressions régulières
    static Scanner key = new Scanner(System.in);

    //******************SAISIR TABLEAU************************************************************************

    public static void saisirTableau(int tab[], int taille) {
        int i;
        for (i = 0; i < taille; i++) { // tant que i est inferieur a la taille du tableau on increment
            tab[i] = (int) (Math.random() * taille);
        }
    }

    //******************AFFICHER TABLEAU**********************************************************************

    public static void afficherTableau(int tab[], int taille) {
        int i;
        for (i = 0; i < taille; i++) {
            System.out.print(tab[i] + "\t"); // on affiche les valeurs du tableau
        }
        System.out.println("\n"); // Retour à la ligne
    }

    //****************************COPIE TABLEAU****************************************************************

    public static void copieTableau(int tab[], int tab1[], int taille) {

        for (int i = 0; i < taille; i++) {
            tab1[i] = tab[i]; // on copie les valeurs du tableau dans tab1
        }
    }

    //***************************TRI PAR insertion*************************************************************

    public static void tri_insertion(int tab[], int taille) {

        int i, j, min, temp;
        for (i = 0; i < taille - 2; i++) {
            min = i;
            for (j = i + 1; j < taille-1; j++) {
                if (tab[j] < tab[min]) {
                    min = j;
                }
            }
            if (i != min) {
                // Permutation
                temp = tab[i];
                tab[i] = tab[min];
                tab[min] = temp;
            }
        }
    }

    //*************************TRI SELECTION******************************************************************

    public static void tri_selection(int tab[], int taille) {

        int i, j, min, temp;
        for (i = 0; i < taille ; i++) {
            min = i;
            for (j = i + 1; j < taille; j++) {
                if (tab[j] < tab[min]) {
                    min = j;
                }
            }
            if (i != min) {
                // Permutation
                temp = tab[i];
                tab[i] = tab[min];
                tab[min] = temp;
            }
        }
    }

    //********************************************************************************************************

    public static void tri_bulle(int tab[], int taille) {

        boolean verif = false;
        int tmp;

        while (verif == false) {
            verif = true;
            for (int i = 0; i <= taille - 2; i++) {
                if (tab[i] > tab[i + 1]) {
                    tmp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = tmp;
                    verif = false;
                }

            }

        }
    }

    //***********************************************************************************************************

    public static void tri_shell(int tab[], int taille) {

        int n = 0;

        while (n < taille) {
            n = 3 * n + 1;
        }
        while (n != 0) {
            n = n / 3;
            for (int i = n; i < taille; i++) {
                int valeur = tab[i];
                int j = i;

                while ((j > (n - 1)) && (tab[j - n] > valeur)) {
                    tab[j] = tab[j - n];
                    j = j - n;
                }
                tab[j] = valeur;
            }
        }
    }

    //***********************tri rapide*************************************************************************

    private static int partitionRapide(int tab[],int deb,int fin) {

        int temp,cpt=deb;
        int pivot=tab[deb];

        for(int i=deb+1;i<=fin;i++) {
            if (tab[i]<pivot) {
                cpt++;
                temp=tab[i];
                tab[i]=tab[cpt];
                tab[cpt]=temp;
            }
        }
        temp=tab[deb];
        tab[deb]=tab[cpt];
        tab[cpt]=temp;
        return(cpt);
    }
    private static void trirapide(int tab[],int deb,int fin) {
        if(deb<fin) {
            int positionPivot=partitionRapide(tab,deb,fin);
            trirapide(tab,deb,positionPivot-1);
            trirapide(tab,positionPivot+1,fin);
        }
    }

    //******************************************************************************************************
    //Que veut dire le main d'un programme java ? public indique que le main est accessible à partir d'autres classes;
    // static permet d'invoquer la méthode sans instancier l'objet de la classe; void signifie une procédure qui n'a pas de type de retour.
    //******************************************************************************************************
    public static void main(String[] args) {

        int capacite;

        System.out.println("Entrer le nombre des valeurs stockées dans le tableau: "); // Demade un nombre a l'utilisateur
        capacite = key.nextInt(); // Lecture du nombre

        /* L' opérateur new instancie une classe en allouant de manière dynamique (c'est-à-dire, au moment de l'exécution) de la mémoire pour un nouvel objet et en renvoyant une référence à cette mémoire.*/
        int[] tableau = new int[capacite]; //déclaration du tableau avec la valeur que l'utilisateur a rentré
        int[] tableau2 = new int[capacite]; //déclaration du tableau de copie

        saisirTableau(tableau, capacite); //Execution des fonctions
        copieTableau(tableau, tableau2, capacite); // ici la copie du tableau
        afficherTableau(tableau, capacite);

//***********************************************************************************************************
        //La méthode java. currentTimeMillis () renvoie le temps ecoulé en millisecondes.
        long debut = System.currentTimeMillis();
        tri_shell(tableau, capacite);
        long fin = System.currentTimeMillis(); // fin du chrono
        afficherTableau(tableau, capacite);
        long tempsShell = fin - debut; // j'initialise la valeur du chrono dans une variable
        copieTableau(tableau2, tableau, capacite); // la on recopie le tableau initiale pour le tri suivant

//***********************************************************************************************************
        debut = System.currentTimeMillis();
        tri_insertion(tableau, capacite);
        fin = System.currentTimeMillis();
        afficherTableau(tableau, capacite);
        long tempsinsertion = fin - debut;
        copieTableau(tableau2, tableau, capacite);

//***********************************************************************************************************
        debut = System.currentTimeMillis();
        tri_selection(tableau, capacite);
        fin = System.currentTimeMillis();
        afficherTableau(tableau, capacite);
        long tempsSelection = fin - debut;
        copieTableau(tableau2, tableau, capacite);

//**********************************************************************************************************
        debut = System.currentTimeMillis();
        tri_bulle(tableau, capacite);
        fin = System.currentTimeMillis();
        afficherTableau(tableau, capacite);
        long tempsbulle = fin - debut;
        copieTableau(tableau2, tableau, capacite);

//**********************************************************************************************************

        debut = System.currentTimeMillis();
        trirapide(tableau,0,tableau.length - 1);
        fin = System.currentTimeMillis();
        afficherTableau(tableau, capacite);
        long tempsrapide = fin - debut;
        copieTableau(tableau2, tableau, capacite);

//**********************************************************************************************************
        // ici on affiche les resultats des chrono
        System.out.println(" le temps pour le tri shell est de " + tempsShell);
        System.out.println(" le temps pour tri a insertion " + tempsinsertion);
        System.out.println(" le temps pour tri a selection " + tempsSelection);
        System.out.println(" le temps pour tri a bulle " + tempsbulle);
        System.out.print(" le temps pour tri rapide " + tempsrapide);
    }
}
