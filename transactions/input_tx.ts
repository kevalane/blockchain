class InputTx {
    private transactionHash: string;
    private utxoIndex: number;
    private receiverPublicKey: string;
    private senderSignature: string;

    constructor(t_hash: string, utxoIndex: number, pubKey: string) {
        this.transactionHash = t_hash;
        this.utxoIndex = utxoIndex;
        this.receiverPublicKey = pubKey;
        this.senderSignature = "";
    }

    public signInputTx(): void {
        
    }
}

export { InputTx }