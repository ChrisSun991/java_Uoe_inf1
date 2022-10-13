public class UG1Student extends Student {

    private char mainSchedule;

    public UG1Student(String name, String UUN, char attribute) {
        super(name, UUN, 1);
        this.mainSchedule = attribute;
    }

    public UG1Student(){
        this("not set", "not set", 'X');
    }

    public boolean addCourse(Course course){
        int level = course.getLevel();
        if ((level != 7) && (level != 8)){
            return false;
        }
        return super.addCourse(course);
    }

    public boolean addCourses(Course[] courses) {

        boolean output = true;

        for (int i = 0; i < courses.length; i++){
            boolean temp = addCourse(courses[i]);
            output = output && temp;
        }
        return  output;
    }

    public String toString(){
        String output = super.toString() + "\n";
        output += "Main schedule" + mainSchedule + "courses:";
     //   String output = String.format("%s\nMain schedule %c courses:", super.toString(),mainSchedule);
        Course[] courses = super.getCourses();
        for (Course course: courses){
            output += "\n" + course.getName();
        }
        return output.trim();
    }


}
