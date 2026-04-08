package app;

import java.io.File;
import java.util.Scanner;

public class CircuitApp {
    public CircuitApp(){

    }

    static void main(String[] args) {
 String directoryPath = "u:\\Users\\APP4-gr1\\app 4\\APP_4\\untitled";
    File drectory = new File(directoryPath);
    File[] files = drectory.listFiles();
    boolean valide = false;
     while(valide == false){
         System.out.println("Bienvenue, ce programme est a l'utilité de calculer la resistance dans les circuits suivant:");
         for(int i = 0; i < files.length; i++){
             System.out.println("-"+i +"."+files[i].getName());
         }
         System.out.println("écriver le nombre associé au circuits suivant pour savoir sa resistance ou N pour quitter le programme");

     }
    }

    }

