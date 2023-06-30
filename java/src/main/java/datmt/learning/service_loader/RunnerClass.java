package datmt.learning.service_loader;

import datmt.learning.service_loader.service_impl.CaesarCipher;

import java.util.ServiceLoader;

public class RunnerClass {
    public static void main(String[] args) {
        ServiceLoader<Cipher> cipherServiceLoader = ServiceLoader.load(Cipher.class);
        var cipher = cipherServiceLoader.findFirst().orElse(new CaesarCipher());
        System.out.println(cipher.strength());
    }
}