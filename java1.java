public class java1 {
    public static void main(String[] args){
        String str="akash";
        String rev=" ";
        for(int i=str.length()-1 ; i>=0 ; i--){
            char c=str.charAt(i);
            rev+=c;
        }
    System.out.println(rev);
    System.out.println(rev);
    StringBuilder s= new StringBuilder();
    s.append("akash");
    System.out.println(s);
    }
}