package ru.job4j.innerClass;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 06.04.2017.
 */
abstract class AbstractAction implements UserAction {

    private String nameOfAction;

    private int numOfKey;

    public AbstractAction(String nameOfAction, int numOfKey) {
        this.nameOfAction = nameOfAction;
        this.numOfKey = numOfKey;
    }

    @Override
    public int key() {
        return this.numOfKey;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.numOfKey, this.nameOfAction);
        }
    }






