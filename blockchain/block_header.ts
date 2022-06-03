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

    
}

export { BlockHeader }