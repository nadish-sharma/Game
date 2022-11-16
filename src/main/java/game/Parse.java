package game;

import gameobjects.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static game.Game.useObject;

public class Parse {

    //Method to split an input string into a list of words using regular expression
    public static List<String> wordList(String input) {
        String delims = "[ \t,.:;?!\"']+";
        List<String> strlist = new ArrayList<>();
        String[] words = input.split(delims);
        for (String word : words) {
            strlist.add(word);
        }
        return strlist;
    }
    //Categorises a word list into allowed nouns and verbs
    private static void parseCommand(List<String> wordlist) {
        String verb;
        String noun = "";
        List<String> commands = new ArrayList<>(Arrays.asList("take", "drop", "n", "s", "w", "e","use", "talk"));
        List<String> obj = new ArrayList<>(Arrays.asList("Sword", "Potion", "Fang", "Spear", "Orange", "Plasma"));
        if(!(wordlist.size() > 0 && wordlist.size() <= 2)) {
            System.out.println("Maximum 2 words are allowed");
        } else {
            verb = wordlist.get(0);
            if(wordlist.size() == 2) {
                noun = wordlist.get(1);
            }
            if(!commands.contains(verb)) {
                System.out.println(verb + " is not a known verb");
            }
            else if(obj.contains(noun)) {
                System.out.println(noun + " is not a known noun");
            } else {
                switch (verb) {
                    case "take":
                        System.out.println(Game.takeObject(noun));
                        break;
                    case "drop":
                        System.out.println(Game.dropObject(noun));
                        break;
                    case "n":
                        Game.goN();
                        break;
                    case "s":
                        Game.goS();
                        break;
                    case "w":
                        Game.goW();
                        break;
                    case "e":
                        Game.goE();
                        break;
                    case "use":
                        useObject(noun);
                        break;
                    case "talk":
                        break;
                }
            }
          /*  if(!objects.contains(noun)) {
                System.out.println(noun + " is not a known noun");
            }

           */

        }
    }
    //Method to convert the input string to lower case and trim it
    //Calls wordList command to split the string into individual words
    // Calls parseCommand method to make sense of the word List
    public static String runCommand(String inputStr) {
        List<String> wl;
        String s = "ok";
        String lowStr = inputStr.trim().toLowerCase();
        if(!lowStr.equals("q")) {
            if(lowStr.equals("")) {
                s = "you must enter a command";
            } else {
                wl = wordList(lowStr);
                parseCommand(wl);
            }
        }
        return s;
    }
}
