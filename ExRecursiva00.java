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

public class ExRecursiva00 {

    
    public static void main(String[] args) {
        int num;

        num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero desejado"));
        System.out.println(ffat(num));

    }

    static int ffat(int n) {
        int fat;
        if (n == 1) {
            return 1;
        } else {
            fat = n * ffat(n - 1);
            return fat;
        }
    }
}
