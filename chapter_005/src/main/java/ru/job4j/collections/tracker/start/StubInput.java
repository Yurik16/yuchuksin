package ru.job4j.collections.tracker.start;

import java.util.List;

/**
 * Created by User on 31.05.2017.
 */
public class StubInput implements Input {
    /**
     * new List of answers.
     */
    private List<String> answers;

    /**
     * counter for num of answers.
     */
    private int count = 0;

    /**
     * StubInput constructor.
     * @param answers List of strings
     */
    public StubInput(List<String> answers) {
        this.answers = answers;
    }

    /**
     * ask simulates user`s choice.
     * @param question depends of implementation
     * @return answers
     */
    public String ask(String question) {
        return this.answers.get(count++);
    }

    @Override
    public int ask(String question, List<Integer> range)  {
        return Integer.parseInt(this.answers.get(count++));
    }
}
