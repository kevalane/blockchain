/**
 * Create Merkle Tree from an array of transactions
 */
class MerkleTree {
    private merkleRoot: string;
    

    constructor(transactions: any[]) {
        this.merkleRoot = "";
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

    private getHash() {
        return this.merkleHash;
    }

    private getLeftNode() {
        return this.leftNode;
    }

    private getRightNode() {
        return this.rightNode;
    }

    private setHash(hash: string) {
        this.merkleHash = hash;
    }

    private setLeftNode(n: MerkleTreeNode) {
        this.leftNode = n;
    }

    private setRightNode(n: MerkleTreeNode) {
        this.rightNode = n;
    }
}

export { MerkleTree };