import java.io.InputStream;
import java.io.PrintStream;

public class SqareRoot extends Operation {

    public SqareRoot() {
        super();
    }

    public SqareRoot(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    private final TypeConverter<String, Double> stringToPositiveDoubleConverter = input -> {
        Double d = Double.parseDouble(input);
        if (d < 0) throw new NumberFormatException("Number must be positive");
        return d;
    };

    @Override
    public Double operate() {
        Double input = ask("Please insert any positive Number:", true, stringToPositiveDoubleConverter);
        return Math.sqrt(input);
    }

    @Override
    public String getDisplayName() {
        return "Square Root";
    }


}
