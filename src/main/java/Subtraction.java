public class Subtraction extends BaseOperation{
    @Override
    protected Double baseOperation(Double first, Double second) {
        return first-second;
    }

    @Override
    public String getDisplayName() {
        return "Subtraction";
    }
}
