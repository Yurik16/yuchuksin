package ru.job4j.task3_2.paint;

/**
 * Created by User on 15.03.2017.
 */
public class StartDraw {

    /**
     * main class.
     * @param args param
     */
    public static void main(String[] args) {

        /**
         * context object of Context class.
         */
        Context context = new Context(new DrawSquare());
        System.out.println(context.init(4));
        context = new Context(new DrawTriangle());
        System.out.println(context.init(4));
    }
}
