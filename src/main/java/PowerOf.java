public class PowerOf extends Operation{
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
}
