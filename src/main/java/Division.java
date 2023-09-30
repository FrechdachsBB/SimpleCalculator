public class Division extends Multiplication{

    @Override
    protected Double baseOperation(Double first, Double second) {
        return first/second;
    }

    @Override
    public String getDisplayName() {
        return "Division";
    }
}
