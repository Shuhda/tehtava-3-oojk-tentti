import java.time.LocalDate;

public record Entry(String name, String address, String email, String product, LocalDate purchaseDate) {}

@FunctionalInterface
interface EntryFilter {
    boolean filter(Entry entry);
}

import java.util.List;
import java.util.stream.Collectors;

class EntryUtils {
    public static List<Entry> filterEntries(List<Entry> entries, EntryFilter filter) {
        return entries.stream()
                .filter(filter::filter)
                .collect(Collectors.toList());
    }
}


abstract class Transaction {
    protected double amount;
    protected String currency;

    public Transaction(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public abstract String display();
}

class Deposit extends Transaction {
    public Deposit(double amount, String currency) {
        super(amount, currency);
    }

    @Override
    public String display() {
        return "Deposit of " + amount + " " + currency;
    }
}

class Withdrawal extends Transaction {
    public Withdrawal(double amount, String currency) {
        super(amount, currency);
    }

    @Override
    public String display() {
        return "Withdrawal of " + amount + " " + currency;
    }
}

class Transfer extends Transaction {
    public Transfer(double amount, String currency) {
        super(amount, currency);
    }

    @Override
    public String display() {
        return "Transfer of " + amount + " " + currency;
    }
}
