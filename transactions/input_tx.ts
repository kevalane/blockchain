import { createHash, createSign, createVerify } from "crypto";
import { OutputTx } from "./output_tx";
import { Transaction } from "./transaction";

class InputTx {
    private transactionHash: string;
    private utxoIndex: number;
    private receiverPublicKey: string;
    private senderSignature: Buffer;

    constructor(t_hash: string, utxoIndex: number, receiverPublicKey: string, senderPrivateKey: string) {
        this.transactionHash = t_hash;
        this.utxoIndex = utxoIndex;
        this.receiverPublicKey = receiverPublicKey;
        this.senderSignature = this.signInputTx(senderPrivateKey);
    }

    public signInputTx(privateKey: string): Buffer {
        const concatenatedHash: string = createHash('sha256').update(this.transactionHash + this.receiverPublicKey).digest('hex');
        const sign = createSign('SHA256');
        sign.update(concatenatedHash).end();
        const signature = sign.sign(privateKey);
        return signature;
    }

    // we need to check so public key at outputIndex and this signature matches
    // static, should be moved to consensus!!!
    public verify(transaction: Transaction): boolean {
        const utxo: OutputTx | null = transaction.getUtxoByIndex(this.utxoIndex);
        if (utxo == null) return false;
        const utxoPublicKey: string = utxo.getAddress();
        const verifier = createVerify('SHA256');
        verifier.update(createHash('sha256').update(this.transactionHash + this.receiverPublicKey).digest('hex'));
        return verifier.verify(utxoPublicKey, this.senderSignature);
    }
}

export { InputTx }