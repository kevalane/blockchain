import { generateKeyPairSync } from "crypto";

class Wallet {
    private publicKey: string;
    private privateKey: string;

    constructor() {
        const keypair = generateKeyPairSync('rsa', {
            modulusLength: 2048,
            publicKeyEncoding: { type: 'spki', format: 'pem' },
            privateKeyEncoding: { type: 'pkcs8', format: 'pem' }
        });
        this.publicKey = keypair.publicKey;
        this.privateKey = keypair.privateKey;
    }

    public getPublicKey(): string {
        return this.publicKey;
    }

    public getPrivateKey(): string {
        return this.privateKey;
    }
}

export { Wallet }