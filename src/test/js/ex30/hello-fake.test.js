import {hello} from './hello';

it('Jest manualmocks (fakes) can be used', () => {
    const result = hello('world');

    // TODO: schwierig hier einen Matcher zu finden der immer passt.
    // Irgendwie ändert sich das Datum immer. Ich probier es mal mit nem
    // regulären Ausdruck ... vielleicht gibts hier ne andere Möglichkeit?
    expect(result).toMatch(/Hello world at Sun Jul 22 2018 .*/);
});