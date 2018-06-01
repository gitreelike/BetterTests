import {hello} from './hello';

jest.mock('./hello');

it('Jest manualmocks (fakes) can be used', () => {
    const result = hello('world');

    expect(result).toBe('Fake Hello');
});