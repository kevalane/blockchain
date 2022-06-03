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
}

export { Mining }