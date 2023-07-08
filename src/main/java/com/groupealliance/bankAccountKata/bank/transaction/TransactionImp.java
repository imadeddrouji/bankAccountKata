package com.groupealliance.bankAccountKata.bank.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.Account;
import com.groupealliance.bankAccountKata.bank.AccountTransaction;
import com.groupealliance.bankAccountKata.bank.Constants;
import com.groupealliance.bankAccountKata.bank.exceptions.InvalidTransactionException;

/**
 * @author IMAD EDDROUJI
 *
 */
public class TransactionImp implements ITransaction {

	@Override
	public boolean addDeposit(Client client, Optional<Account> account, LocalDate date, BigDecimal amount) {
		if (!account.isPresent())
			return false;
		try {

			if (account.get().addTransaction(client, account.get(), date, amount, Constants.DEPOSIT) != null)
				return true;
		} catch (InvalidTransactionException e) {
			return false;
		}
		return false;
	}

	@Override
	public boolean addWithdarwal(Client client, Optional<Account> account, LocalDate date, BigDecimal amount) {
		if (!account.isPresent())
			return false;
		try {
			if (account.get().addTransaction(client, account.get(), date, amount, Constants.WITHDRAW) != null)
				return true;
		} catch (InvalidTransactionException e) {
			return false;
		}
		return false;
	}

	public List<AccountTransaction> getTransactionHistory(Client client, Optional<Account> account) {
		if (!account.isPresent())
			return null;
		return account.get().getHistory();
	}

}
