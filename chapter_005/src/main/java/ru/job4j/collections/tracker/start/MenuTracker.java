package ru.job4j.collections.tracker.start;

import ru.job4j.collections.tracker.Tracker;
import ru.job4j.collections.tracker.models.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    /**
     * pointsOfMenu names of menus.
     */
    private String[] pointsOfMenu = {"Add", "Edit", "Delete", "List", "Filter", "Comment", "Exit"};

    /**
     * pointsOfFilter names of filter menus.
     */

    private String[] pointsOfFilter = {"... by Name", "... by Description", "... by ID", "Exit from Filter"};

    /**
     * menuRange range of menu.
     */
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
     *
     * @return actions list of actions
     */
    public UserAction[] fillActions() {
        this.actions[position++] = this.new AddItemFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new EditItemFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new DeleteItemFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new MenuTracker.ShowItemsFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new FilterFromAbstract(pointsOfMenu[position - 1], position);
        this.actions[position++] = new Comments(pointsOfMenu[position - 1], position);
        this.actions[position++] = new Exit(pointsOfMenu[position - 1], position);
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


    /**
     * fillRange filling range with keys.
     *
     * @param list list of possible menus
     * @return menuRange
     */
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
     * point counter for the filter menu.
     */
    private int point = 0;

    /**
     * Create list of 'Filter by ...'.
     *
     * @return findBy list of filter menu
     */
    private UserAction[] fillFilter() {
        findBy[point++] = new FilterByName(pointsOfFilter[point - 1], point);
        findBy[point++] = new FilterByDesc(pointsOfFilter[point - 1], point);
        findBy[point++] = new FilterById(pointsOfFilter[point - 1], point);
        findBy[point++] = new ExitFromFilter(pointsOfFilter[point - 1], point);

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

    /**
     * Inner class AddItemFromAbstract.
     */
    private class AddItemFromAbstract extends AbstractAction {

        /**
         * constructor.
         *
         * @param name  name of action
         * @param count number of action
         */
        AddItemFromAbstract(String name, int count) {
            super(name, count);
        }

        /**
         * execute adding task.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("adding:");
            String nameOfClaim = input.ask("Enter: Name of Task?");
            String descOfClaim = input.ask("Enter: Description of Task?");
            tracker.addItem(new Item(nameOfClaim, descOfClaim, date.getTime()));
        }
    }

    /**
     * Inner class ShowItemsFromAbstract.
     */

    class EditItemFromAbstract extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        EditItemFromAbstract(String name, int num) {
            super(name, num);
        }

        /**
         * edit task.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
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
    }

    /**
     * Inner class DeleteItemFromAbstract.
     */
    class DeleteItemFromAbstract extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        DeleteItemFromAbstract(String name, int num) {
            super(name, num);
        }

        /**
         * Delete task.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("deleting:");
            String name = input.ask("Enter: name of task to delete.");
            try {
                if (tracker.findByName(name) != null) {
                    tracker.deleteItem(tracker.findByName(name).get(0).getId());
                } else {
                    System.out.println("Are you sure?");
                }
            } catch (NullPointerException npe) {
                System.out.println("Please, enter validate data.");
            }
        }
    }

    /**
     * Inner class EditItemFromAbstract.
     */
    private static class ShowItemsFromAbstract extends AbstractAction {

        /**
         * creating new class SimpleDateFormat.
         */
        private SimpleDateFormat format1 = new SimpleDateFormat("dd.mm.yyyy hh:mm");

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        ShowItemsFromAbstract(String name, int num) {
            super(name, num);
        }

        /**
         * Show list of all items.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("list of Items:");
            for (Item x : tracker.getListOfItems()) {
                System.out.println(String.format("%s | %s | %s | %s", x.getName(), x.getDesc(), x.getId(), format1.format(x.getLong())));
            }
        }
    }

    /**
     * Inner class FilterFromAbstract.
     */
    class FilterFromAbstract extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        FilterFromAbstract(String name, int num) {
            super(name, num);
        }

        /**
         * Show list of items by filter.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
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
    }

    /**
     * Inner class FilterByName.
     */
    class FilterByName extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        FilterByName(String name, int num) {
            super(name, num);
        }

        /**
         * searching filter by name.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Name to find?");
            for (Item x : tracker.getListOfItems()) {
                if (tracker.findByName(name) != null && x.getName().equals(name)) {
                    List<Item> item = tracker.findByName(name);
                    System.out.println(String.format("%s | %s | %s | %s", item.get(0).getName(), item.get(0).getDesc(), item.get(0).getId(), format1.format(item.get(0).getLong())));
                    break;
                }
                System.out.println("No such Name.");
            }
        }
    }

    /**
     * Inner class FilterByDesc.
     */
    class FilterByDesc extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        FilterByDesc(String name, int num) {
            super(name, num);
        }

        /**
         * searching filter by description.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Description to find?");
            for (Item item : tracker.getListOfItems()) {
                if (tracker.findByDesc(name) != null && item.getDesc().equals(name)) {
                    List<Item> x = tracker.findByDesc(name);
                    System.out.println(String.format("%s | %s | %s | %s", x.get(0).getName(), x.get(0).getDesc(), x.get(0).getId(), format1.format(x.get(0).getLong())));
                    break;
                }
            }
            System.out.println("No such Description.");
        }
    }

    /**
     * Inner class FilterById.
     */
    class FilterById extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        FilterById(String name, int num) {
            super(name, num);
        }

        /**
         * searching filter by ID.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
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
    }

    /**
     * Inner class Comments.
     */
    class Comments extends AbstractAction {

        /**
         * constructor.
         *
         * @param name name of action
         * @param num  number of action
         */
        Comments(String name, int num) {
            super(name, num);
        }

        /**
         * Adding comment to task.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
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
    }

    /**
     * Inner class Exit.
     */
    class Exit extends AbstractAction {

        /**
         * constructor.
         *
         * @param nameOfAction name of action
         * @param numOfKey     number of action
         */
        Exit(String nameOfAction, int numOfKey) {
            super(nameOfAction, numOfKey);
        }

        /**
         * Exit from program.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }

    /**
     * Inner class ExitFromFilter.
     */
    class ExitFromFilter extends AbstractAction {

        /**
         * constructor.
         *
         * @param nameOfAction name of action
         * @param numOfKey     number of action
         */
        ExitFromFilter(String nameOfAction, int numOfKey) {
            super(nameOfAction, numOfKey);
        }

        /**
         * Exit from filter.
         *
         * @param input   enter data
         * @param tracker existing tasks
         */
        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }

}


