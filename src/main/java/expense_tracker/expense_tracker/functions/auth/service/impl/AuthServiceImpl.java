package expense_tracker.expense_tracker.functions.auth.service.impl;

import expense_tracker.expense_tracker.config.exemption.ExemptionError;
import expense_tracker.expense_tracker.config.exemption.ExemptionErrorMessages;
import expense_tracker.expense_tracker.functions.account.repository.AccountMasterRepository;
import expense_tracker.expense_tracker.functions.auth.dto.LoginRequestDto;
import expense_tracker.expense_tracker.functions.auth.dto.LoginResponseDto;
import expense_tracker.expense_tracker.functions.auth.service.AuthService;
import expense_tracker.expense_tracker.model.AccountMaster;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AccountMasterRepository accountMasterRepository;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        // VALIDATE ACCOUNT
        AccountMaster accountMaster = accountMasterRepository.loginByEmail(loginRequestDto.getEmail())
                .orElseThrow(() -> new ExemptionError(ExemptionErrorMessages.INVALID_LOGIN));

        // VALIDATE PASSWORD
        if (!Objects.equals(accountMaster.getPassword(), loginRequestDto.getPassword())) {
            throw new ExemptionError(ExemptionErrorMessages.INVALID_PASSWORD);
        }

        LoginResponseDto loginResponse = new LoginResponseDto();
        BeanUtils.copyProperties(accountMaster, loginResponse);
        loginResponse.setLastTransmit(LocalDateTime.now());

        return loginResponse;
    }
}
