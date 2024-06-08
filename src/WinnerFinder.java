import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
    private final CellData[][] board;

    public WinnerFinder(CellData[][] board) {
        this.board = board;
    }

    private void checkNext(PositionData positionData) {
        PositionData.Direction direction = positionData.getDirection();
        board[positionData.getRow()][positionData.getCol()].getAllowedDirections().remove(direction);
        int nextRow = direction == PositionData.Direction.RIGHT ? positionData.getRow() : positionData.getRow() + 1;
        int nextCol = positionData.getCol(); // default for DOWN
        if (direction == PositionData.Direction.RIGHT || direction == PositionData.Direction.DOWN_RIGHT) nextCol ++;
        else if (direction == PositionData.Direction.DOWN_LEFT) nextCol --;
        if (nextRow < 0 || nextRow >= Main.BOARD_WIDTH || nextCol < 0 || nextCol >= Main.BOARD_WIDTH ||
            board[nextRow][nextCol].getType() != positionData.getType()) return;
        positionData.incrementCount();
        positionData.setRow(nextRow);
        positionData.setCol(nextCol);
        if (direction == PositionData.Direction.DOWN_LEFT) positionData.updateLeftmostPoint();
        checkNext(positionData);
    }

    public PositionData findWinner() {
        for (int row = 0; row < Main.BOARD_WIDTH; row++) {
            for (int col = 0; col < Main.BOARD_WIDTH; col++) {
                char type = board[row][col].getType();
                if (type != '1' && type != '2') continue;
                List<PositionData.Direction> directions = new ArrayList<>(board[row][col].getAllowedDirections());
                for (PositionData.Direction direction : directions) {
                    PositionData pd = new PositionData(row, col, type, direction);
                    checkNext(pd);
                    if (pd.getCount() == Main.SEQUENCE_LENGTH) return pd;
                }
            }
        }
        return null;
    }
}
