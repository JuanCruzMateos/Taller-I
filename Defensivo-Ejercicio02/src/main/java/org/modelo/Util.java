package org.modelo;

public class Util {

    public static void esperar(int seg) {
        try {
            Thread.sleep(seg * 1000L);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
