package view;

import utilities.Utilities;

public class Input {
    public static boolean loopMore = true;
    public static String empty = "cannot be empty!";
    public Input() {
    }

    public String inputCodeAllowEmpty(String msg, String format) {
        return Utilities.inputCode(msg, format);
    }

    public String inputCode(String msg, String format) {
        String code = "";
        while(loopMore) {
            try {
                code = Utilities.inputCode(msg, format);

                if (code.isEmpty())
                    throw new Exception();

                return code;
            } catch (Exception e) {
                System.out.println("Code " + empty);
            }
        }
        return null;
    }

    public String inputNameAllowEmpty() {
        return Utilities.inputAString("Name: ", 3, 50);
    }

    public String inputName() {
        String name = "";
        while(loopMore) {
            try {
                name = Utilities.inputAString("Name: ", 3, 50);

                if (name.isEmpty())
                    throw new Exception();

                return name;
            } catch (Exception e) {
                System.out.println("Name " + empty);
            }
        }
        return null;
    }

    public String inputTitleAllowEmpty() {
        return Utilities.inputAString("Title: ", 3, 50);
    }

    public String inputTitle() {
        String title = "";
        while(loopMore) {
            try {
                title = Utilities.inputAString("Name: ", 3, 50);

                if (title.isEmpty())
                    throw new Exception();

                return title;
            } catch (Exception e) {
                System.out.println("Title " + empty);
            }
        }
        return null;
    }

    public String inputTypeAllowEmpty(String option) {
        String s = "", err = "Wrong format! Please read the instruction carefully.";
        boolean check = false;
        if (option.equalsIgnoreCase("topic")) {
            while(!check) {
                try {
                    s = Utilities.inputAString("Long/Short\n"
                            + "Long term lasts for 3-12 months.\nShort term lasts for 2-4 weeks.\n"
                            + "Please just type 'long' or 'short'\n");
                    check = s.equalsIgnoreCase("long") || s.equalsIgnoreCase("short");

                    if(!check)
                        throw new Exception();

                    return s;
                } catch (Exception e) {
                    System.out.println(err);
                }
            }
        } else {
            while(!check) {
                try {
                    s = Utilities.inputAString("Online/Offline\n" + "Please just type 'onl' or 'off'\n");
                    check = s.equalsIgnoreCase("onl") || s.equalsIgnoreCase("off");

                    if(!check)
                        throw new Exception();

                    return s;
                } catch (Exception e) {
                    System.out.println(err);
                }
            }
        }
        return null;
    }

    public String inputType(String option) {
        String s = "";
        while(loopMore) {
            try {
                s = inputTypeAllowEmpty(option);

                if (s.isEmpty())
                    throw new Exception();

                return s;
            } catch (Exception e) {
                System.out.println("Format " + empty);
            }
        }
        return null;
    }

    public String inputDurationAllowEmpty(String type) {
        String duration = "";
        if(type.equalsIgnoreCase("long")) {
            duration = Utilities.inputAnInteger("How many months does it last? - ", 3, 12) + "months";
        } else {
            duration = Utilities.inputAnInteger("How many weeks does it last? - ", 2, 4) + "weeks";
        }

        if (duration.equalsIgnoreCase("0 months") || duration.equalsIgnoreCase("0 weeks"))
            return "";
        return duration;
    }

    public String inputDuration(String type) {
        String duration = "";
        while(loopMore) {
            try {
                duration = inputDurationAllowEmpty(type);

                if (duration.isEmpty())
                    throw new Exception();

                return duration;
            } catch (Exception e) {
                System.out.println("Duration " + empty);
            }
        }
        return null;
    }

    public String inputDateAllowEmpty() {
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

        if (date == 0 && month == 0 && year == 0)
            return "";
        return String.format("%d/%d/%d", date, month, year);
    }

    public String inputDate() {
        String dateFormatted = "";
        while (loopMore) {
            try {
                dateFormatted = inputDateAllowEmpty();

                if (dateFormatted.isEmpty())
                    throw new Exception();

                return dateFormatted;
            } catch (Exception e) {
                System.out.println("Date " + empty);
            }
        }
        return null;
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
        System.out.println("Begin Date must before End Date!");
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

    public int inputTuitionFeeAllowEmpty() {
        return Utilities.inputAnInteger("Tuition Fee: ", 0);
    }

    public int inputTuitionFee() {
        int tuitionFee = 0;
        while(loopMore) {
            try {
                tuitionFee = Utilities.inputAnInteger("Tuition Fee: ", 0);

                if (tuitionFee == 0)
                    throw new Exception();

                return tuitionFee;
            } catch (Exception e) {
                System.out.println("Tuition Fee " + empty);
            }
        }
        return 0;
    }

    public int inputScoreAllowEmpty() {
        return Utilities.inputAnInteger("Score: ", 0, 10);
    }

    public int inputScore() {
        int score = 0;
        while(loopMore) {
            try {
                score = Utilities.inputAnInteger("Score: ", 0, 10);

                if (score == 0)
                    throw new Exception();

                return score;
            } catch (Exception e) {
                System.out.println("Score " + empty);
            }
        }
        return 0;
    }
}