package com.caocan.repository;

import javax.persistence.Table;
import com.caocan.pojo.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Table(name="t_account")
@Qualifier("accountRepository")
public interface AccountRepository extends CrudRepository<Account,String>{

//    public Account findOne(String id);

    @Query("select t from Account t where t.cardNo=:cardNo")
    public Account findAccountByCardNo(@Param("cardNo") String cardNo);

//    @Query("select t from Account t where t.sex=:sex")
//    public Account findUserBySex(@Param("sex") String sex);

//    @Query("delete from Account t where t.id=:id")
//    public int deleteUserById(@Param("id") int id);

}