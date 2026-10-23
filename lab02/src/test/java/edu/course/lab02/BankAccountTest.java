
package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void shouldWithdrawMoney() {
        BankAccount account = new BankAccount(100);

        account.withdraw(40);

        assertEquals(60, account.getBalance());
    }

    @Test
    void shouldThrowWhenWithdrawingMoreThanBalance() {
        BankAccount account = new BankAccount(50);

        assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(60)
        );

        assertEquals(50, account.getBalance());
    }

    @Test
    void shouldRejectNegativeInitialBalance() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new BankAccount(-1)
        );
    }

    @Test
    void shouldRejectNonPositiveDeposit() {
        BankAccount account = new BankAccount(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(-5)
        );
    }

    @Test
    void shouldDepositMoney() {
        BankAccount account = new BankAccount(100);

        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    void shouldRejectNonPositiveWithdrawal() {
        BankAccount account = new BankAccount(100);

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(-10)
        );
    }
}
