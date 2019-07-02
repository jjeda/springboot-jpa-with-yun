package me.jjeda.accountexample;

import me.jjeda.accountexample.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account create(AccountDto.SignUpReq dto) {
        return accountRepository.save(dto.toEntity());
    }

    @Transactional(readOnly = true)
    public  Account findById(Long id) {
        final Account account = accountRepository.getOne(id);
        if (account == null) throw new AccountNotFoundException(id);
        return account;
    }

    public Account updateMyAccount(long id, AccountDto.MyAccountReq dto) {
        final Account account = findById(id);
        account.updateMyAccount(dto);
        return account;
    }

}
