package expense_tracker.expense_tracker.functions.auth.controller;


import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.functions.auth.dto.LoginRequestDto;
import expense_tracker.expense_tracker.functions.auth.service.AuthService;
import expense_tracker.expense_tracker.model.ApiResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public ApiResultModel login(@RequestBody LoginRequestDto loginRequestDto) throws ExemptionError {
        return ApiResultModel.builder()
                .isSuccess(true)
                .resultData(authService.login(loginRequestDto))
                .build();
    }
}