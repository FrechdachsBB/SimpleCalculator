public class Multiplication extends BaseOperation{

    private double result = 0;

    @Override
    public Double operate() {
        Double input;
        boolean firstIteration = true;
        do{
            input = askForDouble("Please insert Number to process or press Enter to finish.");
            processInput(input,firstIteration);
            if(result == Long.MAX_VALUE || result == Long.MIN_VALUE)return result;
            firstIteration = false;
        }while (input!=null);
        return result;
    }

    private void processInput(Double input, boolean firstIteration){
        if(input!=null) {
            if(!firstIteration) {
                result = baseOperation(result, input);
                display.printf("\t=> %.5f\n", result);
            }else result = input;
        }
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
