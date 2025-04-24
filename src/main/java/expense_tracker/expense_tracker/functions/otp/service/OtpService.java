package expense_tracker.expense_tracker.functions.otp.service;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.otp.dto.OtpDto;
import expense_tracker.expense_tracker.functions.otp.dto.SendOtp;
import expense_tracker.expense_tracker.functions.otp.dto.VerifyOtp;
import expense_tracker.expense_tracker.model.AccountMaster;

public interface OtpService {

    void createNewOtp(OtpDto otpDto);

    void updateCurrentOtp(OtpDto otpDto);

    Object validateUserNameOtp(VerifyOtp verifyOtp) throws ExemptionError;

    AccountMaster sendOtpRequest(SendOtp sendOtp) throws ExemptionError;
}
