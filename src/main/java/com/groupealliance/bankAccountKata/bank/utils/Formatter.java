package com.groupealliance.bankAccountKata.bank.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author IMAD EDDROUJI
 *
 */
public class Formatter {

	public static String formatMoney(final BigDecimal amount) {
		return amount + ".00";
	}

	public static String formatDate(final LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
