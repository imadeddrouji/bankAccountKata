package com.groupealliance.bankAccountKata.bank.printing;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author IMAD EDDROUJI
 *
 */
public class StatementLine {

	private LocalDate date;
	private BigDecimal amount;
	private BigDecimal balance;

	public StatementLine(LocalDate date, BigDecimal amount, BigDecimal balance) {
		super();
		this.date = date;
		this.amount = amount;
		this.balance = balance;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
