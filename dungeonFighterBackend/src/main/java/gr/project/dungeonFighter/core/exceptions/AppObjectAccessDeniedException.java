package gr.project.dungeonFighter.core.exceptions;

public class AppObjectAccessDeniedException extends AppGenericException {
  private static final String DEFAULT_CODE = "AccessDenied";
    public AppObjectAccessDeniedException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
