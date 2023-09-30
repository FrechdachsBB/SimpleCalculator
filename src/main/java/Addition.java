import java.io.InputStream;
import java.io.PrintStream;

public class Addition extends BaseOperation{

    public Addition() {
        super();
    }

    public Addition(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    protected Double baseOperation(Double first, Double second){
        return first+second;
    }

    @Override
    public String getDisplayName() {
        return "Addition";
    }
}
