package us.jsand.miaul;

public class MiaulReaderException extends Exception {
    public MiaulReaderException() {
        super(null, null, true, true);
    }

    public MiaulReaderException(String message) {
        super(message, null, true, true);
    }

    public MiaulReaderException(String message, Throwable cause) {
        super(message, cause, true, true);
    }
}
