/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Skerby;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author DELL
 */
public class ScoreManager {
    private List<Score> nameAndScore = new ArrayList<>();
    private Score[] fiveScore = new Score[5];
    private Player player;
    private EnterYourName eyn;

    public ScoreManager() {
//        recordScore();
        loadTextScore();
        sortScore();
    }

    private InputStream readTextScore() {
        String filename = "score.txt";
        ClassLoader loader = ScoreManager.class.getClassLoader();
        InputStream in = loader.getResourceAsStream(filename);
        if (in == null) {
            System.out.println("Error reading file from: " + filename);
            return null;
        }
        return in;
    }

    public void loadTextScore() {
        InputStream in = readTextScore();
        Scanner readText = new Scanner(in);
        //String[] seperate = new String[2];
        while (readText.hasNextLine()) {
            String list = readText.nextLine();
            if (list.startsWith("#")) {
                continue;
            }
            String name = list.split(",")[0].trim();
            int score = Integer.parseInt(list.split(",")[1].trim());
            Score scores = new Score(name, score);
            nameAndScore.add(scores);
        }
        readText.close();
    }

    public static void recordScore() {
        String outputfile = "score.txt";
        OutputStream out = null;
        try {
            out = new FileOutputStream(outputfile, true);
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open output file " + outputfile);
            return;
        }
        PrintStream printOut = new PrintStream(out);
        printOut.printf("%s , %d\n", EnterYourName.yourName,Player.getScore());
        printOut.close();
        
    }

    public void sortScore() {
        boolean check = true;
        outerloop:
        for (int round = 0; round < 5; round++) {
            for (int i = 0; i < nameAndScore.size(); i++) {
                for (int j = 0; j < nameAndScore.size(); j++) {
                    if (nameAndScore.get(i).getScore() < nameAndScore.get(j).getScore()) {
                        check = false;
                    }
                }
                if (check) {
                    fiveScore[round] = nameAndScore.get(i);
                    nameAndScore.remove(i);
                    continue outerloop;
                }
                check = true;
            }
        }
    }

    public Score[] getNameScores() {
        return fiveScore;
    }

    public void deleteInformation() {
        for (int i = 0; i < nameAndScore.size(); i++) {
            nameAndScore.remove(i);
        }
    }
}