
package jogoguerreirovsinimigos;

import java.util.Random;

public class Util {
    public static double gerarNumAleatorio(double min, double max){
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }
}
