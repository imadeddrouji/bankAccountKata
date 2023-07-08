package com.groupealliance.bankAccountKata.bank.transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.Account;
import com.groupealliance.bankAccountKata.bank.AccountTransaction;

/**
 * @author IMAD EDDROUJI
 *
 */
public interface ITransaction {

	public boolean addDeposit(Client client, Optional<Account> account, LocalDate date, BigDecimal amount);

	public boolean addWithdarwal(Client client, Optional<Account> account, LocalDate date, BigDecimal amount);

	public List<AccountTransaction> getTransactionHistory(Client client, Optional<Account> account);

}
