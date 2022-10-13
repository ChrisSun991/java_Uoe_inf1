import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.lang.reflect.Array;
import java.util.*;

class RockPaperScissors {

    /**
     * Returns if a given symbol is a valid symbol for the
     * game.
     * @param symbol the symbol to be checked
     * @return true if the given symbol is valid, false otherwise
     */
    public static boolean isValidSymbol(char symbol) {
        return symbol == 'R' || symbol == 'P' || symbol == 'S';
    }

    public static List<Matchup> parseMatchups(String[] args) {
        List<Matchup> output = new ArrayList<Matchup>();
        for (int i = 0; i < args.length; i++){
            char[] c = args[i] .toCharArray();
            if (c.length == 2){
                boolean val = true;
                for (int j = 0; j < c.length; j++){
                    if (isValidSymbol(c[j])){
                        val = val && true;
                    }else{
                        val = val && false;
                    }
                }
                if (val){
                    output.add(new Matchup(c[0],c[1]));
                }
            }
        }
        return output;
    }

    /**
     * Returns the outcome of a given matchup as String.
     *
     * @param match The matchup to be decided.
     * @return a String representation of the matchup result; R, P, S or DRAW
     * @throws IllegalArgumentException if the given matchup parameter is null
     */
    public static String decideOutcome(Matchup match) {
        if(match == null)
            throw new IllegalArgumentException("Given match must not be null!");

        String res = "" + match.getPlayerOne() + match.getPlayerTwo();

        if (res.equals("RP") || res.equals("PR")) return "P";
        if (res.equals("RS") || res.equals("SR")) return "R";
        if (res.equals("PS") || res.equals("SP")) return "S";

        return "DRAW";
    }

    public static Map<String, Integer> countOutcomes(List<Matchup> matches) {
        Hashtable<String, Integer> output = new Hashtable<String,Integer>();
        if (matches.size() == 0){
            System.out.println("Output:");
            return output;
        }
        int mostCount = 0;
        String mostSymbol = null;
        for (Matchup match : matches){
            String result = decideOutcome(match);
            if (!output.containsKey(result)){
                output.put(result,1);
            }else{
                output.put(result,output.get(result) + 1);
            }

            if (mostSymbol == null || mostCount < output.get(result)){
                mostCount = output.get(result);
                mostSymbol = result;
            }
        }
        if (mostSymbol != null){
            System.out.println("Most outcomes: " + mostSymbol);
        }
        return output;
    }

    /**
     * Executes different functionality for the game RockPaperScissors.
     *
     * @param args A series of matchups encoded as pairs of single characters.
     * The series of matchups can be empty.
     */
    public static void main(String[] args) {
        List<Matchup> matches = parseMatchups(args);
        System.out.println(matches);

        if(matches != null) {
            System.out.println(matches.size() + " matches parsed.");

            System.out.println("\nCount outcomes per symbol...");
            Map<String, Integer> outcomesPerSymbol = countOutcomes(matches);
            System.out.println(outcomesPerSymbol);
        }
    }

}