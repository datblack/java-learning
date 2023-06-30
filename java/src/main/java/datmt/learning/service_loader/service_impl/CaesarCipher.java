package datmt.learning.service_loader.service_impl;

import datmt.learning.service_loader.Cipher;

public class CaesarCipher implements Cipher {
    @Override
    public byte[] encrypt(byte[] source, byte[] key) {
        return new byte[0];
    }

    @Override
    public byte[] decrypt(byte[] source, byte[] key) {
        return new byte[0];
    }

    @Override
    public int strength() {
        return 0;
    }
}
