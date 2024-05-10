public class PositionData {
    public enum Direction {
        RIGHT,
        DOWN_RIGHT,
        DOWN,
        DOWN_LEFT
    }

    private int row;
    private int col;
    private int count;
    private char type;
    private int leftmostPointRow;
    private int leftmostPointCol;
    private Direction direction;

    public PositionData(int row, int col, char type, Direction direction) {
        this.row = row;
        this.col = col;
        this.count = 1;
        this.type = type;
        this.leftmostPointRow = row;
        this.leftmostPointCol = col;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        this.count ++;
    }

    public char getType() {
        return type;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLeftmostPointRow() {
        return leftmostPointRow;
    }

    public int getLeftmostPointCol() {
        return leftmostPointCol;
    }

    public void updateLeftmostPoint() {
        this.leftmostPointRow = this.row;
        this.leftmostPointCol = this.col;
    }
}
