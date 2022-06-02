/**
 * Create Merkle Tree from an array of transactions
 */
class MerkleTree {
    private merkleRootHash: string;
    private merkleRootNode: MerkleTreeNode;

    constructor(transactions: any[]) {
        this.merkleRootHash = "";
        this.merkleRootNode = new MerkleTreeNode();
        this.createMerkleTree(transactions);
    }

    private createMerkleTree(transactions: any[]) {
        const paddedTransactions: any[] = this.padTransactions(transactions);
    }

    /**
     * Helper function to create the base of merkle tree.
     * Has to be a power of 2 number of leafs in tree.
     * @param transactions the transactions in the block.
     */
    private padTransactions(transactions: any[]): Array<any> {
        let nearest: number = (1 << 31 - Math.clz32(transactions.length));
        if (nearest < transactions.length) nearest = nearest*2; // has to be greater
        let returnArray: Array<any> =  new Array<any>(nearest);
        // add transactions to the padded array
        for (let i = 0; i < nearest; i++) {
            
        }
        return returnArray;
    }
}

class MerkleTreeNode {
    private merkleHash: string;
    private leftNode: MerkleTreeNode;
    private rightNode: MerkleTreeNode;

    constructor() {
        this.leftNode = new MerkleTreeNode();
        this.rightNode = new MerkleTreeNode();
        this.merkleHash = "";
    }

    private getHash(): string {
        return this.merkleHash;
    }

    private getLeftNode(): MerkleTreeNode {
        return this.leftNode;
    }

    private getRightNode(): MerkleTreeNode {
        return this.rightNode;
    }

    private setHash(hash: string): void {
        this.merkleHash = hash;
    }

    private setLeftNode(n: MerkleTreeNode): void {
        this.leftNode = n;
    }

    private setRightNode(n: MerkleTreeNode): void {
        this.rightNode = n;
    }
}

export { MerkleTree };