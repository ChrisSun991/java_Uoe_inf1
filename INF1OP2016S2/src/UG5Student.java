public class UG5Student extends Student {

    private int extraLevel9s;

    public UG5Student( String name, String uun, int att) {
        super(name,uun,5);
        this.extraLevel9s = att;
    }

    public UG5Student() {
        this("not set", "not set",0);
    }

    public int level9s(){

        Course[] courses = super.getCourses();

        int index = 0;

        for ( int i = 0; i < courses.length; i++ ) {
            if (courses[i].getLevel() == 9){
                index ++;
            }
        }
        return index;

    }

    public boolean addCourse(Course c) {
        if (c.getLevel() == 9) {
            if (this.level9s() <= (extraLevel9s + 1)) {
                super.addCourse(c);
                return true;
            }
            return false;
        }
        else{
            return super.addCourse(c);
        }
    }

    public String toString() {
        String output = super.toString();
        output += "Taking extra level 9s. Permission for " + extraLevel9s + " extra." + "\n";
        Course[] courses = super.getCourses();
        for (Course c : courses) {
            output += c + "\n";
        }
        return output;
    }
}
