package expense_tracker.expense_tracker.functions.otp.service.impl;


import expense_tracker.expense_tracker.common.email.EmailService;
import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.config.exemption.ExemptionErrorMessages;
import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.otp.dto.OtpDto;
import expense_tracker.expense_tracker.functions.otp.dto.SendOtp;
import expense_tracker.expense_tracker.functions.otp.dto.VerifyOtp;
import expense_tracker.expense_tracker.functions.otp.repository.OtpRepository;
import expense_tracker.expense_tracker.functions.otp.service.OtpService;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    /**
     * Creates a new OTP (One-Time Password) record in the database.
     *
     * @param otpDto An object containing the OTP information, including expiry date and time, OTP value, and username.
     */
    @Override
    public void createNewOtp(OtpDto otpDto) {
        otpRepository.createNewOtp(otpDto);

    }

    /**
     * Updates the expiry date and time and OTP value for the current OTP record associated with the specified username in the database.
     *
     * @param otpDto An object containing the updated OTP information, including the new expiry date and time, OTP value, and username.
     */
    @Override
    public void updateCurrentOtp(OtpDto otpDto) {
        otpRepository.updateCurrentOtp(otpDto);

    }

    @Override
    public Object validateUserNameOtp(VerifyOtp verifyOtp) throws ExemptionError {

        Long otpId = otpRepository.validateUserNameOtp(verifyOtp);

        if (ObjectUtils.isEmpty(otpId)) {
            throw new ExemptionError(ExemptionErrorMessages.OTP_INVALID);

        }

        return null;
    }

    @Override
    public AccountMaster sendOtpRequest(SendOtp sendOtp) throws ExemptionError {

        AccountMaster accountMaster = accountMasterRepository.validateEmail(sendOtp.getEmail()).orElse(null);

        if (ObjectUtils.isEmpty(accountMaster)) {
            throw new ExemptionError(ExemptionErrorMessages.EMAIL_NOT_FOUND);

        }

        // GENERATE OTP
        String otpGenerated = emailService.sendOTPEmail(accountMaster.getEmail(), accountMaster.getFirstName() + " " + accountMaster.getLastName());

        OtpDto otpDto = OtpDto.builder()
                .username(accountMaster.getEmail())
                .expiryDateTime(LocalDateTime.now().plusMinutes(5))
                .otp(otpGenerated)
                .build();

        if (ObjectUtils.isEmpty(otpRepository.findOtpId(accountMaster.getEmail()))) {
            createNewOtp(otpDto);

        } else {
            updateCurrentOtp(otpDto);

        }

        return accountMaster;
    }
}
