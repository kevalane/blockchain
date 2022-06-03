import { Block } from "../blockchain/block";
import { BlockHeader } from "../blockchain/block_header";

class Mining {
    private blockchain: BlockHeader[];
    private currentBlockHeader: BlockHeader;
    private difficulty;

    constructor(blockchain: BlockHeader[], difficulty: number) {
        this.blockchain = blockchain;
        this.difficulty = difficulty;
        this.currentBlockHeader = this.generateBlockHeader();
    }

    private generateBlockHeader(): BlockHeader {
        const blockHeader = new BlockHeader(
            1, 
            this.blockchain[this.blockchain.length-1].getBlockHeaderHash(),
            "",
            Date.now() + 10*60*1000,
            this.difficulty
        )
        return blockHeader;
    }

    public mine(): void {
        const difficultyString: string = "";
        difficultyString.padStart(this.difficulty, "0");
        while(!this.currentBlockHeader.getBlockHeaderHash().startsWith(difficultyString)) {
            console.log(this.currentBlockHeader.getBlockHeaderHash());
            this.currentBlockHeader.setNonce(this.currentBlockHeader.getNonce() + 1);
        }
    }
}

export { Mining }