package model;

import utilities.Utilities;
import view.Input;

import java.util.ArrayList;

public class CoursesProgramModel {
    protected Input input;
    private String pathFile;
    CourseManagement courseMana = new CourseManagement();
    TopicManagement topicMana = new TopicManagement();
    LearnerManagement learnerMana = new LearnerManagement();

    public CoursesProgramModel(String pathFile) {
        this.pathFile = pathFile;
    }

    public void addATopic(Topic t) {
        t.setCode(Utilities.generateCode(++Topic.index, "T%04d"));
        topicMana.topics.add(t);
    }


    class CourseManagement {
        protected ArrayList<Course> courses;

    }

    class TopicManagement {
        protected ArrayList<Topic> topics;

        public ArrayList<Topic> getTopics() {
            return topics;
        }

        public Topic inputTopic() {
            Topic t = new Topic();

            t.setName(input.inputName());
            t.setType(input.inputType("topic"));
            t.setTitle(input.inputTitle());
            t.setDuration(input.inputDuration(t.getType()));

            return t;
        }
    }

    class LearnerManagement {
        protected ArrayList<Learner> learners;
    }
}