package ex50;

import org.junit.Test;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LawOfDemeterTest {

    TalksToStrangers sut = new TalksToStrangers();

    @Test
    public void canDeepStubOldWay() throws Exception {

        ServiceB mockB = mock(ServiceB.class);

        sut.serviceA = mock(ServiceA.class);

        doReturn(mockB).when(sut.serviceA).getServiceB();

        sut.service();

        verify(mockB).doSomething();
    }

    @Test
    public void canDeepStubWithMockito() throws Exception {
        sut.serviceA = mock(ServiceA.class, RETURNS_DEEP_STUBS);
        sut.service();
        verify(sut.serviceA.getServiceB()).doSomething();
    }

    class TalksToStrangers {
        ServiceA serviceA;

        void service() {
            serviceA.getServiceB().doSomething();
        }
    }

    interface ServiceA {
        ServiceB getServiceB();
    }

    interface ServiceB {
        void doSomething();
    }
}




