import java.io.InputStream;
import java.io.PrintStream;

public class Subtraction extends BaseOperation{

    public Subtraction() {
        super();
    }

    public Subtraction(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    protected Double baseOperation(Double first, Double second) {
        return first-second;
    }

    @Override
    public String getDisplayName() {
        return "Subtraction";
    }
}
