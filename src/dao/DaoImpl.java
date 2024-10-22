package dao;

import data.Course;
import data.Learner;
import data.Topic;
import utilities.Utilities;
import view.Input;

import java.util.ArrayList;

public class DaoImpl {
    protected Input input;
/*    private CourseManagement courseManagement;
    private TopicManagement topicManagement;
    private LearnerManagement learnerManagement; */

    public DaoImpl() {
    }

    public boolean saveToFile(String pathFile) {
        return false;
    }

     class CourseManagement implements DaoInt {
        protected ArrayList<Course> courses;
        protected TopicManagement topicMana = new TopicManagement();

        @Override
        public ArrayList<Course> getAll() {
            return courses;
        }

        @Override
        public Course input() {
            Course c = new Course();

            c.setName(input.inputName());
            c.setType(input.inputType("course"));
            c.setTitle(input.inputTitle());

            do {
                c.setBeginDate(input.inputDate());
                c.setEndDate(input.inputDate());
            } while(!input.checkDate(c.getBeginDate(), c.getEndDate()));

            c.setTuitionFee(input.inputTuitionFee());
            c.setTopic(setCourseTopic(input.inputCode("Course Code: ", "^C\\d{4}$")));

            return c;
        }

        @Override
        public void add(Object o) {
            Course c = (Course) o;
            c.setCode(Utilities.generateCode(++Course.index, "C%04d"));
            courses.add(c);
            System.out.println("Added successfully.");
        }

        @Override
        public Course searchByCode(String code) {
            for(Course c : courses) {
                if(c.getCode().equals(code)) {
                    return c;
                }
            }
            return null;
        }

        @Override
        public Course inputUpdateInfo() {
            Course u = new Course();

            u.setName(input.inputNameAllowEmpty());
            u.setType(input.inputTypeAllowEmpty("topic"));
            u.setTitle(input.inputTitleAllowEmpty());
            u.setTuitionFee(input.inputTuitionFeeAllowEmpty());

            return u;
        }

        @Override
        public Course update(String code) {
            Course c = searchByCode(code);
            if (c == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Updated unsuccessfully.");
            } else {
                Course u = inputUpdateInfo();
                do {
                    u.setBeginDate(input.inputDateAllowEmpty());
                    c.setBeginDate(u.getBeginDate().isEmpty() ? c.getBeginDate() : u.getBeginDate());

                    u.setEndDate(input.inputDateAllowEmpty());
                    c.setEndDate(u.getEndDate().isEmpty() ? c.getEndDate() : u.getBeginDate());
                } while(!input.checkDate(u.getBeginDate(), u.getEndDate()));

                c.setName(u.getName().isEmpty() ? c.getName() : u.getName());
                c.setType(u.getType().isEmpty() ? c.getType() : u.getType());
                c.setTitle(u.getTitle().isEmpty() ? c.getTitle() : u.getTitle());
                c.setTuitionFee(u.getTuitionFee() == 0 ? c.getTuitionFee() : u.getTuitionFee());

                String newTopicCode = input.inputCodeAllowEmpty("Topic Code: ", "^T\\d{4}$");
                c.setTopic(setCourseTopic(newTopicCode) == null ? c.getTopic() : setCourseTopic(newTopicCode));

                System.out.println("Updated successfully.");
            }
            return c;
        }

        @Override
        public void remove(String code) {
            Course c = searchByCode(code);
            if (c == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Deleted unsuccessfully.");
            } else {
                courses.remove(c);
                System.out.println("Deleted successfully.");
            }
        }

        public Topic setCourseTopic(String code) {
            if (code.isEmpty())
                return null;

            boolean check = false;
            do {
                Topic t = topicMana.searchByCode(code);

                if(t == null) {
                    System.out.println("Not found Topic Code: " + code);
                } else {
                    return t;
                }
            } while (!check);
            return null;
        }
    }

    class TopicManagement implements DaoInt {
        protected ArrayList<Topic> topics;

        @Override
        public ArrayList<Topic> getAll() {
            return topics;
        }

        @Override
        public Topic input() {
            Topic t = new Topic();

            t.setName(input.inputName());
            t.setType(input.inputType("topic"));
            t.setTitle(input.inputTitle());
            t.setDuration(input.inputDuration(t.getType()));

            return t;
        }

        @Override
        public void add(Object o) {
            Topic t = (Topic) o;
            t.setCode(Utilities.generateCode(++Topic.index, "T%04d"));
            topics.add(t);
            System.out.println("Added successfully.");
        }

        @Override
        public Topic update(String code) {
            Topic t = searchByCode(code);
            if (t == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Updated unsuccessfully.");
            } else {
                Topic u = inputUpdateInfo();

                t.setName(u.getName().isEmpty() ? t.getName() : u.getName());
                t.setType(u.getType().isEmpty() ? t.getType() : u.getType());
                t.setTitle(u.getTitle().isEmpty() ? t.getTitle() : u.getTitle());
                t.setDuration(u.getDuration().isEmpty() ? t.getDuration() : u.getDuration());

                System.out.println("Updated successfully.");
            }
            return t;
        }

        @Override
        public void remove(String code) {
            Topic d = searchByCode(code);
            if (d == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Deleted unsuccessfully.");
            } else {
                topics.remove(d);
                System.out.println("Deleted successfully.");
            }
        }

        @Override
        public Topic searchByCode(String code) {
            for(Topic t : topics) {
                if(t.getCode().equals(code)) {
                    return t;
                }
            }
            return null;
        }

        @Override
        public Topic inputUpdateInfo() {
            Topic u = new Topic();

            u.setName(input.inputNameAllowEmpty());
            u.setType(input.inputTypeAllowEmpty("topic"));
            u.setTitle(input.inputTitleAllowEmpty());
            u.setDuration(input.inputDurationAllowEmpty(u.getType()));

            return u;
        }

        public ArrayList<Topic> searchTopicsByName(String name) {
            ArrayList<Topic> re = new ArrayList<>();
            for(Topic t : topics) {
                if(t.getName().contains(name)) {
                    re.add(t);
                }
            }
            return re;
        }
    }

    class LearnerManagement implements DaoInt {
        protected ArrayList<Learner> learners;
        protected CourseManagement courseMana = new CourseManagement();

        @Override
        public ArrayList<Learner> getAll() {
            return learners;
        }

        @Override
        public Learner input() {
            Learner l = new Learner();

            l.setName(input.inputName());
            l.setDob(input.inputDate());
            l.setScore(input.inputScore());
            l.setCourse(setLearnerCourse(input.inputCode("Course Code: ", "^C\\d{4}$")));

            return l;
        }

        @Override
        public void add(Object o) {
            Learner l = (Learner) o;
            l.setCode(Utilities.generateCode(++Learner.index, "L%04d"));
            learners.add(l);
            System.out.println("Added successfully.");
        }

        @Override
        public Learner searchByCode(String code) {
            for(Learner l : learners) {
                if(l.getCode().equals(code)) {
                    return l;
                }
            }
            return null;
        }

        @Override
        public Learner inputUpdateInfo() {
            Learner u = new Learner();

            u.setName(input.inputNameAllowEmpty());
            u.setDob(input.inputDateAllowEmpty());
            u.setScore(input.inputScoreAllowEmpty());

            return u;
        }

        @Override
        public Learner update(String code) {
            Learner l = searchByCode(code);
            if (l == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Updated unsuccessfully.");
            } else {
                Learner u = inputUpdateInfo();

                l.setName(u.getName().isEmpty() ? l.getName() : u.getName());
                l.setDob(u.getDob().isEmpty() ? l.getDob() : u.getDob());
                l.setScore(u.getScore() == 0 ? l.getScore() : u.getScore());
                String newCourseCode = input.inputCodeAllowEmpty("Course Code: ", "^C\\d{4}$");
                l.setCourse(setLearnerCourse(newCourseCode) == null ? l.getCourse() : setLearnerCourse(newCourseCode));

                System.out.println("Updated successfully.");
            }
            return l;
        }

        @Override
        public void remove(String code) {
            Learner l = searchByCode(code);
            if (l == null) {
                System.out.println("Not found code: " + code);
                System.out.println("Deleted unsuccessfully.");
            } else {
                learners.remove(l);
                System.out.println("Deleted successfully.");
            }
        }

        public Course setLearnerCourse(String code) {
            boolean check = false;
            do {
                Course c = courseMana.searchByCode(code);

                if(c == null) {
                    System.out.println("Not found Course Code: " + code);
                } else {
                    return c;
                }
            } while (!check);
            return null;
        }
    }
}