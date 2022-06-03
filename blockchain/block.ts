import { MerkleTree } from "../consensus/merkle";
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

    public addTransaction(t: Transaction) {
        this.blockSize += 250; // just add the min, again ts has no bytes
        this.transactionCounter += 1;
        this.transactions.push(t);
        const newMerkleTree: MerkleTree = new MerkleTree(this.transactions);
        this.blockHeader.setMerkleRoot(newMerkleTree);
    }
}

export { Block }