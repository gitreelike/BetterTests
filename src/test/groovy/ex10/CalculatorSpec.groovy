package ex10

import bt.Calculator
import spock.lang.Specification;
import spock.lang.Subject;

class CalculatorSpec extends Specification {

    @Subject
    Calculator calculator = new Calculator()

    def "can add numbers"() {
        expect:
        calculator.add(10, 10) == 20
    }
}
