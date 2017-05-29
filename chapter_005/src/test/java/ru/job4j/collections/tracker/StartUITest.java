package ru.job4j.collections.tracker;

import org.junit.Test;
import ru.job4j.collections.tracker.start.Input;
import ru.job4j.collections.tracker.start.StartUI;
import ru.job4j.collections.tracker.start.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StartTest.
 *
 * @author Yury Cuksin
 * @since 12.03.2017
 */

public class StartUITest {

    /**
     * whenAddNewItemThenItComesToTracker compare Name and Desc of entering by User with expected data.
     */
    @Test
    public void whenAddNewItemThenItComesToTracker() {
        //StartUI.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "7"});
        Tracker tracker = new Tracker();
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.getListOfItems()[0].getName(), is("1t"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("1d"));
    }

    /**
     * whenEditItemThenItemChanges compare Name before edit Item and after.
     */
    @Test
    public void whenEditItemThenItemChanges() {
        //StartUI.isWorking = true;
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "1t", "1d", "2", "1", "1tt", "1dd", "7"});
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.getListOfItems()[0].getName(), is("1tt"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("1dd"));
    }

    /**
     * whenDeleteItemThenItemDeleteFromTracker compare List of Items after delete with known result.
     */
    @Test
    public void whenDeleteItemThenItemDeleteFromTracker() {
        //StartUI.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "3", "1t", "7"});
        Tracker tracker = new Tracker();
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.getListOfItems()[0].getName(), is("2t"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("2d"));
    }

    /**
     * whenDoListThenGetListOfItems compare List of Items with known result.
     */
    @Test
    public void whenDoListThenGetListOfItems() {
        //StartUI.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "7"});
        Tracker tracker = new Tracker();
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.getListOfItems()[0].getName(), is("1t"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("1d"));
        assertThat(tracker.getListOfItems()[1].getName(), is("2t"));
        assertThat(tracker.getListOfItems()[1].getDesc(), is("2d"));
    }

    /**
     * whenDoFilterThenGetListWithFilterByName compare Items after filter with known result.
     */
    @Test
    public void whenDoFilterThenGetListWithFilterByName() {
        //StartUI.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "5", "2t", "7"});
        Tracker tracker = new Tracker();
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.findByName("2t")[0].getName(), is("2t"));
        assertThat(tracker.findByName("2t")[0].getDesc(), is("2d"));
    }

    /**
     * whenAddCommentThenAddingCommentByNameOfTask compare comments of Item after mane comments with known result.
     */
    @Test
    public void whenAddCommentThenAddingCommentByNameOfTask() {
        //StartUI.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "6", "1t", "Comment", "7"});
        Tracker tracker = new Tracker();
        StartUI startTest = new StartUI(input, tracker);
        startTest.setIsWorking(true);
        while (startTest.getIsWorking()) {
            startTest.work(startTest.init());
        }
        assertThat(tracker.getListOfItems()[0].getComment(), is("Comment"));
    }
}

