package gr.project.dungeonFighter.core.exceptions;

public class AppObjectInvalidArgumentException extends AppGenericException {
  private static final String DEFAULT_CODE = "_INVALID_ARGUMENT";
    public AppObjectInvalidArgumentException(String code, String message) {
        super(code.toUpperCase() + DEFAULT_CODE, message);
    }
}
