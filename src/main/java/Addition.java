public class Addition extends BaseOperation{
    protected Double baseOperation(Double first, Double second){
        return first+second;
    }

    @Override
    public String getDisplayName() {
        return "Addition";
    }
}
