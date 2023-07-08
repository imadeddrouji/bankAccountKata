package com.groupealliance.bankAccountKata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.groupealliance.bankAccountKata.actor.Client;

/**
 * @author IMAD EDDROUJI
 *
 */
public class AccountTransaction {

	private Client client;
	private int accountId;
	private LocalDate date;
	private BigDecimal amount;
	private String operationType;
	private BigDecimal balance;

	/**
	 * @param client
	 * @param accountId
	 * @param date
	 * @param amount
	 * @param operationType
	 * @param balance
	 */
	public AccountTransaction(Client client, int accountId, LocalDate date, BigDecimal amount, String operationType,
			BigDecimal balance) {
		super();
		this.client = client;
		this.accountId = accountId;
		this.date = date;
		this.amount = amount;
		this.operationType = operationType;
		this.setBalance(balance);
	}

	/**
	 * @return
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return
	 */
	public String getOperationType() {
		return operationType;
	}

	/**
	 * @param operationType
	 */
	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	/**
	 * @return
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	/**
	 *
	 */
	@Override
	public String toString() {
		return "AccountTransaction [client=" + client.getClientId() + ", accountId=" + accountId + ", date=" + date
				+ ", amount=" + amount + ", operationType=" + operationType + ", balance=" + balance + "]";
	}

}
