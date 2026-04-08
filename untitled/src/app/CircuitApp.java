package app;

import src.electronique.Composant;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class CircuitApp {
    public CircuitApp() {

    }

    static void main(String[] args) {
        File[] files = ouverturefichiers();
        double resistance = calculerficher(files);
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
        }

    }


