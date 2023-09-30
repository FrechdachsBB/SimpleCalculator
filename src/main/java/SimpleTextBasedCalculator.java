import java.util.ArrayList;

public class SimpleTextBasedCalculator extends Operation {

    private ArrayList<Operation> operations = new ArrayList<>();

    public SimpleTextBasedCalculator() {
        operations.add(new Addition());
        operations.add(new Subtraction());
        operations.add(new Multiplication());
        operations.add(new Division());
        operations.add(new PowerOf());
        operations.add(new SqareRoot());

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
            display.printf("Result: %.5f\n\n", selectedOperation.operate());
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
