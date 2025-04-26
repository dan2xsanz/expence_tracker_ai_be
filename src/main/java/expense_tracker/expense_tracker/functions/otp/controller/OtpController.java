package expense_tracker.expense_tracker.functions.otp.controller;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.otp.dto.SendOtp;
import expense_tracker.expense_tracker.functions.otp.dto.VerifyOtp;
import expense_tracker.expense_tracker.functions.otp.service.OtpService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("send-otp")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel sendOtp(@RequestBody SendOtp sendOtp) throws ExemptionError {
        return ApiResultModel.builder()
                .isSuccess(true)
                .resultData(otpService.sendOtpRequest(sendOtp))
                .build();
    }

    @PostMapping("verify-otp")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel verifyOtp(@RequestBody VerifyOtp verifyOtp) throws ExemptionError {
        otpService.validateUserNameOtp(verifyOtp);
        return ApiResultModel.builder()
                .isSuccess(true)
                .build();
    }
}

