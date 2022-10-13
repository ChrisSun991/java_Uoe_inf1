import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person {

    private ArrayList<Course> activeCourses;
    private ArrayList<Course> completedCourses;
    private int maxCourses;

    public Student (String fn, String ln, ArrayList<Course> active, ArrayList<Course> completed, int mc){
        super(fn,ln);
        this.activeCourses = active;
        this.completedCourses = completed;
        this.maxCourses = mc;
    }

    public int getMaxCourses() {
        return maxCourses;
    }

    public void setMaxCourses(int maxCourses) {
        this.maxCourses = maxCourses;
    }

    public boolean canEnroll (Course course){
        if (completedCourses.contains(course.getPrerequisiteCourses()) && !activeCourses.contains(course)
                && !completedCourses.contains(course) && activeCourses.size() < maxCourses){
            return true;
        }else{
            return false;
        }
    }

    public boolean enroll (Course course){
        if (canEnroll(course)){
            activeCourses.add(course);
            return true;
        }else{
            return false;
        }
    }

    public boolean complete(String courseName) {
        boolean count = false;
        Course toRemove = null;

        for (Course course : activeCourses) {
            if (course.getName().equals(courseName)){
                count = true;
                toRemove = course;
            }
        }

        if (count) {
            activeCourses.remove(toRemove);
            completedCourses.add(toRemove);
        }
        return count;
    }

    public HashMap<Course,String> getAllCourses(){
        HashMap<Course, String> outputMap = new HashMap<Course, String>();
        Course[] activeCourseList = activeCourses.toArray(new Course[activeCourses.size()]);
        Course[] completedCourseList = completedCourses.toArray(new Course[completedCourses.size()]);
        for (int i = 0; i < activeCourseList.length; i++){
            outputMap.put(activeCourseList[i],"active");
        }
        for (int j = 0; j < completedCourseList.length; j++) {
            outputMap.put(completedCourseList[j], "completed");
        }
        return outputMap;
    }

    public String summary(){
        String output = "";
        for (Map.Entry<Course,String> entry : getAllCourses().entrySet()){
            output += entry.getKey() + "(" + entry.getValue() + ")" + "\n";
        }
        return output;
    }


}
