import java.io.InputStream;
import java.io.PrintStream;

public class Multiplication extends BaseOperation{

    public Multiplication() {
        super();
    }

    public Multiplication(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    protected Double baseOperation(Double first, Double second) {
        return first * second;
    }

    @Override
    public String getDisplayName() {
        return "Multiplication";
    }
}
