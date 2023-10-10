package br.edu.utfpr.pb.pw25s.server.service.impl;

import br.edu.utfpr.pb.pw25s.server.model.Expense;
import br.edu.utfpr.pb.pw25s.server.repository.TransactionRepository;
import br.edu.utfpr.pb.pw25s.server.service.ITransactionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends CrudServiceImpl<Expense, Long> implements ITransactionService {

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    protected JpaRepository<Expense, Long> getRepository() {
        return repository;
    }
}
