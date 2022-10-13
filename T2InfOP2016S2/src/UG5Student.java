import static java.lang.System.*;

public class UG5Student extends Student{

    private int extraLevel9s;

    public UG5Student(String name, String UUN, int attribute){
        super(name, UUN, 5);
        this.extraLevel9s = attribute;
    }

    public UG5Student(){
        this("not set", "not set", 0);
    }

    public int level9s(){
        Course[] course = super.getCourses();

        int index = 0;

        for (int i = 0; i < course.length; i++){
            if (course[i].getLevel() == 9){
                index++;
            }
        }
        return index;
    }

    @Override
    public boolean addCourse(Course c){

        int maxLevel9s = extraLevel9s + 1;

        int currentLevel9s = 0;

        for (Course course : getCourses()){
            if(course.getLevel() == 9) {
                currentLevel9s++;
            }else if (course.getLevel() < 9){
                super.addCourse(c);
            }
        }

        if (currentLevel9s == maxLevel9s){
            return false;
        }
        return super.addCourse(c);

    }

    public String toString(){
        String output = super.toString() + "\n";

//        output += "Taking extra level 9s. Permission for " + extraLevel9s + " extra.";
        boolean takingExtra = false;

        Course[] courses = super.getCourses();
        for (Course course : courses){
            if(course.getLevel() == 9) {
                takingExtra = true;
                break;
            }
//            output += "/n" + course.getName();
        }

        if (takingExtra) {
            output += String.format("\nTaking extra level 9s. Permmision for %d extra.", extraLevel9s);
            for (Course course : courses) {
                output += "\n" + course.getName();
            }
        }
        //out.println(output);
        return output.trim();
    }

}
