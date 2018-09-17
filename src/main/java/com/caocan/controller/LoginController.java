package com.caocan.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import com.caocan.pojo.Account;
import com.caocan.repository.AccountRepository;

@Controller
public class LoginController extends AbstractController {
	private String successView;
	private String failView;

	private AccountRepository accountRepository;

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

	public String getFailView() {
		return failView;
	}

	public void setFailView(String failView) {
		this.failView = failView;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
												 HttpServletResponse response) throws Exception {
		String cardNo = request.getParameter("cardNo");
		String password = request.getParameter("password");
		Account account = getAccount(cardNo, password);

		Map<String, Object> model = new HashMap<String, Object>();
		if (account != null) {
			model.put("account", account);
			return new ModelAndView(getSuccessView(), model);
		} else {
			model.put("error", "卡号或密码不正确");
			return new ModelAndView(getFailView(), model);
		}
	}

	private Account getAccount(String cardNo, String password) {
//		if (cardNo.equals("123") && password.equals("123")) {
//			Account account = new Account();
//			account.setCardNo(cardNo);
//			account.setBalance(88.8F);
//			return account;
//		} else {
//			return null;
//		}
		/**
		 * 使用hibernate改造登录验证模块
		 */
		Account acc =accountRepository.findAccountByCardNo(cardNo);
		if (acc != null ){
			Account account = new Account();
			account.setCardNo(cardNo);
			account.setBalance(88.8F);
			return account;
		}else{
			return null;
		}
	}
}