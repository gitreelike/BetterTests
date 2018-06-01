class Account {
    constructor() {
        this.balance = 0;
    }

    currentBalance = () => {
        return this.balance;
    };

    book = (amount) => {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}

describe('Account', () => {
    it('is empty by default', () => {
        expect(new Account().currentBalance()).toBe(0);
    });

    it('can book positive amount', () => {
        const account = new Account();
        account.book(100);

        expect(account.currentBalance()).toBe(100);
    });

    it('negative amount is ignored', () => {
        const account = new Account();
        account.book(-100);

        expect(account.currentBalance()).toBe(0);
    });
});