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

public class ExRecursiva02 {

    
    public static void main(String[] args) {
        
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero desejado"));
        System.out.println(funcserie(num));

    }

    static int funcserie(int n) {
        int serie1;
        if (n == 1) {
            return 1;
        } else {
            serie1 = n+funcserie(n-1);
            return serie1;
        }
    }
}