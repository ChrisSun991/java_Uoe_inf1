public class UG1Student extends Student{

    private char mainSchedule;

    public UG1Student(String name, String uun, char att) {
        super(name,uun,1);
        this.mainSchedule = att;
    }

    public UG1Student(){
        this("not set", "not set", 'X' );

    }

    public boolean addCourse ( Course course) {

        if (course.getLevel() == 7 || course.getLevel() == 7){
            return super.addCourse(course);

        }
        return false;
    }

    public boolean addCourses(Course[] courses) {

        boolean overall = true;

        for (int i = 0; i < courses.length; i++) {
            overall = overall && addCourse(courses[i]);
        }

        return overall;
    }

    public String toString() {
        String output = super.toString() + "\n";
        output += "Main schedule" + mainSchedule + "courses:" + "\n";
        Course[] courses = super.getCourses();
        for (Course course : courses) {
            output += course.getName() + "\n";
        }

        return output;
    }
}
