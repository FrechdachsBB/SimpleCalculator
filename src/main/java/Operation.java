import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class Operation {

    PrintStream display;
    InputStream inputStream;

    /**
     * Default Constructor uses System.in and System.out to ask for inputs and display results and instructions.
     */
    public Operation(){
        this(System.out, System.in);
    }

    /**
     * @param display PrintStream to display results and instructions
     * @param inputStream InputStream to receive UserInputs
     */
    public Operation(PrintStream display, InputStream inputStream){
        this.display=display;
        this.inputStream = inputStream;
    }


    /**
     * This Method will be called, once a user decides to choose this Operation.
     * It should ask for all necessary arguments and finally return the result as Long.
     * It may return null if the user makes an invalid input.
     * @return The result of the operation
     * @throws ArithmeticException In case of an illegal Arithmetic Operation
     */
    public abstract Double operate() throws ArithmeticException;

    /**
     * @return The name of this Operation as it should be displayed.
     */
    public abstract String getDisplayName();


    /**
     * Displays the help Message and gives the user the opportunity to insert a value.
     * Trys to convert the value into {@link T} and returns it.
     * @return The converted value or null if retryOnError is false and the conversion raised a NumberFormatException
     */
    protected <T> T ask(String helpMessage, boolean retryOnError, TypeConverter<String,T> converter){
        Scanner scanner = new Scanner(inputStream);
        do {
            try {
                display.println(helpMessage);
                display.print("\t");
                String input = scanner.nextLine();
                return converter.convert(input);
            } catch (NumberFormatException nfe) {
                if(retryOnError)display.println("Invalid Input. Please Try again.");
                else return null;
            }
        }while (true);
    }

    /**
     * Allows the user to insert an Integer. Does not retry on an invalid input and returns null instead.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Integer askForInt(String helpMessage){
        return askForInt(helpMessage, false);
    }

    /**
     * Allows the user to insert an Integer.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Integer askForInt(String helpMessage, boolean retryOnError) {
        return ask(helpMessage, retryOnError, Integer::parseInt);
    }

    /**
     * Allows the user to insert a Long. Does not retry on an invalid input and returns null instead.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Long askForLong(String helpMessage){
        return askForLong(helpMessage, false);
    }

    /**
     * Allows the user to insert a Long.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Long askForLong(String helpMessage, boolean retryOnError){
        return ask(helpMessage, retryOnError, Long::parseLong);
    }

    /**
     * Allows the user to insert a Double. Does not retry on an invalid input and returns null instead.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Double askForDouble(String helpMessage){
        return askForDouble(helpMessage, false);
    }

    /**
     * Allows the user to insert a Double.
     * @see #ask(String, boolean, TypeConverter)
     */
    protected Double askForDouble(String helpMessage, boolean retryOnError){
        return ask(helpMessage, retryOnError, Double::parseDouble);
    }

    abstract void reset();



}
