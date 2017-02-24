package ru.job4j.tracker.start;

/**
 * Created by User on 23.02.2017.
 */
public class StubInput implements Input {

    private String[] answers;
    private int count = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    public String ask(String question) {
        return this.answers[count++];
    }
}
