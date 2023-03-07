/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab2;

import java.util.ArrayList;
import java.util.Arrays;
import static yazlab2.NewJFrame.benzerlikBul;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class MyThread extends Thread implements Runnable{

    public static String[][] data;
    public static int secim;

    private List<Benzerlik> benzerlikSonuclar = new ArrayList<>();
    private double minBenzerlik;


    public double getMinBenzerlik() {
        return minBenzerlik;
    }

    public void setMinBenzerlik(double minBenzerlik) {
        this.minBenzerlik = minBenzerlik;
    }

    public List<Benzerlik> getBenzerlikSonuclar() {
        return benzerlikSonuclar;
    }

    public void setBenzerlikSonuclar(List<Benzerlik> benzerlikSonuclar) {
        this.benzerlikSonuclar = benzerlikSonuclar;
    }


  
    
    @Override
    public void run() {
     
        int a=1;
       switch(this.secim){
           case 1:
                 for (int i = 0; i < 100; i++) {
                String kayit1 =data[i][1];
          
             for (int j = i+1; j < 100; j++) {
                  String kayit2 =data[j][1];
                  
                    double benzerlik = benzerlikBul(kayit1,kayit2);
                   if(benzerlik>=minBenzerlik){
                    benzerlikSonuclar.add(new Benzerlik(kayit1,kayit2,benzerlik));
                  }   
             }
        }
              break;
               case 2 :
               // System.out.println("senaryo2  (Product) için % 70 ve üzeri benzerlikteki konuları \n" +
//"(Issue) içeren Şirket (Company) isimlerini ekranda gösteriniz.");
                
                  for (int i = 0; i < 10000; i++) {
                String product1 =data[i][1];
                String issue1 = data[i][2];
                String company1=data[i][3];
          
             for (int j = i+1; j < 10000; j++) {
                  String product2 =data[j][1];
                  String issue2 = data[j][2];
                  String company2=data[j][3];
                 double b1 =benzerlikBul(product1,product2) ;
                  if( b1>= 100){
                      double b2 =benzerlikBul(issue1,issue2) ;
                      if(b2>=20){
                          System.out.println(product1 + " = "+ issue1 + "ve" + issue2 + " =  " + b2+company1+"/"+company2);
                      }
                  }

             }
        }
                
              break;
               case 3 :
              //  System.out.println("senaryo3  ‘Complaint Id’ = 3198084 olan şikayet kaydı için % 50 ve üzeri \n" +
//"benzerlikteki konuları (issue)");
       
                for (int i = 0; i<data.length; i++) {
                String kayit1 =data[i][6];
                String id= new String("3198084");
               // String id="3198084";
                  if(kayit1.equals(id)){
                        for (int k = 0; i < 1000; i++) {
                        String issue1 =data[k][2];
                            for (int j = 0; j <10000; j++) {
                                 String issue2 =data[j][2];
                                 double benzerlik = benzerlikBul(issue1,issue2);
                                  if(benzerlik>=50){
                                      System.out.println(benzerlik+ issue1+"/"+issue2);
                                  } 
                               
                            }
                        }
                    }
                   
                  
                }
                
              break;
               case 4:
               // System.out.println("senaryo4 : 5 Thread ile Konular(Issue) sütununda %80 ve üzeri benzer olan kayıtlar ");
                
                 for (int i = 0; i < 10; i++) {
                String kayit1 =data[i][2];
          
             for (int j = i+1; j < 10; j++) {
                  String kayit2 =data[j][2];
                  
                    double benzerlik = benzerlikBul(kayit1,kayit2);
                   if(benzerlik>80){
                    System.out.println(benzerlik+ kayit1+"/"+kayit2);
                  }   
             }
        }
                
                
              break;
              
       }
              
        long baslangiczamani=System.currentTimeMillis();
        long calismasuresi = System.currentTimeMillis()-baslangiczamani;
         System.out.println("thread çalışma süreleri"+calismasuresi);
      
}

}