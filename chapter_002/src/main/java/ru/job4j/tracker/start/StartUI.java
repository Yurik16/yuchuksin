package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * StartUI class.
 *
 * @author Yury Chuksin
 * @version 1.1
 * @since 20.02.2017.
 */
public class StartUI {
    /**
     * isWorking exit form program.
     */
    private static boolean isWorking = true;

    /**
     * getIsWorking getter for boolean isWorking.
     *
     * @return boolean
     */
    public boolean getIsWorking() {
        return isWorking;
    }

    /**
     * setIsWorking setter for isWorking.
     * @param x boolean
     */
    public void setIsWorking(boolean x) {
        isWorking = x;
    }

    /**
     * creating new class Input.
     */
    private final Input input;

    /**
     * creating new class Tracker.
     */
    private Tracker tracker = new Tracker();

    /**
     * StartUI constructor of class.
     *
     * @param input   what kind of interface is using
     * @param tracker list of Items
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * creating new class Date.
     */
    private Date date = new Date();

    /**
     * creating new class SimpleDateFormat.
     */
    private SimpleDateFormat format1 = new SimpleDateFormat("dd.mm.yyyy hh:mm");

    /**
     * creating menu.
     */
    private final String[] menu = {
            "1.Добавление новой заявки",
            "2.Редактирование заявки.",
            "3.Удаление заявки.",
            "4.Отображение списка всех заявок.",
            "5.Отображение заявок с условием фильтра.",
            "6.Добавить к заявке комментарий.",
            "7.Выход из программы."
    };

    /**
     * getMenuName returns asking question.
     *
     * @param point num of asking question
     * @return asking question
     */
    private String getMenuName(int point) {
        return this.menu[point];
    }


    /**
     * init scroller of menu.
     *
     * @return numOfClaim user`s choice
     */
    public int init() {
        int numOfClaim;
        while (true) {
            for (String x : this.menu) {
                System.out.println(x);
            }
            String name = input.ask("Enter the number 1 ... 7 : ");
            numOfClaim = Integer.parseInt(name);
            int[] needTo = {0, 1, 2, 3, 4, 5, 6};
            for (int x : needTo) {
                if (x == numOfClaim - 1) {
                    System.out.println(getMenuName(numOfClaim - 1).substring(2));
                    return numOfClaim;
                }
                if (numOfClaim == 7) {
                    System.out.println(getMenuName(numOfClaim - 1).substring(2));
                    return numOfClaim;
                }
            }
            System.out.println("Don`t expecting input.");
        }
    }

    /**
     * work executor of asking questions.
     *
     * @param claim num of question
     */
    public void work(int claim) {
        if (claim == 1) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Description of Task?");
            tracker.addItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }
        if (claim == 2) {
            String nameOfClaim = input.ask("Enter: Name of Task which you want to update?");
            if (tracker.findByName(nameOfClaim) != null) {
                String askNewTask = input.ask("Enter: New name of Task?");
                String askNewDesk = input.ask("Enter: New Description of Task?");
                tracker.redactItem(nameOfClaim, new Item(askNewTask, askNewDesk, date.getTime()));
            } else {
                System.out.println("There is no such Task");
            }
        }
        if (claim == 3) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            if (tracker.findByName(nameOfClaim) != null) {
                tracker.deleteItem(tracker.findByName(nameOfClaim)[0].getId());
            } else {
                System.out.println("There is no such Task");
            }
        }
        if (claim == 4) {
            for (Item x : tracker.getListOfItems()) {
                System.out.println(x.getName() + " / " + x.getDesc() + " / " + format1.format(x.getLong()) + " / " + x.getId());
            }
        }
        if (claim == 5) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            if (tracker.findByName(nameOfClaim) != null) {
                Item[] x = tracker.findByName(nameOfClaim);
                System.out.println(x[0].getName() + " / " + x[0].getDesc() + " / " + format1.format(x[0].getLong()) + " / " + x[0].getId());
            } else {
                System.out.println("There is no such Task");
            }
        }
        if (claim == 6) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            if (tracker.findByName(nameOfClaim) != null) {
                String com = input.ask("Enter: The comment?");
                tracker.addComment(nameOfClaim, com);
                Item x = tracker.findByName(nameOfClaim)[0];
                System.out.println(x.getName() + " / " + x.getDesc() + " / " + format1.format(x.getLong()) + " / " + x.getId());
            } else {
                System.out.println("There is no such Task");
            }
        }
        if (claim == 7) {
            isWorking = false;
        }
    }

    /**
     * main start point.
     *
     * @param args start arguments
     */
    public static void main(String[] args) {

        /**
         * Creating new object of Console Interface.
         */
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();

        /**
         * Creating new object of StartUI class with Consol Interface.
         */
        StartUI start = new StartUI(input, tracker);
        while (start.getIsWorking()) {
            start.work(start.init());
        }

    }
}
