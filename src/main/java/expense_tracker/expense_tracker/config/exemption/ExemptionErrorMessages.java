package expense_tracker.expense_tracker.config.exemption;

public enum ExemptionErrorMessages implements ExemptionErrorMessageBase {

    GENERIC_EXCEPTION_MESSAGE("GenericError", "An error occurred while processing your request. Please try again later.");

    private final String code;

    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    ExemptionErrorMessages(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
