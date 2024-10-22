package view;

import java.util.ArrayList;

public class Menu {
    private ArrayList<String> mainMenu;
    private ArrayList<String> manageTopic;
    private ArrayList<String> manageCourse;
    private ArrayList<String> manageLearner;
    private ArrayList<String> searchInfo;

    public Menu() {
    }

    public void showMainMenu() {
        mainMenu.add("Manage the Topics.");
        mainMenu.add("Manage the Course.");
        mainMenu.add("Manage the Learner.");
        mainMenu.add("Search Information.");
        mainMenu.add("Save to file.");
        mainMenu.add("Exit.");

        for (int i = 0; i < mainMenu.size(); i++) {
            System.out.println((i + 1) + ". " + mainMenu.get(i));
        }
    }

    public void showManageTopic() {
        manageTopic.add("Add Topics to catalog.");
        manageTopic.add("Update Topic.");
        manageTopic.add("Delete Topic.");
        manageTopic.add("Display all Topics.");

        for (int i = 0; i < manageTopic.size(); i++) {
            System.out.println((i + 1) + ". " + manageTopic.get(i));
        }
    }

    public void showManageCourse() {
        manageCourse.add("Add Course.");
        manageCourse.add("Update Course.");
        manageCourse.add("Delete Course.");
        manageCourse.add("Display Course information.");
        manageCourse.add("Display all Courses.");

        for (int i = 0; i < manageCourse.size(); i++) {
            System.out.println((i + 1) + ". " + manageCourse.get(i));
        }
    }

    public void showManageLearner() {
        manageLearner.add("Add Learner to Course.");
        manageLearner.add("Enter scores for Learners.");
        manageLearner.add("Display Learner information.");

        for (int i = 0; i < manageLearner.size(); i++) {
            System.out.println((i + 1) + ". " + manageLearner.get(i));
        }
    }

    public void showSearchMenu() {
        searchInfo.add("Search Topic.");
        searchInfo.add("Search Course.");
        for (int i = 0; i < manageLearner.size(); i++) {
            System.out.println((i + 1) + ". " + manageLearner.get(i));
        }
    }
}
