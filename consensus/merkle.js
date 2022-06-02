"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MerkleTree = void 0;
/**
 * Create Merkle Tree from an array of transactions
 */
class MerkleTree {
    constructor(transactions) {
        this.merkleRootHash = "";
        this.merkleRootNode = new MerkleTreeNode();
        this.createMerkleTree(transactions);
    }
    createMerkleTree(transactions) {
        const paddedTransactions = this.padTransactions(transactions);
    }
    /**
     * Helper function to create the base of merkle tree.
     * Has to be a power of 2 number of leafs in tree.
     * @param transactions the transactions in the block.
     */
    padTransactions(transactions) {
        let nearest = (1 << 31 - Math.clz32(transactions.length));
        if (nearest < transactions.length)
            nearest = nearest * 2; // has to be greater
        let returnArray = new Array(nearest);
        // add transactions to the padded array
        for (let i = 0; i < nearest; i++) {
        }
        return returnArray;
    }
}
exports.MerkleTree = MerkleTree;
class MerkleTreeNode {
    constructor() {
        this.leftNode = new MerkleTreeNode();
        this.rightNode = new MerkleTreeNode();
        this.merkleHash = "";
    }
    getHash() {
        return this.merkleHash;
    }
    getLeftNode() {
        return this.leftNode;
    }
    getRightNode() {
        return this.rightNode;
    }
    setHash(hash) {
        this.merkleHash = hash;
    }
    setLeftNode(n) {
        this.leftNode = n;
    }
    setRightNode(n) {
        this.rightNode = n;
    }
}
