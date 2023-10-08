import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class SimpleTextBasedCalculator extends Operation {

    private ArrayList<Operation> operations = new ArrayList<>();

    public SimpleTextBasedCalculator() {
        super();
        addOperations();
    }

    public SimpleTextBasedCalculator(PrintStream display, InputStream inputStream) {
        super(display, inputStream);
        addOperations();
    }

    private void addOperations(){
        operations.add(new Addition(display, inputStream));
        operations.add(new Subtraction(display, inputStream));
        operations.add(new Multiplication(display, inputStream));
        operations.add(new Division(display, inputStream));
        operations.add(new PowerOf(display, inputStream));
        operations.add(new SqareRoot(display, inputStream));

        operations.add(new ExitProgramm());
    }

    private void displayOperations() {
        for (int i = 1; i <= operations.size(); i++) {
            display.printf("[%s] %s\n", i, operations.get(i-1).getDisplayName());
        }
    }

    @Override
    public Double operate() {
        while(true) {
            Operation selectedOperation = null;
            while (selectedOperation == null) {
                displayOperations();
                Integer input = askForInt("Please select an Operation by typing its number.", false);
                try {
                    selectedOperation = operations.get(input-1);
                } catch (IndexOutOfBoundsException e) {
                    display.println("This Operation is not listed. Please try again.");
                } catch (NullPointerException npe){
                    display.println("Invalid Input!");
                }
            }
            try {
                display.printf("Result: %.5f\n\n", selectedOperation.operate());
            }catch (ArithmeticException e){
                display.printf("Error: %s\n\n", e.getMessage());
            }
        }
    }

    @Override
    public String getDisplayName() {
        return "Simple TextBasedCalculator";
    }


    public static void main(String[] args) {
        SimpleTextBasedCalculator calculator = new SimpleTextBasedCalculator();
        calculator.operate();
    }
}
