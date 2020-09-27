package utils;

import java.util.ArrayList;
import java.util.List;

public class Qgrams {
    private static String fillTokens(String str,int n){
        StringBuilder str1=new StringBuilder();
        int i;
        for(i=0;i<n-1;i++){
            str1.append('*');
        }
        str1.append(str.toUpperCase());
        for(i=0;i<n-1;i++){
            str1.append('*');
        }
        return str1.toString();
    }
    public static List<String> ngrams(int n, String str) {
        String strtouse=fillTokens(str,n);
        List<String> ngrams=new ArrayList<>();
        for (int i = 0; i < strtouse.length() - n + 1; i++) {
            ngrams.add(strtouse.substring(i, i + n));
        }
        return ngrams;
    }
    public static double similarity(String str1,String str2,int n) {
        List<String> ngramsstr1 = ngrams(n, str1);
        List<String> ngramsstr2 = ngrams(n, str2);
        List<String> auxlist = new ArrayList<>();
        for (String aux : ngramsstr1) {
            if (ngramsstr2.contains(aux) && (!auxlist.contains(aux)))
                auxlist.add(aux);
        }
        int similarityresult = ngramsstr1.size() + ngramsstr2.size() - (ngramsstr1.size() + ngramsstr2.size() - 2 * auxlist.size());
        return (double) similarityresult / (ngramsstr1.size() + ngramsstr2.size());
    }
}