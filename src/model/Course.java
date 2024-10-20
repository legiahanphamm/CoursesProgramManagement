package model;

public class Course extends Basement {
    private String beginDate;
    private String endDate;
    private int tuitionFee;
    public static int index = 0;

    public Course(String code, String name, String type, String title, String beginDate, String endDate, int tuitionFee) {
        super(code, name, type, title);
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.tuitionFee = tuitionFee;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(int tuitionFee) {
        this.tuitionFee = tuitionFee;
    }
}
