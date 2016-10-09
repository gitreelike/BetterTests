package ex50;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TellDontAskTest {

    Service sut = new Service();

    @Test
    public void askIsComplicatedToStub() throws Exception {

        AskAccount account = mock(AskAccount.class);

        doReturn(5).when(account).limit();
        doReturn(10).when(account).balance();

        sut.charge(account, 1);

        verify(account).setBalance(9);
    }

    @Test
    public void testTellAccount() throws Exception {
        // state based test
        TellAccount out = new TellAccount();

        out.balance = 10;

        out.charge(1);

        assertThat(out.balance).isEqualTo(9);
    }

    @Test
    public void testChargeTellAccount() throws Exception {
        // interaction based test
        TellAccount account = mock(TellAccount.class);

        sut.charge(account, 5);

        verify(account).charge(5);
    }

    class Service {

        void charge(AskAccount account, int amount) {

            int newBalance = account.balance() + account.limit() - amount;

            if (newBalance > 0) {
                account.setBalance(account.balance() - amount);
            }
        }

        void charge(TellAccount account, int amount) {
            account.charge(amount);
        }
    }

    interface AskAccount {
        int balance();

        int limit();

        void setBalance(int balance);
    }

    class TellAccount {
        int balance;
        int limit;

        void charge(int amount) {
            int newBalance = balance + limit - amount;

            if (newBalance > 0) {
                balance = balance - amount;
            }
        }
    }
}
