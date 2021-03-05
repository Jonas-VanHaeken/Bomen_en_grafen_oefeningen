import java.util.ArrayList;
import java.util.List;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal<=0){
            throw new IllegalArgumentException();
        }
        if (getal ==1 || getal==2){
            return 1;
        }
        return fibonacci(getal-1) + fibonacci(getal-2);
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        getal = Math.abs(getal);
        if(getal<10){
            return getal;
        }
        int digit = (getal%10);
        return digit + somVanCijfers(getal/10);

    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        String res = "";
        if (s==null){ throw new IllegalArgumentException();}
        if (s.isBlank()) return s;
        if (s.length() == 1) {
            return s;
        }
        res += s.substring(s.length()-1);
        String rest = s.substring(0,s.length()-1);
        return res + keerOm(rest);
    }

    //oefening 4: countX

    public static int countX(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length()==0){
            return 0;
        }
        String eersteLetter = s.substring(0,1);
        String rest = s.substring(1,s.length());
        if (eersteLetter.equals("x") || eersteLetter.equals("X")){
            return 1 + countX(rest);
        }
        else {
            return countX(rest);}
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) {
            throw new IllegalArgumentException();
        }
        if (s.length()<2){
            return 0;
        }
        String eersteLetters = s.substring(0,2);
        String rest = s.substring(1,s.length());
        if (eersteLetters.equals("hi")){
            return 1 + countHi(rest);
        }
        else {
            return countHi(rest);}
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.length()==0){
            return "";
        }
        String eersteLetter = s.substring(0,1);
        String rest = s.substring(1,s.length());
        if (eersteLetter.equals("x")){
            return "y" + changeXY(rest);
        }
        return eersteLetter + changeXY(rest);
    }

    // oefening 7

    public static String changePi(String s) {
        if (s==null) throw new IllegalArgumentException();
        if (s.length()<2){
            return s;
        }
        String eersteLetters = s.substring(0,2);
        String rest = s.substring(1,s.length());
        if (eersteLetters.equals("pi")){
            return "3.14" + changePi(s.substring(2,s.length()));
        }
        return eersteLetters.substring(0,1) + changePi(rest);
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal<=0) throw new IllegalArgumentException();
        if (getal==1){
            return 0;
        }
        return 1 + tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null || lijst.isEmpty()) throw new IllegalArgumentException();
        if (lijst.size()==1){
            return lijst.get(0);
        }
        List <Double> rest = lijst.subList(1,lijst.size());
        return Math.max(lijst.get(0),findMaximum(rest));
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        if (string==null) throw new IllegalArgumentException();
        ArrayList<String> strings = new ArrayList<>();
        if (string.trim().isEmpty()){
            strings.add(string);
        }
        if (string.length() == 1){
            strings.add(string);
        }
        else {
            for (int i = 0; i < string.length(); i++) {
                for (int j = i+1; j <= string.length(); j++) {
                    strings.add(string.substring(i,j));

                }
            }
        }
        return strings;
    }


    //oefening 11;
    public static int aantalKaarten(int n){
        if (n==0){
            return 0;
        }
        return n*2 + n-1 + aantalKaarten(n-1);
    }

}