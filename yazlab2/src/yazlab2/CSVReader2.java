/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yazlab2;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

 public abstract class CSVReader2 implements Runnable {
        static String file="C:\\Users\\ervas\\OneDrive\\Masaüstü\\son\\veriler.csv";//dosya yolu
        static int k=1;//satır başlıklar olmaması için 1den başlıyoruz.
        
        
        public static String[][] method() throws FileNotFoundException{
        	
            return ReadFileIntoArray(file,7);
/*            String [] array=new String[data.length];
            String temp="";
            ArrayList <String> records=new ArrayList<>();
            for(int i=0;i<data.length;i++)//2 boyutlu dizeyi tek boyut yapma.
            {
                for(int j=0;j<6;j++)
                {
                    if(j>0)
                        temp=temp+"-"+data[i][j];
                    else
                        temp=data[i][j];
                }
                array[i]=temp;
                temp="";
              //System.out.println(array[i]);
              
                }
  */        
      // System.out.println(array[1]);
       
        }
        private static String[][] ReadFileIntoArray(String file, int i) {
            List<String>records=new ArrayList<String>();
            String delimiter=",";
            String currentLine;

            try {

                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
                while((currentLine=br.readLine())!= null) {//records listesine boş kayıt bulana kadar anlk satır yükleniyor
                    records.add(currentLine);
                }
                int recordsCount=records.size();//listenin boyutunu alıyoruz sonradan 2 boyutlu dizide birinci indisteki değerimiz olacak!!!
                
                String arrayToReturn[][]=new String[recordsCount][i];//2 boyutlu dizi tanımlaması i-->sütunu temsil etmekte
                String[]data;
                
                for(int j=0;j<recordsCount;j++) {
                    data=records.get(j).split(delimiter);
                    for(int k=0;k<data.length;k++)//, göre listeden kayıtları ayırıp sütuna göre list to 2d array yapıyoruz
                    {
                        arrayToReturn[j][k]=data[k];
                        
                        
 
                    }
                }
                
                
            
              
                return arrayToReturn;

            }
            catch(Exception e){
                e.printStackTrace();
                return null;

            }

        }
    }


