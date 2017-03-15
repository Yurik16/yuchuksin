package ru.job4j.task3_2.paint;

/**
 * Created by User on 15.03.2017.
 */
public interface Strategy {

    /**
     * paint pseudo-gaphic.
     *
     * @param size size of element
     * @return pseudo-graphic
     */
    String draw(int size);
}
