/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fn;
import java.lang.Math; 
import java.math.BigDecimal;
import java.text.DecimalFormat;
/**
 *
 * @author Rahmans
 */
public class Sugeno {
    float R[] = new float[81];
    float Z[] = new float[81];
    
    float mLamaUsaha[]  = new float[3]; //sebentar, sedang, lama
    float mJmlPekerja[] = new float[3]; //sedikit,  sedang, banyak
    float mOmzet[]      = new float[3]; //sedikit,  sedang, banyak
    float mJmlAset[]    = new float[3]; //sedikit,  sedang, banyak
    
    float hasil       = 0;
    String HSl = "";
    
    String mInference = "";
    String LU0         = "";String LU1         = "";String LU2         = "";
    String JP0         = "";String JP1         = "";String JP2         = "";
    String OM0         = "";String OM1         = "";String OM2         = "";
    String JA0         = "";String JA1         = "";String JA2         = "";
        
    void LamaUsaha(float lamausaha){
        if(lamausaha <= 3){
            mLamaUsaha[0]=1;
            mLamaUsaha[1]=0;
            mLamaUsaha[2]=0;
            LU0 = "0";
        }else if(lamausaha > 3 && lamausaha < 5){
            mLamaUsaha[0]=(5 - lamausaha) / (5 - 1);
            mLamaUsaha[1]=(lamausaha - 3) / (5 - 3);
            mLamaUsaha[2]=0;
            //LU0 = "0";
            LU1 = "1";
        }else if(lamausaha == 5){
            mLamaUsaha[0]=0;
            mLamaUsaha[1]=1;
            mLamaUsaha[2]=0;
            LU1 = "2";
        }else if(lamausaha > 5 && lamausaha < 7){
            mLamaUsaha[0]=0;
            mLamaUsaha[1]=(7 - lamausaha) / (7 - 5);
            mLamaUsaha[2]=(lamausaha - 5) / (9 - 5);
            //LU1 = "1";
            LU2 = "3";
        }else if(lamausaha >= 7){
            mLamaUsaha[0]=0;
            mLamaUsaha[1]=0;
            mLamaUsaha[2]=1;
            LU2 = "4";
        }
    }
    void JmlPekerja(float jmlpekerja){
        if(jmlpekerja <= 10){
            mJmlPekerja[0]=1;
            mJmlPekerja[1]=0;
            mJmlPekerja[2]=0;
            JP0 = "0";
        }else if(jmlpekerja > 10 && jmlpekerja < 15){
            mJmlPekerja[0]=(15 - jmlpekerja) / (15 - 5);
            mJmlPekerja[1]=(jmlpekerja - 10) / (15 - 10);
            mJmlPekerja[2]=0;
            //JP0 = "0";
            JP1 = "1";
        }else if(jmlpekerja == 15){
            mJmlPekerja[0]=0;
            mJmlPekerja[1]=1;
            mJmlPekerja[2]=0;
            JP1 = "2";
        }else if(jmlpekerja > 15 && jmlpekerja < 20){
            mJmlPekerja[0]=0;
            mJmlPekerja[1]=(20 - jmlpekerja) / (20 - 15);
            mJmlPekerja[2]=(jmlpekerja - 15) / (25 - 15);
            //JP0 = "1";
            JP0 = "3";
        }else if(jmlpekerja >= 20){
            mJmlPekerja[0]=0;
            mJmlPekerja[1]=0;
            mJmlPekerja[2]=1;
            JP2 = "4";
        }
    }
    void Omzet(float omzet){
        if(omzet <= 1){
            mOmzet[0]=1;
            mOmzet[1]=0;
            mOmzet[2]=0;
            OM0 = "0";
        }else if(omzet > 1 && omzet < 2){
            mOmzet[0]=(2 - omzet) / (4 - 2);
            mOmzet[1]=(omzet - 1) / (2 - 1);
            mOmzet[2]=0;
            //OM0 = "0";
            OM1 = "1";
        }else if(omzet == 2){
            mOmzet[0]=0;
            mOmzet[1]=1;
            mOmzet[2]=0;
            OM1 = "2";
        }else if(omzet > 2 && omzet < 3){
            mOmzet[0]=0;
            mOmzet[1]=(3 - omzet) / (3 - 2);
            mOmzet[2]=(omzet - 2) / (4 - 2);
            //OM1 = "1";
            OM2 = "3";
        }else if(omzet >= 3.0){
            mOmzet[0]=0;
            mOmzet[1]=0;
            mOmzet[2]=1;
            OM2 = "4";
        }
    }
    void JmlAset(float jmlaset){
        if(jmlaset <= 5.0){
            mJmlAset[0]=1;
            mJmlAset[1]=0;
            mJmlAset[2]=0;
            JA0 = "0";
        }else if(jmlaset > 5 && jmlaset < 6){
            mJmlAset[0]=(6 - jmlaset) / (6 - 4);
            mJmlAset[1]=(jmlaset - 5) / (6 - 5);
            mJmlAset[2]=0;
            //JA0 = "0";
            JA1 = "1";
        }else if(jmlaset == 6){
            mJmlAset[0]=0;
            mJmlAset[1]=1;
            mJmlAset[2]=0;
            JA1 = "2";
        }else if(jmlaset > 6 && jmlaset < 7){
            mJmlAset[0]=0;
            mJmlAset[1]=(7 - jmlaset) / (7 - 6);
            mJmlAset[2]=(jmlaset - 6) / (8 - 6);
            //JA1 = "1";
            JA2 = "3";
        }else if(jmlaset >= 7.){
            mJmlAset[0]=0;
            mJmlAset[1]=0;
            mJmlAset[2]=1;
            JA2 = "4";
        }
    }
    private static DecimalFormat df2 = new DecimalFormat(".##");
    void HslKptsan(){
        LU0  =""+mLamaUsaha[0]+""; LU1  =""+mLamaUsaha[1]+""; LU2  =""+mLamaUsaha[2]+"";
        JP0  =""+mJmlPekerja[0]+"";JP1  =""+mJmlPekerja[1]+"";JP2  =""+mJmlPekerja[2]+"";
        OM0  =""+mOmzet[0]+"";     OM1  =""+mOmzet[1]+"";     OM2  =""+mOmzet[2]+"";
        JA0  =""+mJmlAset[0]+"";   JA1  =""+mJmlAset[1]+"";   JA2  =""+mJmlAset[2]+"";
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        String LUj  =""+mLamaUsaha[j]+"";
                        String JPk  =""+mJmlPekerja[k]+"";
                        String OMl  =""+mOmzet[l]+"";
                        String JAm  =""+mJmlAset[m]+"";
                        if ((LU0.equals(LUj)== false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "YA";
                        } else{
                            mInference = "LAIN";
                        }
                        System.out.println("j   = "+LUj+" k   = "+JPk+" l   = "+OMl+" m   = "+JAm);
                    }
                }
            }
        }
    }
    float getNilaiTerkecil(float a, float b, float c, float d){
        float n = 0;
        if((a < b) && (a < c) && (a < d)){
            n=a;
        }else if((b < a) && (b < c) && (b < d)){
            n=b;
        }else if((c < a) && (c < b) && (c < d)){
            n=c;
        }else if((d < a) && (d < b) && (d < c)){
            n=d;
        }else if((a == b) && (a == c) && (a == d)){
            n=a;
        }
        return n;
    }
    public void inference(){
        int i = 0;
        LU0  =""+mLamaUsaha[0]+""; LU1  =""+mLamaUsaha[1]+""; LU2  =""+mLamaUsaha[2]+"";
        JP0  =""+mJmlPekerja[0]+"";JP1  =""+mJmlPekerja[1]+"";JP2  =""+mJmlPekerja[2]+"";
        OM0  =""+mOmzet[0]+"";     OM1  =""+mOmzet[1]+"";     OM2  =""+mOmzet[2]+"";
        JA0  =""+mJmlAset[0]+"";   JA1  =""+mJmlAset[1]+"";   JA2  =""+mJmlAset[2]+"";
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    for (int m = 0; m < 3; m++) {
                        String LUj  =""+mLamaUsaha[j]+"";
                        String JPk  =""+mJmlPekerja[k]+"";
                        String OMl  =""+mOmzet[l]+"";
                        String JAm  =""+mJmlAset[m]+"";
                        
                        R[i]=this.getNilaiTerkecil(mLamaUsaha[j], mJmlPekerja[k], mOmzet[l], mJmlAset[m]);
                        //HslKptsan();
                        
                        if ((LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "YA";
                        } else if ((LU0.equals(LUj) == false) && (LU1.equals(LUj) == true) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "YA";
                        } else if ((JP0.equals(JPk)== false) &&(LU0.equals(LUj) == false) && (JP1.equals(JPk)== true) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "YA";
                        } else if ((OM0.equals(OMl)== false) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM1.equals(OMl)== true) && (JA0.equals(JAm)== false)){
                            mInference = "YA";
                        } else if ((JA0.equals(JAm)== false) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA1.equals(JAm)== true)){
                            mInference = "YA";
                        } else 
                            if ((LU0.equals(LUj) == true) && (LU1.equals(LUj) == true) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((JP0.equals(JPk)== true) &&(LU0.equals(LUj) == false) && (JP1.equals(JPk)== true) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((OM0.equals(OMl)== true) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM1.equals(OMl)== true) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((JA0.equals(JAm)== true) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA1.equals(JAm)== true)){
                            mInference = "TUNDA";
                        } else 
                            if ((LU0.equals(LUj) == true) && (LU1.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((JP0.equals(JPk)== true) &&(LU0.equals(LUj) == false) && (JP1.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((OM0.equals(OMl)== true) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM1.equals(OMl)== false) && (JA0.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else if ((JA0.equals(JAm)== true) &&(LU0.equals(LUj) == false) && (JP0.equals(JPk)== false) && (OM0.equals(OMl)== false) && (JA1.equals(JAm)== false)){
                            mInference = "TUNDA";
                        }else{
                            mInference = "TIDAK";
                        }
                        
                        
                        
                        
                        
                        if(mInference.equals("TIDAK")){
                            Z[i]= Math.abs((R[i] * 25) - 50);
                        }else if(mInference.equals("YA")){
                            Z[i]= Math.abs((R[i] * 25) + 50);
                        }else if(mInference.equals("TUNDA")){
                            Z[i]= ((Math.abs((R[i] * 25) + 25)) + (Math.abs((R[i] * 25) - 75)))/ 2;
                            R[i]= (R[i] + R[i]);
                        }
                        System.out.println(i+". "+mInference+"  "+mLamaUsaha[j]+"  "+mJmlPekerja[k]+"  "+mOmzet[l]+"  "+mJmlAset[m]);
                        i = i+1;
                        //System.out.println(i+". R = "+R[i]+" Z = "+Z[i]);
                    }
                }
            }
        }
    }
    void defuzzyfikasi(){
        float hasiltest   = 0;
        float pembagi     = 0;
        float has     = 0;
        //Main m = new Main();
        for (int i = 0; i < 81; i++) {
            hasiltest   = R[i] * Z[i];
            pembagi     = R[i] + pembagi;
            hasil = hasiltest + hasil;
            
            System.out.println(i+". R = "+R[i]+" Z = "+Z[i]+" Hasil   = "+hasil);
            
            Main.taInference.append(" R"+i+" = "+R[i]+" Z"+i+" = "+Z[i]+"\n");
        }
        has = hasil;
        hasil = hasil / pembagi;
        System.out.println("Hasil   = "+hasil);
        System.out.println("Z+++ = "+pembagi);
        
        Main.taInference.append(" Z = "+has+" / "+pembagi+" = "+hasil+"\n\n");
        Main.taInference.append(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
        
        if (hasil <= 25) {
            HSl = "TIDAK";
        }else if (hasil <= 50){
            HSl = "TUNDA";
        }else if (hasil > 50){
            HSl = "YA";
        }
    }
}
