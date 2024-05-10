import java.util.List;

public class Main {
    public static final int BOARD_WIDTH = 19;
    public static final int SEQUENCE_LENGTH = 5;

    public static void main(String[] args) {
        List<CellData[][]> testCases;
        try {
            testCases = InputReader.readTestCases();
        }
        catch (Exception e) {
            System.out.println(e);
            return;
        }
        for (int i = 0; i < testCases.size(); i++) {
            System.out.println("TC " + (i + 1));
            PositionData pd = new WinnerFinder(testCases.get(i)).findWinner();
            if (pd == null) {
                System.out.println("0\n");
            }
            else {
                System.out.println(
                    pd.getType() + "\n" + (pd.getLeftmostPointRow() + 1) + " " + (pd.getLeftmostPointCol() + 1) + "\n"
                );
            }
        }
    }
}