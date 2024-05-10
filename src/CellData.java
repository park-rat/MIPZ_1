import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CellData {
    private char type;
    private Set<PositionData.Direction> allowedDirections;

    public CellData(char type) {
        this.type = type;
        if (type == '1' || type == '2') {
            this.allowedDirections = new HashSet<>(Arrays.asList(PositionData.Direction.values()));
        }
    }

    public char getType() {
        return type;
    }

    public Set<PositionData.Direction> getAllowedDirections() {
        return allowedDirections;
    }
}
