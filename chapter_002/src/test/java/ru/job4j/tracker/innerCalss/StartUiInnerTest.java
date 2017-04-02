package ru.job4j.tracker.innerCalss;

import org.junit.Test;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.start.Input;
import ru.job4j.innerClass.StartUIin;
import ru.job4j.tracker.start.StubInput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.04.2017.
 */
public class StartUiInnerTest {
    /**
     * whenAddNewItemThenItComesToTracker compare Name and Desc of entering by User with expected data.
     */
    @Test
    public void whenAddNewItemThenItComesToTracker() {
        //StartUIin.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "7", "y"});
        Tracker tracker = new Tracker();
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
        assertThat(tracker.getListOfItems()[0].getName(), is("1t"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("1d"));
    }

    /**
     * whenEditItemThenItemChanges compare Name before edit Item and after.
     */
    @Test
    public void whenEditItemThenItemChanges() {
        //StartUIin.isWorking = true;
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"1", "1t", "1d", "2", "1", "1tt", "1dd", "7", "y"});
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
        assertThat(tracker.getListOfItems()[0].getName(), is("1tt"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("1dd"));
    }

    /**
     * whenDeleteItemThenItemDeleteFromTracker compare List of Items after delete with known result.
     */
    @Test
    public void whenDeleteItemThenItemDeleteFromTracker() {
        //StartUIin.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "3", "1t", "7", "y"});
        Tracker tracker = new Tracker();
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
        assertThat(tracker.getListOfItems()[0].getName(), is("2t"));
        assertThat(tracker.getListOfItems()[0].getDesc(), is("2d"));
    }

    /**
     * whenDoListThenGetListOfItems compare List of Items with known result.
     */
    @Test
    public void whenDoListThenGetListOfItems() {
        //StartUIin.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "7", "y"});
        Tracker tracker = new Tracker();
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
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
        //StartUIin.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "1", "2t", "2d", "5", "1", "2t", "4", "y", "7", "y"});
        Tracker tracker = new Tracker();
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
        assertThat(tracker.findByName("2t")[0].getName(), is("2t"));
        assertThat(tracker.findByName("2t")[0].getDesc(), is("2d"));
    }

    /**
     * whenAddCommentThenAddingCommentByNameOfTask compare comments of Item after mane comments with known result.
     */
    @Test
    public void whenAddCommentThenAddingCommentByNameOfTask() {
        //StartUIin.isWorking = true;
        Input input = new StubInput(new String[]{"1", "1t", "1d", "6", "1", "Comment", "7", "y"});
        Tracker tracker = new Tracker();
        StartUIin startTest = new StartUIin(input, tracker);
        startTest.init();
        assertThat(tracker.getListOfItems()[0].getComment(), is("Comment"));
    }
}



