package com.ghk.vize.vizeproje;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;
import java.io.*;


@Controller
@RestController
public class VizeController{

    @GetMapping("/")
    public String bilgilerim(){
        return "GÖKMEN HAKAN KARAGÖZ www.gokmenhakan.com";
    }
    // http://localhost:8080/soru1?s=maven kismini nasi unuturum... bunu test etmek için çalıştırdıktan sonra buna git

    @GetMapping("/soru1")
    public List<String> soru1(@RequestParam String cumle){
        String[] bol=cumle.split(" ");
        List<String> liste=new ArrayList<>();
        for(String i:bol){
            liste.add(i);
        }
        return liste;
    }

    @GetMapping("/soru2")
    public String soru2(@RequestParam String cumle){
        String[] bol=cumle.split(" ");
        List<String> liste=new ArrayList<>();
        for(String i:bol){
            liste.add(i);
        }
        int enbuyuk=0,index=0;
        for(int i=0;i<liste.size();i++)
        {
            if(liste.get(i).length() > enbuyuk){
                enbuyuk=liste.get(i).length();
                index=i;
            }
        }
        String cevap="Kelime = "+liste.get(index)+" Uzunluğu "+enbuyuk;
        return cevap;
    }

    @GetMapping("/soru3")
    public String soru3(@RequestParam int sayi){
        String cevirilecek=""+sayi;
        String cevirilmis="";
        for(int i=(cevirilecek.length()-1);i>=0;i--){
            cevirilmis+=cevirilecek.charAt(i);
        }
        return cevirilmis;
    }

    @GetMapping("/soru4")
    public List<int[]> soru4(@RequestParam int sayi){
        int[] dizi=new int[sayi];
        Random random=new Random();
        for(int i=0;i<dizi.length;i++){
            dizi[i]=random.nextInt(9);
        }

        int ciftler=0,tekler=0;
        int[] sifirsiz=new int[sayi];
        for(int j=0;j<sifirsiz.length;j++){
            sifirsiz[j]=dizi[j];
        }//otomatik şekilde eşitlediğimde bu sefer 0 barındıran ana dizimdeki sayılar da değişmeye başladı
        //ben de bu yüzden bu şekilde manuel bir atama gerçekleştirerek bunun önüne geçtim

        for(int i=0;i<sifirsiz.length;i++){
            if(sifirsiz[i]==0){
                sifirsiz[i] = random.nextInt(9)+1;//0'sız atama için +1 methodunu kullandım
            }
            if(sifirsiz[i]%2==0){ciftler++;}//tek ve çift sayı dizisini oluşturabilmem için gerekli olan eleman sayısını
            if(sifirsiz[i]%2!=0){tekler++;}//bu şekilde sayaçlar koyarak elde ettim
        }

        int[] tek=new int[tekler];
        int[] cift=new int[ciftler];
        int i=0,tindex=0,cindex=0;
        while(i<sifirsiz.length){
            if(sifirsiz[i]%2==0){cift[cindex]=sifirsiz[i];cindex++;}
            if(sifirsiz[i]%2!=0){tek[tindex]=sifirsiz[i];tindex++;}
            i++;
        }
        //bunları hepsi adında tek bir listeye atıp öyle döndürdüm
        //hepsi = ana dizimiz(0'lı olan) > tekler > çiftler
        List<int[]> hepsi=new ArrayList<int[]>();
        hepsi.add(dizi);
        hepsi.add(tek);
        hepsi.add(cift);

        return hepsi;
    }


    @GetMapping("/soru5")
    public String soru5(@RequestParam double taban,@RequestParam double yukseklik){
        //silindirin hacmini hespalamak için v= (1/3) * π * r² * h formülünü kullandım.
        double hacim=yukseklik*taban*taban*Math.PI*1/3;
        double yuvarlanmisv= Math.ceil(hacim);
        String v=new DecimalFormat("##.##").format(yuvarlanmisv);//virgülden sonraki 2 haneyi aldım fakat yuvarladığımız için o haneler yok
        return v;
    }


    @GetMapping("/soru6")
    public String soru6(@RequestParam int i) throws IOException {
        String dosyadi="faktoriyel.txt";
        FileWriter yazan = new FileWriter(dosyadi);
        //yazan.write("deneme");
        try{
        int faktoriyel=1;
        for(int a=1; a<=i ; a++) {
            for (int j = 1; j <= a; j++) {
                faktoriyel = faktoriyel * j;
            }
            yazan.write(""+faktoriyel+"\n");
            faktoriyel=1;
        }
        yazan.close();
        return "Başarılı | Belge Konumu -> "+System.getProperty("user.dir")+"\\"+dosyadi;
        }catch (Exception e){
            return "Başarısız! | Belge Konumu -> "+System.getProperty("user.dir")+"\\"+dosyadi;
        }

    }

}