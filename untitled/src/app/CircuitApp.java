package app;

import src.electronique.Composant;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class CircuitApp {
    public CircuitApp() {

    }

    static void main(String[] args) {
        fairelestests();
    }

    static void fairelestests() {
        File[] files = ouverturefichiers();
        double resistance = calculerficher(files);
        System.out.println("la resistance de se circuits est de est de :"+resistance+"Ω");
        quitterprogramme_1();
    }

    private static File[] ouverturefichiers() {
        String directoryPath = "u:\\Users\\APP4-gr1\\app 4\\APP_4\\untitled";
        File drectory = new File(directoryPath);
        File[] files = drectory.listFiles();
        return files;
    }

    private static double calculerficher(File[] files) {
        int reponse_int = -1;
        String reponse_String = "";
        Scanner sc = new Scanner(System.in);
        while (reponse_int == -1 || !reponse_String.equals("n")) {
            System.out.println("Bienvenue, ce programme est a l'utilité de calculer la resistance dans les circuits suivant:");
            for (int i = 0; i < files.length; i++) {
                System.out.println("-" + i + "." + files[i].getName());
                try {
                    reponse_int = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    reponse_String = sc.nextLine();
                    reponse_String.toLowerCase();
                }
            }
            System.out.println("écriver le nombre associé au circuits suivant pour savoir sa resistance ou N pour quitter le programme");
        }
        if (!(reponse_int == -1)) {
            File file = files[reponse_int];
            String e = file.getName();
            CircuitBuilder c = new CircuitBuilder();
            Composant composants = c.construireCircuit(e);
            double resistance = composants.calculerResistance();
            return resistance;
        } else if (reponse_String.equals("n")) {
            quitterprogramme_1();
        }
        throw new RuntimeException("aucune des ligne et verification ne peut de mené içi??? comment????");
    }

    private static void quitterprogramme_1() {
        String reponse_quitter_1 = "";
        Scanner sc_quitter_1 = new Scanner(System.in);
        while (reponse_quitter_1.equals("r") && reponse_quitter_1.equals("q")) {
            System.out.println("voulez vous vraiment quitter se magnifique programme? \n quitter le programme(q) \n recommencer les tests(r)");
            reponse_quitter_1 = sc_quitter_1.nextLine();
            try {
                reponse_quitter_1.toLowerCase();
            } catch (Exception e) {
                System.out.println("ne pas rentré de nombre s'il vout plaît");
            }
        }
        if (reponse_quitter_1.equals("r")) {
            fairelestests();
        }
        if (reponse_quitter_1.equals("q")) {

        }
    }

    private static void quitterprogramme_2() {
        String reponse_quitter_2 = "";
        Scanner sc_quitter_2 = new Scanner(System.in);
        while (reponse_quitter_2.equals("r") && reponse_quitter_2.equals("q")) {
            System.out.println("VRAIMENT... :(\n quitter le programme (GROS MÉCHANT) (q) \n recommencer les tests (YOUPI) (r)");
            reponse_quitter_2 = sc_quitter_2.nextLine();
            try {
                reponse_quitter_2.toLowerCase();
            } catch (Exception e) {
                System.out.println("ne pas rentré de nombre s'il vout plaît");
            }
        }
        if (reponse_quitter_2.equals("r")) {
            fairelestests();
        }
        if (reponse_quitter_2.equals("q")) {
            System.exit(0);
        }
    }
}


