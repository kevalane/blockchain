import { createHash } from 'crypto';
import { Transaction } from '../transactions/transaction';

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
    private merkleRootNode: MerkleTreeNode | null;

    constructor(transactions: Transaction[]) {
        this.merkleRootHash = "";
        this.merkleRootNode = null;
        this.createMerkleTree(transactions);
    }

    /**
     * Getter for merkleRootHash
     * @returns MerkleRootHash
     */
    public getMerkleRootHash(): string {
        return this.merkleRootHash;
    }

    /**
     * Creates our merkle tree and gets our merkleRootHash to be included in block header
     * @param transactions the transactions to create the merkle tree from
     */
    private createMerkleTree(transactions: any[]) {
        const paddedTransactions: any[] = this.padTransactions(transactions);
        const leafNodes: Array<MerkleTreeNode> = this.createLeafNodes(paddedTransactions);
        this.merkleRootNode = this.createMerkleNodes(leafNodes)[0]; // root node
        this.merkleRootHash = this.merkleRootNode.getHash(); // now we have created root hash
    }

    /**
     * Recursive function that builds the tree. returns array with one element when at root
     * @param children first iteration it's the leafs, second the layer above etc etc
     * @returns Array with one element containing root node
     */
    private createMerkleNodes(children: Array<MerkleTreeNode>): Array<MerkleTreeNode> {
        if (children.length <= 1) return children;
        let upperLevelNodes: Array<MerkleTreeNode> = new Array<MerkleTreeNode>();
        for (let i = 0; i < children.length; i += 2) {
            upperLevelNodes.push(new MerkleTreeNode(
                createHash('sha256').update(children[i].getHash() + children[i+1].getHash()).digest('hex'),
                children[i],
                children[i+1]
            ));
        }
        return this.createMerkleNodes(upperLevelNodes);
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

    public getHash(): string {
        return this.merkleHash;
    }

    public getLeftNode(): MerkleTreeNode | null {
        return this.leftNode;
    }

    public getRightNode(): MerkleTreeNode | null{
        return this.rightNode;
    }

    public setHash(hash: string): void {
        this.merkleHash = hash;
    }

    public setLeftNode(n: MerkleTreeNode): void {
        this.leftNode = n;
    }

    public setRightNode(n: MerkleTreeNode): void {
        this.rightNode = n;
    }
}

export { MerkleTree };