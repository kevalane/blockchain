import { createHash } from 'crypto';

/*
TODO: Add these test cases
let mt1: MerkleTree = new MerkleTree([1, 2, 3, 4, 5]);

let mt2: MerkleTree = new MerkleTree([1, 2, 3, 4, 5, 6, 7]);

let mt3: MerkleTree = new MerkleTree([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
*/

/**
 * Create Merkle Tree from an array of transactions
 * 
 */
class MerkleTree {
    private merkleRootHash: string;
    // private merkleRootNode: MerkleTreeNode;

    constructor(transactions: any[]) {
        this.merkleRootHash = "";
        // this.mer kleRootNode = new MerkleTreeNode();
        this.createMerkleTree(transactions);
    }

    private createMerkleTree(transactions: any[]) {
        const paddedTransactions: any[] = this.padTransactions(transactions);
        const leafNodes: Array<MerkleTreeNode> = this.createLeafNodes(paddedTransactions);
        console.log(leafNodes);
    }

    /**
     * Creates MerkleTreeNodes of all our leafs
     * @param tx the transactions (padded)
     * @returns all our leafs an array
     */
    private createLeafNodes(tx: any[]): Array<MerkleTreeNode> {
        let returnArray: Array<MerkleTreeNode> = new Array<MerkleTreeNode>(tx.length);
        for (let i = 0; i < tx.length; i++) {
            returnArray[i] = new MerkleTreeNode(createHash('sha256').update(tx[i].toString()).digest('hex'), null, null);
        }
        return returnArray;
    }

    /**
     * Helper function to create the base of merkle tree.
     * Has to be a power of 2 number of leafs in tree.
     * @param transactions the transactions in the block.
     * @returns Array of transactions now padded
     */
    private padTransactions(transactions: any[]): Array<any> {
        let nearestUpwards: number = (1 << 31 - Math.clz32(transactions.length));
        let nearestDownwards: number;
        if (nearestUpwards < transactions.length){
            nearestDownwards = nearestUpwards; // eg. this is 32, but we have 44 transactions
            nearestUpwards = nearestUpwards*2; // has to be greater, so upwards becomes 64, "closing in" the 44 transactions.
        } else {
            nearestDownwards = nearestUpwards/2; // in this case up is 64, transaction is 44, so we make down 64/2=32
        }
        let returnArray: Array<any> =  new Array<any>(nearestUpwards); // size of biggest, 64 in our examples
        // add transactions to the padded array, all upp to down not affected
        for (let i = 0; i < nearestDownwards; i++) {
            returnArray[i] = transactions[i];
        }
        for (let i = nearestDownwards; i < transactions.length; i++) {
            returnArray[i] = transactions[i]; // add all transactions explicit
        }
        for (let i = transactions.length; i < nearestUpwards; i ++) {
            if ((nearestUpwards - transactions.length) % 2 == 0) {
                // evenly divisible => last two needed for padding
                returnArray[i] = transactions[transactions.length - 2];
                returnArray[i+1] = transactions[transactions.length - 1];
                i++;
            } else {
                // only last needed
                returnArray[i] = transactions[transactions.length - 1];
            }
        }
        return returnArray;
    }
}

class MerkleTreeNode {
    private merkleHash: string;
    private leftNode: MerkleTreeNode | null;
    private rightNode: MerkleTreeNode | null;

    constructor(hash: string, left: MerkleTreeNode | null, right: MerkleTreeNode | null) {
        this.leftNode = left;
        this.rightNode = right;
        this.merkleHash = hash;
    }

    private getHash(): string {
        return this.merkleHash;
    }

    private getLeftNode(): MerkleTreeNode | null {
        return this.leftNode;
    }

    private getRightNode(): MerkleTreeNode | null{
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