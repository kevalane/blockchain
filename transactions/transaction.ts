import { createHash } from 'crypto';
import { InputTx } from './input_tx';
import { OutputTx } from './output_tx';

class Transaction {
    private version: number;
    private inputCounter: number;
    private inputs: InputTx[];
    private outputCounter: number;
    private outputs: OutputTx[];
    private lockTime: number;

    /**
     * Creates a new transaction.
     * @param v the version the transaction adheres to
     * @param inputs input transactions
     * @param outputs output transactions
     * @param lockTime if 0 execute immediately, otherwise don't include until Date.now() > lockTime
     */
    constructor(v: number, inputs: InputTx[], outputs: OutputTx[], lockTime: number) {
        this.version = v;
        this.inputCounter = inputs.length;
        this.inputs = inputs;
        this.outputCounter = outputs.length;
        this.outputs = outputs;
        this.lockTime = lockTime;
    }

    public getTransactionHash(): string {
        return createHash('sha256').update("" + this.version + this.inputCounter + this.inputs +
        this.outputCounter + this.outputs + this.lockTime).digest('hex');
    }

    public getUtxoByIndex(index: number): OutputTx | null {
        if (index >= 0 && index <= this.outputCounter) return this.outputs[index];
        return null;
    }
}

export { Transaction }