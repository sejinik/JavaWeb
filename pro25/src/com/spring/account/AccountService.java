package com.spring.account;

import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

// Service에서는 하나의 트랜잭션 단위로 기능을 실행시킨다
// 이 때 Transactional 을이용해 트랜잭션을 설정해둔다면
// 실행시킨 트랜잭션에 포함된 모든 SQL 이 정상적으로 작동해야만 commit => 데이터가 변경됨
// 하나라도 실패하면 rollback => 처음상태 그대로 유지 된다!
@Transactional(propagation=Propagation.REQUIRED)
public class AccountService {
	private AccountDAO accDAO;
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	public void sendMoney() throws DataAccessException{
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}
