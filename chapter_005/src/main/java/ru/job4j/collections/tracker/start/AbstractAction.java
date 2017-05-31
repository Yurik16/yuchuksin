package ru.job4j.collections.tracker.start;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 31.05.2017.
 */
abstract class AbstractAction implements UserAction {

    /**
     * nameOfAction names of points in menu.
     */
    private String nameOfAction;

    /**
     * numOfKey menu numbering.
     */
    private int numOfKey;

    /**
     * AbstractAction abstract method.
     *
     * @param nameOfAction name
     * @param numOfKey number
     */
    AbstractAction(String nameOfAction, int numOfKey) {
        this.nameOfAction = nameOfAction;
        this.numOfKey = numOfKey;
    }

    /**
     * key number of menu point.
     *
     * @return number
     */
    @Override
    public int key() {
        return this.numOfKey;
    }

    /**
     * info connecting key() with names of menus.
     *
     * @return String of menu
     */
    @Override
    public String info() {
        return String.format("%s. %s", this.numOfKey, this.nameOfAction);
    }
}
