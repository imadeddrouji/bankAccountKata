package com.groupealliance.bankAccountKata.actor;

import java.util.ArrayList;
import java.util.List;

import com.groupealliance.bankAccountKata.bank.Account;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Client {

	private String clientId;

	private String firstName;

	private String lastName;

	private List<Account> accounts = new ArrayList<Account>();

	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Client() {
	}

	/**
	 * @param clientId
	 * @param firstName
	 * @param lastName
	 */
	public Client(String clientId, String firstName, String lastName, List<Account> accounts) {
		super();
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.setAccounts(accounts);
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", firstName=" + firstName + ", lastName=" + lastName + ", accounts="
				+ accounts + "]";
	}

}
