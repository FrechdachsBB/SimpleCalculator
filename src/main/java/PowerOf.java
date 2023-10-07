import java.io.InputStream;
import java.io.PrintStream;

public class PowerOf extends Operation{

    public PowerOf() {
        super();
    }

    public PowerOf(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    public Double operate() {
        Double base = askForDouble("Please insert base:", true);
        Double power = askForDouble("Please insert power:", true);
        return Math.pow(base,power);
    }

    @Override
    public String getDisplayName() {
        return "X^n";
    }

    @Override
    void reset() {

    }
}
