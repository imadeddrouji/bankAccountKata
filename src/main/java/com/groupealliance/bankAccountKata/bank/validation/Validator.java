package com.groupealliance.bankAccountKata.bank.validation;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.Account;
import com.groupealliance.bankAccountKata.bank.Constants;
import com.groupealliance.bankAccountKata.bank.exceptions.InvalidTransactionException;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Validator {

	public void validationParams(Client client, Account account, LocalDate date, BigDecimal amount,
			String operationType, BigDecimal balance) throws InvalidTransactionException {
		if (client == null)
			throw new InvalidTransactionException("Unspecified client");
		if (account == null)
			throw new InvalidTransactionException("Unspecified account");
		if (account != null && account.getAccountNumber() == null)
			throw new InvalidTransactionException("Unspecified account");
		if (Constants.DEPOSIT.equals(operationType) && amount.compareTo(new BigDecimal(0)) < 0)
			throw new InvalidTransactionException("Incorrect amount for a credit transaction");
		if (Constants.WITHDRAW.equals(operationType) && amount.abs().compareTo(balance) > 0)
			throw new InvalidTransactionException(
					"Account not sufficiently provisionned : " + balance + " < " + amount);
		if (amount.compareTo(new BigDecimal(0)) == 0)
			throw new InvalidTransactionException("I have better things to do with my time");

	}

}
