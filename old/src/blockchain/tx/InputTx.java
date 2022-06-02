package blockchain.tx;

public class InputTx {
    /**
     * what transaction id the funds are coming from
     * what row was the output on? check output tx.java
     * signature form sender
     * verify function? take signature and check with public key (address) of output
     */

    private String prevId;
    private int row;
    private String sign;

    /**
     * Constructor for transaction input row
     * @param prevId
     *      String base16 representation of previous transaction id
     * @param row
     *      row of output column we are taking funds from
     * @param sign
     *      signature on transaction
     */
    public InputTx(String prevId, int row, String sign) {
        this.prevId = prevId;
        this.row = row;
        this.sign = sign;
    }

    /**
     * Getter for prev id which we are taking funds from
     * @return
     *      previous transaction id (String)
     */
    public String getPrevId() {
        return this.prevId;
    }

    /**
     * Getter for row position
     * @return
     *      row pos (int)
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Getter of signature (to be used for verification);
     * @return
     *      signature in base16 String
     */
    public String getSign() {
        return this.sign;
    }
}