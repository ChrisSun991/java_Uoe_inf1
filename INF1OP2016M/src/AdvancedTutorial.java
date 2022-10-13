
import java.util.HashMap;
import java.util.ArrayList;

public class AdvancedTutorial extends Tutorial{

    private String topic;

    public AdvancedTutorial(String topic, String tutor, String time) {
        super(tutor,time);
        this.topic=topic;
    }

    public String toString() {
        String output = "";
        output += "Topic: " + topic;
        output += super.toString();
        return output;
    }

    public boolean couldCombineWith ( AdvancedTutorial advTut) {
        if(advTut.getTime().equals(this.getTime()) && advTut.topic.equals(this.topic)){
            return true;
        }else{
            return false;
        }
    }

    public static HashMap<String, ArrayList<AdvancedTutorial>> construct (String[] input){

        HashMap<String, ArrayList<AdvancedTutorial>> result = new HashMap<String, ArrayList<AdvancedTutorial>>();
        ArrayList<AdvancedTutorial> tutorials = new ArrayList<AdvancedTutorial>();

        for (int i = 0; i < input.length/3; i++) {

            AdvancedTutorial a = new AdvancedTutorial(input[i*3],input[(i*3)+1],input[(i*3)+2]);
            tutorials.add(a);
        }

        ArrayList<String> b = new ArrayList<String>();
        for (int i = 0; i < input.length; i = i + 3) {
            b.add(input[i]);
        }

        for (String str : b){
            ArrayList<AdvancedTutorial> d = new ArrayList<AdvancedTutorial>();
            for (AdvancedTutorial c : tutorials){
                if (str.equals(c.topic)){
                    d.add(c);
                }
            }result.put(str,d);
        }return result;
    }

    public static void main (String[] args){
        if ( args.length > 0 && args.length % 3 == 0) {
            System.out.println(args);
        }else{
            System.out.println("Wrong number of arguments!");
        }
    }



}

