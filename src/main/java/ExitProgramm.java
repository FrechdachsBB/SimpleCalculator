public class ExitProgramm extends Operation{
    @Override
    public Double operate() {
        System.exit(0);
        return null;
    }

    @Override
    public String getDisplayName() {
        return "Exit";
    }
}
