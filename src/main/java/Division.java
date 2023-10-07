import java.io.InputStream;
import java.io.PrintStream;

public class Division extends Multiplication{

    public Division() {
        super();
    }

    public Division(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    protected Double baseOperation(Double first, Double second) {
        if(second==0)throw new ArithmeticException("Divided by zero");
        return first/second;
    }



    @Override
    public String getDisplayName() {
        return "Division";
    }
}
