package chapter01;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FilteringCurrencies {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction(98.0, new Currency("UAH")),
                new Transaction(3.0, new Currency("UAH")),
                new Transaction(509.3, new Currency("USD")),
                new Transaction(43.0, new Currency("USD")),
                new Transaction(2.0, new Currency("AUD")),
                new Transaction(76.4, new Currency("UAH")),
                new Transaction(345.3, new Currency("USD")),
                new Transaction(15.4, new Currency("AUD")));
        List<Currency> currencies = List.of(new Currency("UAH"), new Currency("USD"), new Currency("GBP"), new Currency("AUD"));

        var transactionsByCurrencies = transactions
                .stream()
                .filter(t -> t.price() > 100)
                .collect(Collectors.groupingBy(Transaction::currency));

        log.info("Grouping {}", transactionsByCurrencies);

    }
}

record Currency(String currency) {
};

record Transaction(Double price, Currency currency) {};
