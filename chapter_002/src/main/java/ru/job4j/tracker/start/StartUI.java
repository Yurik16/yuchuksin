package ru.job4j.tracker.start;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * StartUI class.
 *
 * @author Yury Chuksin
 * @version 1.1
 * @since 20.02.2017.
 */
public class StartUI {

    static boolean isWorking = true;
    private final Input input;
    Date date = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("dd.mm.yyyy hh:mm");
    Scanner scanner = new Scanner(System.in);
    Tracker tracker = new Tracker();
    private final String[] menue = {
            "1.Добавление новой заявки",
            "2.Редактирование заявки.",
            "3.Удаление заявки.",
            "4.Отображение списка всех заявок.",
            "5.Отображение заявок с условием фильтра.",
            "6.Добавить к заявке комментарий.",
            "7.Выход из программы."
    };
    public String getMenueName(int point) {
        return this.menue[point];
    }
    static int claimNum = 0;

    StartUI(Input input) {
        this.input = input;
    }

    public void init() {
        boolean isCorrectInput = true;
        while (isCorrectInput) {
            for (String x : this.menue) {
                System.out.println(x);
            }
            String name = input.ask("Enter the number 1 ... 7 : ");
            int numOfClaim = Integer.parseInt(name);
            int[] needTo = {0, 1, 2, 3, 4, 5, 6};
            for (int x : needTo) {
                if (x == numOfClaim - 1) {
                    claimNum = numOfClaim;
                    System.out.println(getMenueName(numOfClaim - 1));
                    isCorrectInput = false;
                }
                if (numOfClaim == 7) {
                    isCorrectInput = false;

                }
            }
            if(isCorrectInput) {
                System.out.println("Don`t expecting input.");
            }
        }
    }

    public void work(int claim) {
        if (claim == 1) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Descriptoin of Task?");
            tracker.addItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }
        if (claim == 2) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Descriptoin of Task?");
            tracker.redactItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }
        if (claim == 3) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            tracker.deleteItem(tracker.findByName(nameOfClaim).getId());
        }
        if (claim == 4) {
            for (Item x : tracker.getListOfItems()) {
                System.out.println(x.getName() + " / " + x.getDesc() + " / " + format1.format(x.getLong()) + " / " + x.getId());
            }
        }
        if (claim == 5) {
            String nameOfClaim = input.ask("Enter: Name of Task?");
            Item x = tracker.findByName(nameOfClaim);
                System.out.println(x.getName() + " / " + x.getDesc() + " / " + format1.format(x.getLong()) + " / " + x.getId());
        }
        if (claim == 6) {
            String id = input.ask("Enter: The ID?");
            Item x = tracker.findById(id);
            System.out.println(x.getName() + " / " + x.getDesc() + " / " + format1.format(x.getLong()) + " / " + x.getId());
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
        Input input = new ConsoleInput();
        StartUI start = new StartUI(input);
        while (isWorking) {
           start.init();
           start.work(claimNum);
        }

    }
}
