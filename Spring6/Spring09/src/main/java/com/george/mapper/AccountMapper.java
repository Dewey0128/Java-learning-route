package com.george.mapper;

import com.george.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AccountMapper {

    /**
     * 根据账号查询余额
     * @param actno
     * @return
     */
    @Select("select * from account where actno = #{actno}")
    Account selectByActno(String actno);

    /**
     * 更新账户
     * @param act
     * @return
     */
    @Update("update account set balance = #{balance} where actno = #{actno}")
    int update(Account act);
}
