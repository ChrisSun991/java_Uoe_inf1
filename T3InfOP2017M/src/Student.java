import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student extends Person {
    private ArrayList<Course> activeCourses ;
    private ArrayList<Course> completedCourses ;
    private int maxCourses ;


    public Student(String firstname,String lastname,ArrayList<Course> activeCourses, ArrayList<Course> completedCourses,int maxCourses) {
        super(firstname,lastname);
        this.activeCourses = activeCourses;
        this.completedCourses = completedCourses;
        this.maxCourses = maxCourses;
    }
    public int getMaxCourses() {
        return maxCourses;
    }
    public void setMaxCourses(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    public boolean canEnroll(Course course){
        boolean con1 = completedCourses.containsAll(course.getPrerequisiteCourses()) ;
        boolean con2 = ! activeCourses.contains(course);
        boolean con3 = ! completedCourses.contains(course);
        boolean con4 = activeCourses.size()+1<=maxCourses;
        return con1&&con2&&con3&&con4;
    }

    public boolean enroll( Course course){
        if(canEnroll(course)){
            activeCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean complete(String courseName){
        ArrayList<Course> activeCourses1 = new ArrayList<Course>(activeCourses);
        for(Course course: activeCourses1){
            if(course.getName().equals(courseName)){
                activeCourses.remove(course);
                completedCourses.add(course);
                return true;
            }
        }
        return false;
    }

    public HashMap<Course,String> getAllCourses() {
        HashMap<Course,String> result = new HashMap<Course,String>();

        for(Course course: activeCourses){
            result.put(course,"active");
        }

        for(Course course: completedCourses){
            result.put(course,"completed");
        }

        return result;
    }

    public String summary(){
        String output = "";

        for(Course course: activeCourses){
            output += course.getName() +" "+"(active)"+"\n";
        }

        for(Course course: completedCourses){
            output += course.getName() +" "+"(completed)"+"\n";
        }

        return output;
    }

}