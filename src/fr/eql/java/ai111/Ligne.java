package fr.eql.java.ai111;

import javax.sound.midi.Soundbank;
import javax.swing.JOptionPane;
import java.util.Collections;

public class Ligne {
    public static void main(String[] args) {


    }

    String ligne;
    int space = 0;
    int word = 1;
    int carac = 0;
    String[] ligneParts;
    int justifed_space = 0;
    String result ="" ;


    public void execute() {
        findWords();
        findSpaces();
        caractere();
        splitParts();
        calculVide();
        Justifed_ligne();

    }

    private void findWords() {

        ligne = JOptionPane.showInputDialog("Veuillez entrer votre phrase : ");

        System.out.println(ligne);
        if (String.valueOf(ligne.charAt(0)).equals(" ")) {
            word = 0;
            for (int x = 0; x < ligne.length(); x++) {
                if (String.valueOf(ligne.charAt(x)).equals(" ") && !String.valueOf(ligne.charAt(x + 1)).equals(" ")) {

                    word = word + 1;
                }
            }
        } else if (!String.valueOf(ligne.charAt(0)).equals(" ")) {


            for (int x = 0; x < ligne.length(); x++) {
                if (String.valueOf(ligne.charAt(x)).equals(" ") && !String.valueOf(ligne.charAt(x + 1)).equals(" ")) {
                    word = word + 1;
                }
            }
        }
        System.out.println("Le nombre de mots : " + word);

    }

    private void findSpaces() {
        // ligne = JOptionPane.showInputDialog("Veuillez entrer votre phrase : ");
        for (int x = 0; x < ligne.length(); x++)
            if (String.valueOf(ligne.charAt(x)).equals(" ")) {
                space = space + 1;
            }
        System.out.println("Le nombre d'espace est : " + space);

    }

    public void caractere() {
        carac = (ligne.length() - space);
        System.out.println("Le nombre de caractère est : " + carac);
    }

    public void splitParts() {
        ligneParts = ligne.split("\\s+");
        for (int i = 0; i < word; i++) {
            System.out.println(ligneParts[i]);
        }
    }
    public void calculVide(){
        justifed_space = (80 - carac) / word ;
        System.out.println("le nombre d'espace justifié : " + justifed_space);
    }

    public void Justifed_ligne(){
        for (int i = 0; i < word; i++){
            result =result + ligneParts[i] + String.join("", Collections.nCopies(justifed_space, " "));

        }
        System.out.println(result);
        JOptionPane.showMessageDialog(null,result);

    }
}


