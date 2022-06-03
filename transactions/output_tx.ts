class OutputTx {
    private amount: number;
    private address: string;

    constructor(amount: number, address: string) {
        this.amount = amount;
        this.address = address;
    }

    public getAddress(): string {
        return this.address; // for now address == publicKey
    }
}

export { OutputTx }