package ex11

import spock.lang.Specification
import spock.lang.Subject

class AccountSpec extends Specification {

    @Subject
    Account account = new Account()

    def 'acount is empty by default'() {
        expect:
        account.balance == 0
    }

    def 'can book some money'() {
        when:
        account.book(100)

        then:
        account.balance == old(account.balance + 100)
    }

    def 'cannot book negative money'() {
        when:
        account.book(-100)

        then:
        account.balance == old(account.balance)
    }

    class Account {
        private int balance

        int getBalance() {
            balance
        }

        void book(int amount) {
            if (amount > 0) {
                balance += amount
            }
        }
    }
}
