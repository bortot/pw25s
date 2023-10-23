package br.edu.utfpr.pb.pw25s.server.controller;

import br.edu.utfpr.pb.pw25s.server.dto.AccountDTO;
import br.edu.utfpr.pb.pw25s.server.model.Account;
import br.edu.utfpr.pb.pw25s.server.model.User;
import br.edu.utfpr.pb.pw25s.server.service.IAccountService;
import br.edu.utfpr.pb.pw25s.server.service.ICrudService;
import br.edu.utfpr.pb.pw25s.server.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController extends CrudController<Account, AccountDTO, Long> {

    private static IAccountService iAccountService;
    private static  ModelMapper modelMapper;
    private static  UserService userService;

    public AccountController(IAccountService iAccountService ,ModelMapper modelMapper, UserService userService) {
        super(Account.class, AccountDTO.class);
        AccountController.iAccountService = iAccountService;
        AccountController.modelMapper = modelMapper;
        AccountController.userService = userService;
    }

    @Override
    protected ICrudService getService() {
        return iAccountService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return modelMapper;
    }

    @Override
    public Account preSave(Account entity) {
        User user = userService.getLoggedUser();
        entity.setUser(user);

        return super.preSave(entity);
    }
}
