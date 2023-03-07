/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab2;

import java.util.ArrayList;
import java.util.Arrays;
import static yazlab2.NewJFrame.benzerlikBul;

/**
 *
 * @author ervas
 */
public class multi implements Runnable{

    public static String[][] data;
  
    
    @Override
    public void run() {
        
         String kayit1 =data[1][2];
          String kayit2 =data[6][2];
          
           System.out.println(kayit1);
            System.out.println(kayit2);
           System.out.println(benzerlikBul(kayit1,kayit2));
              
                
           
        long baslangiczamani=System.currentTimeMillis();
        for(int j=0;j<3;j++)
        {    
        }
        long calismasuresi = System.currentTimeMillis()-baslangiczamani;
         System.out.println("thread çalışma süreleri");
        System.out.println(calismasuresi);
}

}