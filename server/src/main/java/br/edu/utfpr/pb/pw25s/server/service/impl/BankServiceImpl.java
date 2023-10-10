package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Bank;
import br.edu.utfpr.pb.pw25s.server.repository.BankRepository;
import br.edu.utfpr.pb.pw25s.server.service.IBankService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl extends CrudServiceImpl<Bank, Long> implements IBankService {

    private final BankRepository repository;

    public BankServiceImpl(BankRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Bank, Long> getRepository() {
        return repository;
    }
}
