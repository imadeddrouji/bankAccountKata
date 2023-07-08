package com.groupealliance.bankAccountKata.bank.mapping;

import java.util.ArrayList;
import java.util.List;

import com.groupealliance.bankAccountKata.bank.AccountTransaction;
import com.groupealliance.bankAccountKata.bank.printing.StatementLine;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Mapper {

	public List<StatementLine> convertAccountTransactionToStatementLine(List<AccountTransaction> transactions) {

		if (transactions != null && !transactions.isEmpty()) {
			List<StatementLine> lines = new ArrayList<StatementLine>();
			for (AccountTransaction transaction : transactions) {
				StatementLine statementLine = new StatementLine(transaction.getDate(), transaction.getAmount(),
						transaction.getBalance());
				lines.add(statementLine);
			}
			return lines;
		}
		return null;
	}

}
