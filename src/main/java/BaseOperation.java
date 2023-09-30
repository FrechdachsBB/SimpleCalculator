public abstract class BaseOperation extends Operation{
    double result = 0;
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
            result = baseOperation(result, input);
            if(!firstIteration)display.printf("\t=> %.5f\n",result);
        }
    }

    abstract protected Double baseOperation(Double first, Double second);

}
