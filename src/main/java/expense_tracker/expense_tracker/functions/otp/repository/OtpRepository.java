package expense_tracker.expense_tracker.functions.otp.repository;

import expense_tracker.expense_tracker.functions.otp.dto.OtpDto;
import expense_tracker.expense_tracker.functions.otp.dto.VerifyOtp;

public interface OtpRepository {

    /**
     * Creates a new OTP (One-Time Password) record in the database.
     *
     * @param otpDto An object containing the OTP information, including expiry date and time, OTP value, and username.
     */
    void createNewOtp(OtpDto otpDto);

    /**
     * Updates the expiry date and time and OTP value for the current OTP record associated with the specified username in the database.
     *
     * @param otpDto An object containing the updated OTP information, including the new expiry date and time, OTP value, and username.
     */
    void updateCurrentOtp(OtpDto otpDto);

    Long validateUserNameOtp(VerifyOtp verifyOtp);

    Long findOtpId(String email);
}
