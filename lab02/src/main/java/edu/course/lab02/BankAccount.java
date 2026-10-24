
package edu.course.lab02;

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException(
                    "Начальный баланс не может быть отрицательным"
            );
        }

        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма пополнения должна быть положительной"
            );
        }

        if (balance > Integer.MAX_VALUE - amount) {
            throw new IllegalArgumentException(
                    "Превышен допустимый баланс"
            );
        }

        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Сумма списания должна быть положительной"
            );
        }

        if (amount > balance) {
            throw new IllegalStateException(
                    "Недостаточно средств"
            );
        }

        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}
