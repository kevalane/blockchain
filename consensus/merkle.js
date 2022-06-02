"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MerkleTree = void 0;
/**
 * Create Merkle Tree from an array of transactions
 */
class MerkleTree {
    constructor(transactions) {
        this.merkleRoot = "";
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
