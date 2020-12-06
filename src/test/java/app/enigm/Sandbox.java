package app.enigm;

import java.math.BigDecimal;

public class Sandbox {

    public static void main(String[] args) {
        BigDecimal first = new BigDecimal(127);
        BigDecimal res = first.divide(new BigDecimal(2));

        System.out.println(res);

        //Inferieur
        System.out.println(Math.floor(res.doubleValue()));

        //Superieur
        System.out.println(Math.ceil(res.doubleValue()));
    }
}
