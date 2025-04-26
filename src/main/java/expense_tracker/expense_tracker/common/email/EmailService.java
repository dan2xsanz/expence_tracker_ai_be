package expense_tracker.expense_tracker.common.email;

public interface EmailService {

    String sendOTPEmail(String email, String name);
}
