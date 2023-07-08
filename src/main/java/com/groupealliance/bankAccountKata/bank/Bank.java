package com.groupealliance.bankAccountKata.bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.transaction.TransactionImp;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Bank {

	private final String bankName;
	private List<Client> clients = new ArrayList<Client>();

	private TransactionImp transaction = new TransactionImp();

	public Bank(String bankName) {
		this.bankName = bankName;
	}

	public String getBankName() {
		return bankName;
	}

	public void createClient(Client client) {
		clients.add(client);
	}

	public boolean deposit(Client client, int accountId, LocalDate date, BigDecimal amount) {
		Optional<Account> account = getAccount(client, accountId);
		return transaction.addDeposit(client, account, date, amount);
	}

	public boolean withdraw(Client client, int accountId, LocalDate date, BigDecimal amount) {
		Optional<Account> account = getAccount(client, accountId);
		return transaction.addWithdarwal(client, account, date, amount);
	}

	public BigDecimal getBalance(Client client, int accountId) {
		Optional<Account> account = getAccount(client, accountId);
		if (!account.isPresent())
			return new BigDecimal(0);
		return account.get().getBalance();
	}

	public List<AccountTransaction> getTransactionHistory(Client client, int accountId) {
		Optional<Account> account = getAccount(client, accountId);
		return transaction.getTransactionHistory(client, account);
	}

	public Optional<Account> getAccount(Client client, int accountId) {
		if (client == null)
			return Optional.empty();
		return client.getAccounts().stream().filter(account -> account.getAccountNumber() == accountId).findAny();
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", clients=" + clients + "]";
	}

}
