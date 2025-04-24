package expense_tracker.expense_tracker.config.exemption;

public enum ExemptionErrorMessages implements ExemptionErrorMessageBase {

    EMAIL_ALREADY_EXIST_MESSAGE("EmailExist", "Email already exist. Please try new email."),

    EMAIL_NOT_FOUND("EmailNotFound", "Email Not Found, Please make sure email is registered."),

    THIRD_PARTY_ERROR_MESSAGE("ThirdParty", "Something went wrong with Hugging Face API response"),


    OTP_INVALID("InvalidOtp", "Invalid OTP, Please try again."),

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
