import { Transaction } from "../transactions/transaction";
import { BlockHeader } from "./block_header";

class Block {
    private blockSize: number;
    private blockHeader: BlockHeader;
    private transactionCounter: number;
    private transactions: Transaction[];

    constructor(blockHeader: BlockHeader) {
        this.blockSize = 80; // since ts have no bytes, let's just add 80 for header
        this.blockHeader = blockHeader;
        this.transactionCounter = 0;
        this.transactions = new Array<Transaction>();
    }
}