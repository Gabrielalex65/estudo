/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabri
 */
import javax.swing.JOptionPane;
public class ExRecursividade05 {

    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um valor"));
        System.out.print(serie(num));
    }

    public static int serie(int x) {
        if (x == 1) {
            return 1;
        } else {
            int fatorial = ffat(x) + serie(x - 1);
            return fatorial;
        }
    }
    public static int ffat(int n){
    if(n== 1){
        return 1;
    }
    else{
    int fat = n*ffat(n-1);
    return fat;
    }
    }
}

