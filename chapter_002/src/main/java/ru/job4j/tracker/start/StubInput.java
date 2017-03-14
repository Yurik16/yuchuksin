package ru.job4j.tracker.start;

/**
 * Created by User on 23.02.2017.
 */
public class StubInput implements Input {
    /**
     * new List of answers.
     */
    private String[] answers;

    /**
     * counter for num of answers.
     */
    private int count = 0;

    /**
     * StubInput constructor.
     * @param answers List of strings
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    /**
     * ask simulates user`s choice.
     * @param question depends of implementation
     * @return answers
     */
    public String ask(String question) {
        return this.answers[count++];
    }
}
