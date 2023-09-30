public class SqareRoot extends Operation {

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
