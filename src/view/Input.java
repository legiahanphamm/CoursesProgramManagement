package view;

import utilities.Utilities;

public class Input {
    public Input() {
    }

    public String inputName() {
        return Utilities.inputAString("Name: ");
    }

    public String inputTitle() {
        return Utilities.inputAString("Title: ");
    }

    public String inputType(String option) {
        String s = "", err = "Wrong format! Please read the instruction carefully.";
        boolean check = false;
        if (option.equalsIgnoreCase("topic")) {
            while(!check) {
                try {
                    s = Utilities.inputAString("Long/Short\n"
                            + "Long term lasts for 3-12 months.\nShort term lasts for 2-4 weeks.\n"
                            + "Please just type 'long' or 'short'\n");
                    check = s.equalsIgnoreCase("long") || s.equalsIgnoreCase("short");
                } catch (Exception e) {
                    System.out.println(err);
                }
            }
        } else {
            while(!check) {
                try {
                    s = Utilities.inputAString("Online/Offline\n" + "Please just type 'onl' or 'off'\n");
                    check = s.equalsIgnoreCase("onl") || s.equalsIgnoreCase("off");
                } catch (Exception e) {
                    System.out.println(err);
                }
            }
        }
        return s;
    }

    public String inputDuration(String type) {
        String duration = "";
        if(type.equalsIgnoreCase("long")) {
            duration = Utilities.inputAnInteger("How many months does it last? - ", 3, 12) + "months";
        } else {
            duration = Utilities.inputAnInteger("How many weeks does it last? - ", 2, 4) + "weeks";
        }
        return duration;
    }

    public String inputDate() {
        int date = 0;
        int year = Utilities.inputAnInteger("Year: ", 1, 2024);
        int month = Utilities.inputAnInteger("Month: ", 1, 12);
        if (month == 2) {
            if (year / 4 == 0) {
                date = Utilities.inputAnInteger("Date: ", 1, 29);
            } else {
                date = Utilities.inputAnInteger("Date: ", 1, 28);
            }
        } else if (checkMonth(month)) {
            date = Utilities.inputAnInteger("Date: ", 1, 31);
        } else {
            date = Utilities.inputAnInteger("Date: ", 1, 30);
        }

        System.out.println("Date is formatted to dd/MM/YYYY");
        return String.format("%d/%d/%d", date, month, year);
    }

    public boolean checkDate(String beginDate, String endDate) {
        int[] begin = splitDate(beginDate.split("/"));
        int[] end = splitDate(endDate.split("/"));

        if(begin[2] < end[2])
            return true;

        if(begin[2] == end[2]) {
            if(begin[1] < end[1])
                return true;
            if(begin[1] == end[1]) {
                return begin[0] < end[0];
            }
        }
        return false;
    }

    public int[] splitDate(String[] date) {
        int[] splitDate = new int[] {
                Integer.parseInt(date[0]),
                Integer.parseInt(date[1]),
                Integer.parseInt(date[2])
        };
        return splitDate;
    }

    public boolean checkMonth(int month) {
        int[] monthA = {1, 3, 5, 7, 8, 10, 12};
        int[] monthB = {4, 6, 9, 11};

        for (int i : monthA) {
            if (i == month) {
                return true;
            }
        }

        for (int i : monthB) {
            if (i == month) {
                return true;
            }
        }
        return false;
    }

    public int inputTuitionFee() {
        return Utilities.inputAnInteger("Tuition Fee: ", 0);
    }

    public int inputScore() {
        return Utilities.inputAnInteger("Score: ", 0, 10);
    }
}