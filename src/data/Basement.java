package data;

public abstract class Basement {
    protected String code;
    protected String name;
    protected String type;
    protected String title;

    public Basement() {
    }

    public Basement(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Basement(String code, String name, String type, String title) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String format) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
