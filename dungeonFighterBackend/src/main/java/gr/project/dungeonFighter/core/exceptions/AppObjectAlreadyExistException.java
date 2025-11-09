package gr.project.dungeonFighter.core.exceptions;

public class AppObjectAlreadyExistException extends AppGenericException {
    private static final String DEFAULT_CODE = "AlreadyExists";
    public AppObjectAlreadyExistException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
