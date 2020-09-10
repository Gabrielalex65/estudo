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

public class ExRecursiva04 {

    
    public static void main(String[] args) {
        
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero desejado"));
        int sub=1;
        System.out.println(funcserie(num,sub));

    }

    static double funcserie(double n, double x ) {
        double serie;
        if (n == 1) {
            return 1/x;
        } else {
            serie = n/x+funcserie(n-1,x+1);
            return serie;
        }
    }
}