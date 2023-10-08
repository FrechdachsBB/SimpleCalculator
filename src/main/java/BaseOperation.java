import java.io.InputStream;
import java.io.PrintStream;

public abstract class BaseOperation extends Operation{

    public BaseOperation() {
        super();
    }

    public BaseOperation(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
    }

    @Override
    public Double operate() {
        Double input;
        Double result = 0d;
        boolean firstIteration = true;

        do{
            input = askForDouble("Please insert Number to process or press Enter to finish.");
            result = processInput(result,input,firstIteration);

            /**
             * Long.MaxValue wird nach einem Overflow nicht negativ sondern zu infinity
             * Daher kann der Overflow mit >= geprüft werden.
             * Analog wird der Underflow mittels <= getestet
             */
            if(result >= Long.MAX_VALUE)throw new ArithmeticException("Overflow!");
            if(result <= Long.MIN_VALUE)throw new ArithmeticException("Underflow!");
            firstIteration = false;
        }while (input!=null);
        return result;
    }

    protected double processInput(Double previous ,Double input, boolean firstIteration){
        Double result = previous;
        if(input!=null) {
            if(firstIteration)result=input;
            else {
                result = baseOperation(previous,input);
                display.printf("\t=> %.5f\n",result);

            }
        }
        return result;
    }

    abstract protected Double baseOperation(Double first, Double second);
}
