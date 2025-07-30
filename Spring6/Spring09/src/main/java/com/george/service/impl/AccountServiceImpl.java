package com.george.service.impl;

import com.george.mapper.AccountMapper;
import com.george.pojo.Account;
import com.george.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    @Autowired
    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }


    @Override
    @Transactional
    public void transfer(String fromActno, String toActno, double money) {
        // 查询账户余额是否充足
        Account fromAct = accountMapper.selectByActno(fromActno);

        if (fromAct.getBalance() < money) {
            throw new RuntimeException("账户余额不足");
        }
        // 余额充足，开始转账
        Account toAct = accountMapper.selectByActno(toActno);

        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        int count = accountMapper.update(fromAct);
        //模拟异常
        String s = null;
        s.toString();

        count += accountMapper.update(toAct);

        if (count != 2) {
            throw new RuntimeException("转账失败，请联系银行");
        }
    }
}
