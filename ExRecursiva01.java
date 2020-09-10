/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laboratorio101
 */
import javax.swing.JOptionPane;

public class ExRecursiva01 {

    
    public static void main(String[] args) {
        int num=0;

        System.out.println(serie(num));

    }

    static int serie(int n) {
        int soma=0;
        if (n == 5) {
            return n;
        } else {
            soma = n+serie(n+1) ;
            return soma;
        }
    }
}