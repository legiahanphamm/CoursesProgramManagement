package data;

public class Learner extends Basement {
    private String dob;
    private int score;
    private Course course;
    public static int index = 0;

    public Learner() {
    }

    public Learner(String code, String name, String dob, int score, Course course) {
        super(code, name);
        this.dob = dob;
        this.score = score;
        this.course = course;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
