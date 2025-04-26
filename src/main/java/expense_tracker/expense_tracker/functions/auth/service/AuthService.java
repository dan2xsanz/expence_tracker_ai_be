package expense_tracker.expense_tracker.functions.auth.service;

import expense_tracker.expense_tracker.functions.auth.dto.LoginRequestDto;
import expense_tracker.expense_tracker.functions.auth.dto.LoginResponseDto;

public interface AuthService {

    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
