import { InputTx } from './input_tx';
import { OutputTx } from './output_tx';

class Transaction {
    private version: number;
    private inputCounter: number;
    private inputs: InputTx[];
    private outputCounter: number;
    private outputs: OutputTx[];

    constructor(v: number, inputs: InputTx[], outputs: OutputTx[]) {
        this.version = v;
        this.inputCounter = inputs.length;
        this.inputs = inputs;
        this.outputCounter = outputs.length;
        this.outputs = outputs;
    }
}