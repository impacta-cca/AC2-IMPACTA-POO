package ac02;

import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        String Nome = "lucas";
        String Nome2= "Lucas2";
        System.out.println(Nome.matches("[a-zA-Z]+"));
        System.out.println(Nome2.matches("[a-zA-Z]+"));

        Random r = new Random();

        System.out.println(r.nextInt(9));



        }


    }




