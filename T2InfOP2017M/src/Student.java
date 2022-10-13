import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {

    private ArrayList<Course> activeCourses;
    private ArrayList<Course> completedCourses;
    private int maxCourses;

    public int getMaxCourses() {
        return maxCourses;
    }

    public void setMaxCourses(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    public Student(String fn, String ln, ArrayList<Course> active, ArrayList<Course> completed, int max){
        super(fn,ln);
        this.activeCourses = active;
        this.completedCourses = completed;
        this.maxCourses = max;
    }

    public boolean canEnroll(Course course){
        if (completedCourses.contains(course.getPrerequisiteCourses())
         && !activeCourses.contains(course) && !completedCourses.contains(course)
        && activeCourses.size() < getMaxCourses()){
            return true;
        }else {
            return false;
        }
    }

    public boolean enroll(Course course){
        if (canEnroll(course)){
            activeCourses.add(course);
            return true;
        }else{
            return false;
        }
    }

    public boolean complete(String courseName){
        ArrayList<Course> active = new ArrayList<Course>(activeCourses);
        for(Course course : active){
            if (activeCourses.equals(courseName)) {
                activeCourses.remove(course);
                completedCourses.add(course);
                return true;
            }
        }
        return false;
    }

    public HashMap<Course,String> getAllCourses(){
        HashMap<Course,String> output = new HashMap<Course, String>();

        for (Course course: activeCourses){
            output.put(course,"active");
        }
        for(Course course:completedCourses){
            output.put(course,"completed");
        }

        return output;
    }

    public String summary(){
        String output = "";
        for(Course course: activeCourses){
            output += course.getName() + " " + "(active)"+"\n";
        }
        for(Course course: completedCourses){
            output += course.getName() + " " + "(completed)" + "\n";
        }
        return output;
    }




}
