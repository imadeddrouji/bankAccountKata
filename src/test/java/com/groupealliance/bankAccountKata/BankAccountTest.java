package com.groupealliance.bankAccountKata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

import com.groupealliance.bankAccountKata.actor.Client;
import com.groupealliance.bankAccountKata.bank.Account;
import com.groupealliance.bankAccountKata.bank.Bank;
import com.groupealliance.bankAccountKata.bank.printing.ConsoleStatementPrinter;

/**
 * Tests JUnit 
 * @author IMAD EDDROUJI
 *
 */
public class BankAccountTest {

	private static final Logger LOGGER = Logger.getLogger("BankAccountTest");

	private Bank SGBank;

	private ConsoleStatementPrinter consoleStatementPrinter;

	@Before
	public void prepare() {

		SGBank = new Bank("SG bank");

		List<Account> accounts = Arrays.asList(new Account(1, new BigDecimal(100)), new Account(2, new BigDecimal(10)),
				new Account(3, new BigDecimal(120)));

		Client client = new Client("AZ12345", "imad", "eddrouji", accounts);
		Client client2 = new Client("BD12345", "groupe", "alliance", accounts);
		SGBank.createClient(client);
		SGBank.createClient(client2);
	}

	@Test
	public void deposit() {

		int accountId = SGBank.getClients().get(0).getAccounts().get(0).getAccountNumber();

		LOGGER.info("current balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);
		assertTrue(
				SGBank.deposit(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(100)));

		LOGGER.info("New balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);

		accountId = SGBank.getClients().get(0).getAccounts().get(1).getAccountNumber();

		LOGGER.info("current balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);
		assertTrue(
				SGBank.deposit(SGBank.getClients().get(1), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(120)));

		LOGGER.info("New balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);

		// test le cas ou le montant à verser <= 0
		assertFalse(
				SGBank.deposit(SGBank.getClients().get(1), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(0)));

		assertFalse(
				SGBank.deposit(SGBank.getClients().get(1), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(-9)));
	}

	@Test
	public void withdraw() {

		int accountId = SGBank.getClients().get(0).getAccounts().get(0).getAccountNumber();

		LOGGER.info("current balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);
		assertTrue(
				SGBank.withdraw(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(10)));

		LOGGER.info("new balance = " + SGBank.getBalance(SGBank.getClients().get(0), accountId).toString()
				+ " for account = " + accountId);

		// test le cas ou le montant à verser > BALANCE
		assertFalse(
				SGBank.withdraw(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(800)));

	}

	@Test
	public void printHistoryTransactions() {

		int accountId = SGBank.getClients().get(0).getAccounts().get(0).getAccountNumber();

		assertTrue(
				SGBank.deposit(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 8), new BigDecimal(100)));

		assertTrue(
				SGBank.deposit(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 9), new BigDecimal(120)));

		assertTrue(
				SGBank.deposit(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 10), new BigDecimal(10)));

		assertTrue(
				SGBank.deposit(SGBank.getClients().get(0), accountId, LocalDate.of(2023, 07, 12), new BigDecimal(10)));

		consoleStatementPrinter = new ConsoleStatementPrinter(
				SGBank.getTransactionHistory(SGBank.getClients().get(0), accountId));
		consoleStatementPrinter.print();
	}

}
