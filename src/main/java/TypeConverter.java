public interface TypeConverter <I,O>{
    O convert (I input) throws NumberFormatException;
}
