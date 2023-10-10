package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Account;
import br.edu.utfpr.pb.pw25s.server.repository.AccountRepository;
import br.edu.utfpr.pb.pw25s.server.service.IAccountService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends CrudServiceImpl<Account, Long> implements IAccountService {

    private final AccountRepository repository;

    public AccountServiceImpl(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Account, Long> getRepository() {
        return repository;
    }
}
