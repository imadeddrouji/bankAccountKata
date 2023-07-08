package com.groupealliance.bankAccountKata.bank.exceptions;

/**
 * @author IMAD EDDROUJI
 *
 */
@SuppressWarnings("serial")
public class InvalidTransactionException extends Exception {

	public InvalidTransactionException(String message) {
		super(message);
	}
}
