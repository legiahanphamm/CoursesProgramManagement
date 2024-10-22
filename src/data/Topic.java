package data;

public class Topic extends Basement{
    private String duration;
    public static int index = 0;

    public Topic() {
        super();
    }

    public Topic(String code, String name, String type, String title, String duration) {
        super(code, name, type, title);
        this.duration = duration;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}