package ru.job4j.innerClass;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.Input;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 20.03.2017.
 */
public class MenuTracker {
    /**
     * input field that filling by user or user-simulator.
     */
    private Input input;
    /**
     * tracker create new Tracker class.
     */
    private Tracker tracker;

    /**
     * actions create new UserAction field.
     */
    private UserAction[] actions = new UserAction[7];

    public String[] pointsOfMenu = {"Add", "Edit", "Delete", "List", "Filter", "Comment", "Exit"};

    private int[] menuRange = new int[7];

    /**
     * Constructor of MenuTracker.
     *
     * @param input   enter data
     * @param tracker tasks
     */
    public MenuTracker(Input input, Tracker tracker) {
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
     * position counter of number UserActions in MenuTracker.
     */
    private int position = 0;

    /**
     * fillActions filling menu with possible actions.
     */
    public UserAction[] fillActions() {
        this.actions[position++] = this.new AddItemFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new EditItem();
        this.actions[position++] = new DeleteItem();
        this.actions[position++] = new MenuTracker.ShowItems();
        this.actions[position++] = new Filter();
        this.actions[position++] = new Comments();
        this.actions[position++] = new Exit();
        return this.actions;
    }

    /**
     * addActions filling menu with pointing actions.
     *
     * @param action pointing action
     */
    public void addActions(UserAction action) {
        this.actions[position++] = action;
    }


    public int[] fillRange(UserAction[] list) {
        for (int i = 0; i < list.length; i++) {
            this.menuRange[i] = list[i].key();
        }
        return this.menuRange;
    }

    /**
     * Showing all possible commands to user.
     */
    public void show() {
        for (UserAction x : actions) {
            if (x != null) {
                System.out.println(x.info());
            }
        }
    }

    /**
     * Transfer to interface key to execute.
     *
     * @param key number of action to execute
     */
    public void act(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    /**
     * findBy list of filters.
     */
    private UserAction[] findBy = new UserAction[4];

    /**
     * Create list of 'Filter by ...'.
     */
    private UserAction[] fillFilter() {
        findBy[0] = new FilterByName();
        findBy[1] = new FilterByDesc();
        findBy[2] = new FilterById();
        findBy[3] = new ExitFromFilter();

        return this.findBy;
    }

    /**
     * Showing all possible filters to user.
     */
    private void showFilter() {
        for (UserAction x : findBy) {
            if (x != null) {
                System.out.println(x.info());
            }
        }
    }

    /**
     * actFind transfer to interface key to execute.
     *
     * @param key number of filter to execute
     */
    private void actFind(int key) {
        this.findBy[key - 1].execute(this.input, this.tracker);
    }

    private class AddItemFromAbstract extends AbstractAction {

        public AddItemFromAbstract(String name, int count) {
            super(name, count);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("adding:");
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Description of Task?");
            tracker.addItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }
    }

    /**
     * Inner class AddItem.
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("adding:");
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Description of Task?");
            tracker.addItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add");
        }
    }

    /**
     * Inner class ShowItems.
     */
    private static class ShowItems implements UserAction {

        /**
         * creating new class SimpleDateFormat.
         */
        private SimpleDateFormat format1 = new SimpleDateFormat("dd.mm.yyyy hh:mm");

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("list of Items:");
            for (Item x : tracker.getListOfItems()) {
                System.out.println(String.format("%s | %s | %s | %s", x.getName(), x.getDesc(), x.getId(), format1.format(x.getLong())));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "List");
        }
    }

    /**
     * Inner class EditItem.
     */
    class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("editing Item:");
            String id = input.ask("Enter: ID of Task to update?");
            for (Item x : tracker.getListOfItems()) {
                if (tracker.findById(id) != null && x.getId().equals(id)) {
                    String newTask = input.ask("Enter: New Name of Task?");
                    String newDesc = input.ask("Enter: New Description of Task?");
                    tracker.redactItem(id, new Item(newTask, newDesc, x.newTime()));
                    break;
                } else {
                    System.out.println("Are you sure?");
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Edit");
        }
    }

    /**
     * Inner class DeleteItem.
     */
    class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("deleting:");
            String name = input.ask("Enter: name of task to delete.");
            try {
                if (tracker.findByName(name) != null) {
                    tracker.deleteItem(tracker.findByName(name)[0].getId());
                } else {
                    System.out.println("Are you sure?");
                }
            } catch (NullPointerException npe) {
                System.out.println("Please, enter validate data.");
            }

        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Delete");
        }
    }

    /**
     * Inner class Filter.
     */
    class Filter implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker menuFilter = new MenuTracker(input, tracker);
            UserAction[] listOfFilter = menuFilter.fillFilter();
            int[] rangeOfFilter = menuFilter.fillRange(listOfFilter);
            int filter;
            while (true) {
                menuFilter.showFilter();
                filter = input.ask("What filter? Choose number :", rangeOfFilter);
                menuFilter.actFind(filter);
                if (filter == 4) {
                    if ("y".equals(input.ask("EXIT!?('y')"))) {
                        break;
                    }
                }
                System.out.println("... choose again?");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Find");
        }
    }

    /**
     * Inner class FilterByName.
     */
    class FilterByName implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Name to find?");
            for (Item x : tracker.getListOfItems()) {
                if (tracker.findByName(name) != null && x.getName().equals(name)) {
                    Item[] item = tracker.findByName(name);
                    System.out.println(String.format("%s | %s | %s | %s", item[0].getName(), item[0].getDesc(), item[0].getId(), format1.format(item[0].getLong())));
                    break;
                }
                System.out.println("No such Name.");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s.", key(), "... by Name");
        }
    }

    /**
     * Inner class FilterByDesc.
     */
    class FilterByDesc implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Description to find?");
            for (Item item : tracker.getListOfItems()) {
                if (tracker.findByDesc(name) != null && item.getDesc().equals(name)) {
                    Item[] x = tracker.findByDesc(name);
                    System.out.println(String.format("%s | %s | %s | %s", x[0].getName(), x[0].getDesc(), x[0].getId(), format1.format(x[0].getLong())));
                    break;
                }
            }
            System.out.println("No such Description.");
        }

        @Override
        public String info() {
            return String.format("%s. %s.", key(), "... by Description");
        }
    }

    /**
     * Inner class FilterById.
     */
    class FilterById implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("ID to find?");
            for (Item item : tracker.getListOfItems()) {
                if (tracker.findById(name) != null && item.getId().equals(name)) {
                    Item x = tracker.findById(name);
                    System.out.println(String.format("%s | %s | %s | %s", x.getName(), x.getDesc(), x.getId(), format1.format(x.getLong())));
                    break;
                }
            }
            System.out.println("No such ID.");
        }

        @Override
        public String info() {
            return String.format("%s. %s.", key(), "... by ID");
        }
    }

    /**
     * Inner class Comments.
     */
    class Comments implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("commenting:");
            String name = input.ask("ID of Task to Comment?");
            for (Item item : tracker.getListOfItems()) {
                if (tracker.findById(name) != null && tracker.findById(name).getId().equals(item.getId())) {
                    item.setComment(input.ask("Add comment: ..."));
                    break;
                }
                System.out.println("Wrong ID");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Comment");
        }
    }

    class Exit implements UserAction {

        @Override
        public int key() {
            return 7;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Exit");
        }
    }

    class ExitFromFilter implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Exit");
        }
    }

}


