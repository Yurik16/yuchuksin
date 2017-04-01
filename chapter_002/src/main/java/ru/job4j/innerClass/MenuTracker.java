package ru.job4j.innerClass;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.models.Item;
import ru.job4j.tracker.start.Input;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Main class.
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

    /**
     * Constructor
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
     * fillActions
     */
    public void fillActions() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new Filter();
        this.actions[5] = new Comments();
    }

    /**
     *
     */
    public void show() {
        for (UserAction x : actions) {
            if (x != null) {
                System.out.println(x.info());
            }
        }
    }

    public void act(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    UserAction[] findBy = new UserAction[3];

    public void fillFilter() {
        findBy[0] = new FilterByName();
        findBy[1] = new FilterByDesc();
        findBy[2] = new FilterById();
    }

    public void showFilter() {
        for (UserAction x : findBy) {
            if (x != null) {
                System.out.println(x.info());
            }
        }
    }

    public void actFind(int key) {
        this.findBy[key - 1].execute(this.input, this.tracker);
    }

    /**
     *
     */
    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
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
     *
     */
    private static class ShowItems implements UserAction {

        /**
         * creating new class SimpleDateFormat.
         */
        private SimpleDateFormat format1 = new SimpleDateFormat("dd.mm.yyyy hh:mm");

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item x : tracker.getListOfItems()) {
                System.out.println(String.format("%s | %s | %s | %s", x.getName(), x.getDesc(), x.getId(), format1.format(x.getLong())));
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "List");
        }
    }

    class EditItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
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

    class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter: name of task to delete.");
            if (tracker.findByName(name) != null) {
                tracker.deleteItem(tracker.findByName(name)[0].getId());
            } else {
                System.out.println("Are you sure?");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Delete");
        }
    }

    class Filter implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            MenuTracker menuFilter = new MenuTracker(input, tracker);
            menuFilter.fillFilter();
            int filter;
            int[] listOfFilter = {1, 2, 3};
            while (true) {
                menuFilter.showFilter();
                System.out.println("4. Exit");
                filter = Integer.valueOf(input.ask("What filter? Choose number :"));
                for (int x : listOfFilter) {
                    if (x == filter) {
                        menuFilter.actFind(filter);
                    }
                }
                if (filter == 4) {
                    if ("y".equals(input.ask("EXIT!?('y')"))) {
                        break;
                    }
                }
                System.out.println("... choose again");
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", key(), "Find");
        }
    }

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
            }
            System.out.println("No such Name.");
        }

        @Override
        public String info() {
            return String.format("%s. %s.", key(), "... by Name");
        }
    }

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

    class Comments implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
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
}
