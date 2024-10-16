package dev.jaidson.util;

import java.util.ArrayList;
import java.util.List;

public class QuestoesUtil {

    private static final int ELEITORES = 1000;
    private static final int VOTOSSVALIDOS = 800;
    private static final int VOTOSBRANCOS = 150;
    private static final int VOTOSNULOS = 50;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);
        numbers.add(7);
        numbers.add(1);
        numbers.add(0);
        numbers.add(6);
        System.out.println(numbers);
        System.out.println(bubbleSort(numbers));
        System.out.println(fatorial(5));
        System.out.println(votosBrancos());
        System.out.println(votosValidos());
        System.out.println(votosNulos());
        System.out.println(somaNumeroMutiplode3e5(10));
        System.out.printf("'%S' %n","teste");
    }
    public static List<Integer> bubbleSort(List<Integer> numeros){
        int n = numeros.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numeros.get(j) > numeros.get(i)) {
                    int aux = numeros.get(i);
                    numeros.set(i, numeros.get(j));
                    numeros.set(j, aux);
                    ++i;
                }
            }
        }
        return numeros;
    }
    public static Integer fatorial(int n) {
       if (n<0){
           throw new IllegalArgumentException("Não deve ser negativo");
       }
        if (n==0) return 1;
        return n == 1 ? 1 : n * fatorial(n - 1);


    }
    public static String votosValidos(){
        return calculPercentual(ELEITORES, VOTOSSVALIDOS);
    }
    public static String votosBrancos(){
        return calculPercentual(ELEITORES, VOTOSBRANCOS);
    }
    public static String votosNulos(){
        return calculPercentual(ELEITORES, VOTOSNULOS);
    }
    public static String calculPercentual(double denominador ,double numerador ){
        return  (numerador / denominador) * 100 + "%";
    }

    public static Integer somaNumeroMutiplode3e5(Integer numero){
        int soma =0;
        for(int i = numero;i>0 ;i--){
            if(multiploDe3(i) || multiploDe5(i) && i<numero){
                soma +=i;
            }
        }
        return soma;
    }
    public static boolean multiploDe3(Integer numero){
        return numero % 3 == 0;
    }
    public static boolean multiploDe5(Integer numero){
        return numero % 5 == 0;
    }
}
