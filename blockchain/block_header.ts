import { createHash } from "crypto";

class BlockHeader {
    private version: number;
    private previousBlockHash: string;
    private merkleRootHash: string;
    private timeStamp: number;
    private difficulty: number;
    private nonce: number;

    constructor(v: number, prevHash: string, merkle: string, time: number, difficulty: number) {
        this.version = v;
        this.previousBlockHash = prevHash;
        this.merkleRootHash = merkle;
        this.timeStamp = time;
        this.difficulty = difficulty;
        this.nonce = 0;
    }

    public getBlockHeaderHash(): string {
        const firstHash: string = createHash('sha256').update(
            this.version +
            this.previousBlockHash +
            this.merkleRootHash + 
            this.timeStamp +
            this.difficulty + 
            this.nonce
        ).digest('hex');
        return createHash('sha256').update(firstHash).digest('hex'); // double hashed
    }

    public setNonce(n: number): void {
        this.nonce = n;
    }

    public setTimeStamp(t: number): void {
        this.timeStamp = t;
    }
}

export { BlockHeader }