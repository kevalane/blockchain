import { createHash, createSign, createVerify } from "crypto";
import { OutputTx } from "./output_tx";
import { Transaction } from "./transaction";

class InputTx {
    private transactionHash: string;
    private utxoIndex: number;
    private receiverPublicKey: string;
    private senderSignature: Buffer;

    constructor(t_hash: string, utxoIndex: number, pubKey: string) {
        this.transactionHash = t_hash;
        this.utxoIndex = utxoIndex;
        this.receiverPublicKey = pubKey;
        this.senderSignature = new Buffer("");
    }

    public signInputTx(privateKey: string): void {
        const concatenatedHash: string = createHash('sha-256').
            update(this.transactionHash + this.receiverPublicKey).digest('hex');
        const sign = createSign('SHA256');
        sign.update(concatenatedHash).end();
        const signature = sign.sign(privateKey);
        this.senderSignature = signature;
    }

    // we need to check so public key at outputIndex and this signature matches
    public verify(transaction: Transaction): boolean {
        const utxo: OutputTx | null = transaction.getUtxoByIndex(this.utxoIndex);
        if (utxo == null) return false;
        const utxoPublicKey: string = utxo.getAddress();
        const verifier = createVerify('SHA256');
        verifier.update(createHash('sha-256').update(this.transactionHash + this.receiverPublicKey).digest('hex'));
        return verifier.verify(utxoPublicKey, this.senderSignature);
    }
}

export { InputTx }