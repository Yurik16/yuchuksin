package ru.job4j.chess;

/**
 * Main class.
 *
 * @author Yury Chuksin (chuksin.yury@gmail.com)
 * @since 02.05.2017.
 */
public class Bishop extends AbstractFigure {
    /**
     * Constructor of Bishop.
     *
     * @param name
     * @param position
     */
    public Bishop(String name, Cell position) {
        super(name, position);
    }


    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] resalt = new Cell[7];
        try {
            if(dist.getPositionY() > this.position[1]) {

            }
        }
        catch(ImpossibleMoveException ime) {
            System.out.println(ime.getMessage());
        }
        return new Cell[0];
    }

    @Override
    boolean isCorrectWay(Cell cell) throws ImpossibleMoveException {
        return false;
    }
}
