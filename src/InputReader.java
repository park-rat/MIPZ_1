import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    private static final String PATH = "./testcases/test.txt";

    public static List<CellData[][]> readTestCases() {
        List<CellData[][]> testCases = new ArrayList<>();
        try (
            FileReader fr = new FileReader(PATH);
            BufferedReader br = new BufferedReader(fr)
        ) {
            int testCaseCount;
            try {
                testCaseCount = Integer.parseInt(br.readLine());
            }
            catch (Exception e) {
                throw new RuntimeException("First line is not an integer or file is empty:\n" + e);
            }
            for (int i = 0; i < testCaseCount; i++) {
                CellData[][] board = new CellData[Main.BOARD_WIDTH][Main.BOARD_WIDTH];
                testCases.add(board);
                for (int k = 0; k < Main.BOARD_WIDTH; k++) {
                    String row = br.readLine();
                    if (row == null) {
                        throw new RuntimeException(
                            "File does not contain the row " + (k + 1) + " of testcase " + (i + 1)
                        );
                    }
                    char[] cells = row.toCharArray();
                    if (cells.length != Main.BOARD_WIDTH) {
                        throw new RuntimeException(
                            "Wrong number of values in the row " + (k + 1) + " of testcase " + (i + 1)
                        );
                    }
                    for (int j = 0; j < Main.BOARD_WIDTH; j++) {
                        if (cells[j] != '0' && cells[j] != '1' && cells[j] != '2') {
                            throw new RuntimeException(
                                "Wrong symbol in the row " + (k + 1) + " column " + (j + 1) + " of testcase " + (i + 1)
                            );
                        }
                        board[k][j] = new CellData(cells[j]);
                    }
                }
            }
            return testCases;
        }
        catch (Exception e) {
            throw new RuntimeException("Problem with reading file with testcases:\n" + e);
        }
    }
}
