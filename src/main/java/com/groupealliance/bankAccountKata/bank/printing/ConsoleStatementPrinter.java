package com.groupealliance.bankAccountKata.bank.printing;

import java.util.List;

import com.groupealliance.bankAccountKata.bank.AccountTransaction;
import com.groupealliance.bankAccountKata.bank.Constants;
import com.groupealliance.bankAccountKata.bank.mapping.Mapper;
import com.groupealliance.bankAccountKata.bank.utils.Formatter;

/**
 * @author IMAD EDDROUJI
 *
 */
public class ConsoleStatementPrinter {

	private Mapper mapper = new Mapper();

	private List<StatementLine> statementLines;

	public ConsoleStatementPrinter(List<AccountTransaction> transactions) {
		this.setStatementLines(mapper.convertAccountTransactionToStatementLine(transactions));
	}

	public void print() {
		if (this.statementLines.isEmpty()) {
			return;
		}
		printHeader();

		for (StatementLine statementLine : statementLines) {
			System.out.println(format(statementLine));
		}
	}

	private String format(final StatementLine statementLine) {
		return Formatter.formatDate(statementLine.getDate()) + Constants.FIELD_SEPARATOR
				+ Formatter.formatMoney(statementLine.getAmount()) + Constants.FIELD_SEPARATOR
				+ Formatter.formatMoney(statementLine.getBalance());
	}

	private void printHeader() {
		System.out.println("DATE | AMOUNT | BALANCE");
	}

	public List<StatementLine> getStatementLines() {
		return statementLines;
	}

	public void setStatementLines(List<StatementLine> statementLines) {
		this.statementLines = statementLines;
	}

}
