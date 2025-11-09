package gr.project.dungeonFighter.core.exceptions;

public class AppObjectNotFoundException extends AppGenericException {
    private static final String DEFAULT_CODE = "_NOT_FOUND";
    public AppObjectNotFoundException(String code, String message) {
        super(code.toUpperCase() + DEFAULT_CODE, message);
    }
}
