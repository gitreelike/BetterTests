package ex12

import spock.lang.Specification
import spock.lang.Subject

class InteractionSpec extends Specification {

    interface SmsService {
        void send(String msg)
    }

    class HelloService {
        SmsService smsService

        void service(String name) {
            smsService.send("Hello $name")
        }
    }

    @Subject
    HelloService sut = new HelloService()

    // mockist approach

    def 'mocked interaction'() {
        given:
        sut.smsService = Mock(SmsService)

        when:
        sut.service('Martin')

        then:
        1 * sut.smsService.send('Hello Martin')
    }

    // classical approach

    def 'spied real interaction'() {
        given:
        sut.smsService = Spy(RealSmsService)

        when:
        sut.service('Tassilo')

        then:
        1 * sut.smsService.send("Hello Slow")
    }

    def 'spied fake interaction'() {
        given:
        sut.smsService = Spy(FakeSmsService)

        when:
        sut.service('Tassilo')

        then:
        1 * sut.smsService.send("Hello Tassilo")
    }

    class RealSmsService implements SmsService {
        @Override
        void send(String msg) {
            Thread.sleep(2000)
        }
    }

    class FakeSmsService implements SmsService {
        @Override
        void send(String msg) {
            println msg
        }
    }
}
