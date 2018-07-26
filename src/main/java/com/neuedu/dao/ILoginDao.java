package com.neuedu.dao;

import com.neuedu.entity.Account;

//�ӿڸ���ԭ��
public interface ILoginDao {

	public  Account   doLogin(String _username, String _password);
    public void addToken(String token, Account acc);
	public String  findTokenByAccountid(int accountid);
	
}
