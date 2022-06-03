import { MerkleTree } from './consensus/merkle';
import { InputTx } from './transactions/input_tx';
import { OutputTx } from './transactions/output_tx';
import { Transaction } from './transactions/transaction';
import { Wallet } from './wallet/wallet';
// let mt3: MerkleTree = new MerkleTree([1, 2, 3, 4, 5, 6, 7, 8, 9, 10]);
// let mt1: MerkleTree  = new MerkleTree([1, 2, 3]);
let wallet1: Wallet = new Wallet;
let wallet2: Wallet = new Wallet;
const input_tx: InputTx = new InputTx("genesis", 0, "");
const output_tx: OutputTx = new OutputTx(100, wallet1.getPublicKey());
const t: Transaction = new Transaction(1, [input_tx], [output_tx], Date.now());

console.log(t);
const input1: InputTx = new InputTx(t.getTransactionHash(), 0, wallet2.getPublicKey());
const output2: OutputTx = new OutputTx(100, wallet2.getPublicKey());
input1.signInputTx(wallet1.getPrivateKey());
console.log(input1.verify(t));