package ru.job4j.collections.tracker.start;

import ru.job4j.collections.tracker.Tracker;
import ru.job4j.collections.tracker.models.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    private List<UserAction> actions = new ArrayList<>();

    /**
     * pointsOfMenu names of menus.
     */
    private List<String> pointsOfMenu = Arrays.asList("Add", "Edit", "Delete", "List", "Filter", "Comment", "Exit");

    /**
     * pointsOfFilter names of filter menus.
     */

    private List<String> pointsOfFilter = Arrays.asList("... by Name", "... by Description", "... by ID", "Exit from Filter");

    /**
     * menuRange range of menu.
     */
    private List<Integer> menuRange = new ArrayList<>();

    /**
     * Constructor of MenuTracker.
     *
     * @param input   enter data
     * @param tracker tasks
     */
    MenuTracker(Input input, Tracker tracker) {
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
    List<UserAction> fillActions() {
        this.actions.set(position++, this.new AddItemFromAbstract(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new EditItemFromAbstract(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new DeleteItemFromAbstract(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new ShowItemsFromAbstract(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new FilterFromAbstract(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new Comments(pointsOfMenu.get(position - 1), position));
        this.actions.set(position++, new Exit(pointsOfMenu.get(position - 1), position));
        return this.actions;
    }


    /**
     * fillRange filling range with keys.
     *
     * @param list list of possible menus
     * @return menuRange
     */
    public List<Integer> fillRange(List<UserAction> list) {
        for (int i = 0; i < list.size(); i++) {
            this.menuRange.set(i, list.get(i).key());
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
    void act(int key) {
        this.actions.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * findBy list of filters.
     */
    private List<UserAction> findBy = new ArrayList<>();

    /**
     * point counter for the filter menu.
     */
    private int point = 0;

    /**
     * Create list of 'Filter by ...'.
     *
     * @return findBy list of filter menu
     */
    private List<UserAction> fillFilter() {
        findBy.set(point++, new FilterByName(pointsOfFilter.get(point - 1), point));
        findBy.set(point++, new FilterByDesc(pointsOfFilter.get(point - 1), point));
        findBy.set(point++, new FilterById(pointsOfFilter.get(point - 1), point));
        findBy.set(point++, new ExitFromFilter(pointsOfFilter.get(point - 1), point));

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
        this.findBy.get(key - 1).execute(this.input, this.tracker);
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
            List<UserAction> listOfFilter = menuFilter.fillFilter();
            List<Integer> rangeOfFilter = menuFilter.fillRange(listOfFilter);
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


