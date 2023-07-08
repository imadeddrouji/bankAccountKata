package com.groupealliance.bankAccountKata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.exceptions.InvalidTransactionException;
import com.groupealliance.bankAccountKata.bank.validation.Validator;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Account {

	private Integer accountNumber;
	private BigDecimal balance;
	private List<AccountTransaction> transactions = new ArrayList<AccountTransaction>();

	private Validator validator;

	public Account(Integer accountNumber, BigDecimal balance) {
		this.setAccountNumber(accountNumber);
		this.setBalance(balance);

	}

	public AccountTransaction addTransaction(Client client, Account account, LocalDate date, BigDecimal amount,
			String operationType) throws InvalidTransactionException {
		validator = new Validator();
		validator.validationParams(client, account, date, amount, operationType, balance);
		if (Constants.DEPOSIT.equals(operationType)) {
			balance = balance.add(amount);
		} else if (Constants.WITHDRAW.equals(operationType)) {
			balance = balance.subtract(amount);
		}
		AccountTransaction newTransaction = new AccountTransaction(client, account.getAccountNumber(), date, amount,
				operationType, balance);
		transactions.add(newTransaction);
		return newTransaction;
	}

	public List<AccountTransaction> getHistory() {
		Collections.sort(transactions, new Comparator<AccountTransaction>() {
			@Override
			public int compare(AccountTransaction t1, AccountTransaction t2) {
				return t1.getDate().compareTo(t2.getDate());
			}
		});
		return transactions;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
