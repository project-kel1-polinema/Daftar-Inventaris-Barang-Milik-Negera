public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String a = "a";
        String A = "A";
        String ab = "ab";
        String b = "b";
        String B = "B";
        String ba = "ba";
        String z = "z";

        System.out.println("a".compareToIgnoreCase("s"));
        System.out.println(a.compareTo(z));
        System.out.println(z.compareTo(a));
        System.out.println(a.compareTo(b));
        System.out.println(ab.compareTo(b));
        System.out.println(A.compareToIgnoreCase(b));
        System.out.println(a.compareTo(ab));
        System.out.println(ab.compareTo(a));
        System.out.println(b.compareTo(a));
        System.out.println(b.compareTo(A));
        System.out.println(b.compareTo(ab));

    }
    
    /* public void urutData2(Projek[] array, String kataKunci){
        Arrays.sort(array, Comparator.comparing((Projek p) -> p.kode.equalsIgnoreCase(kataKunci)).thenComparing(p -> p.kode, String.CASE_INSENSITIVE_ORDER));   
    } */
}
