package entry;

import java.util.Objects;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-13 16:07
 */
public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction() {
    }

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return year == that.year &&
                value == that.value &&
                Objects.equals(trader, that.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trader, year, value);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
