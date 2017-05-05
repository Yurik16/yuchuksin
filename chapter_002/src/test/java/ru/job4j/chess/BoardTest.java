package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.Exceptions.FigureNotFoundException;
import ru.job4j.chess.Exceptions.ImpossibleMoveException;
import ru.job4j.chess.Exceptions.OccupiedWayException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 03.05.2017.
 */
public class BoardTest {
    @Test
    public void move() throws Exception {
        AbstractFigure[] figures = {
                new Bishop("name", new Cell(3, 1)),
                //new Bishop("second", new Cell(4, 2))
        };

        Board board = new Board(figures);
        try {
            boolean result = board.move(new Cell(3,1), new Cell(5, 1));
            assertThat(result, is(true));
        }
        catch(FigureNotFoundException fnf) {
            System.out.println(fnf.getMessage());
        }
        catch(ImpossibleMoveException ime) {
            System.out.println(ime.getMessage());
        }
        catch(OccupiedWayException owe) {
            System.out.println(owe.getMessage());
        }
    }

}