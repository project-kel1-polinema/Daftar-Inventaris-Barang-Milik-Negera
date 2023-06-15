import java.io.Console;
import java.util.Arrays;
import java.util.Scanner;


public class Projek {
    
    static Scanner sc = new Scanner(System.in);
    public int nilai, tahun, tempNilai, tempTahun, indeksTambah;
    public String nama, kode, tempNama, tempKode;
    public char[] password;
    String username;
    public String[] user = {"Agung", "Dona", "Aldi", "Rafli", "Naura", "Zaidan"};
    public char[][] passwords = {
        {'2', '2', '4', '1', '7', '6', '0', '1', '3', '5'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'},
        {'2', '2', '4', '1', '7', '6', '0'}
    };
    
    // CONSTRUCTOR
    public Projek(String kode,int tahun, String nama, int nilai){
        this.kode = kode;
        this.tahun = tahun;
        this.nama = nama;
        this.nilai = nilai;
    }

    // LOGIN
    public void login(){
        do{
            Console console = System.console();
            if (console == null) {
                System.err.println("Console tidak tersedia");
                System.exit(1);
            }

            username = console.readLine("Masukkan username: ");
            password = console.readPassword("Masukkan password: ");
        
            if (login(username, password)) {
                System.out.println("Login berhasil");
                System.out.println();
                break;
            } else {
                System.out.println("Login gagal");
            }
        }while(!login(username, password));
        
    }

    //LOGIN
    public boolean login(String username, char[] password) {
        for (int i = 0; i < user.length; i++) {
            if (username.equals(user[i]) && Arrays.equals(password, passwords[i])) {
                Arrays.fill(password, ' ');
                return true;
            }
        }
        Arrays.fill(password, ' ');
        return false;
    }
    
    // MENAMPILKAN DATA
    public void tampilData(Projek[] array){
        System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
        for(int i=0; i<array.length; i++){
            System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
        }
    }

    // MENGHAPUS DATA   
    public Projek[] hapusData(Projek[] array){
        int jumHapus = 0;
        for(int i=0; i<array.length; i++){
            System.out.print("Apakah anda ingin menghapus Data baris ke "+(i+1)+" (y/n): ");
            String jawab = sc.next();
            if(jawab.equalsIgnoreCase("y")){
                array[i].kode = "Dihapus";
                array[i].tahun = 0;
                array[i].nama = "Dihapus";
                array[i].nilai = 0;
                jumHapus += 1;
            }
        }
        array[0].urutDataDefault(array);
        Projek[] arrayBaruHapus = new Projek[array.length-jumHapus];
        System.arraycopy(array, 0, arrayBaruHapus, 0, array.length-jumHapus);
        return arrayBaruHapus;
    }

    // MENGURUTKAN DATA TAPI YANG DEFAULTNYA, INI BUAT METHOD HAPUS AJA SUPAYA NDAK ERROR
    public void urutDataDefault(Projek[] array){
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j].kode.compareTo(array[j+1].kode)>0){
                    operData(array, j);
                }
            }
        }
    }

    // MENGURUTKAN DATA BERDASARKAN PILIHAN
    public Projek[] urutData(Projek[] array){
        System.out.println("=====MENU MENGURUTKAN=====");
        System.out.print("Urut Berdasarkan\n1. Kode Barang\n2. Tahun Barang\n3. Nama Barang\n4. Nilai\nPilih (1/2/3/4): ");
        int pilihan = sc.nextInt();
        switch(pilihan){
            case 1:
                for(int i=0; i<array.length-1; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].kode.compareToIgnoreCase(array[j+1].kode)>0){
                            operData(array, j);
                        }
                    }
                }
                break;

            case 2:
                for(int i=0; i<array.length-1; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].tahun > array[j+1].tahun || array[j+1].tahun <= 0){
                            operData(array, j);
                        }
                    }
                }
                break;

            case 3:
                for(int i=0; i<array.length-1; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].nama.compareToIgnoreCase(array[j+1].nama)>0){
                            operData(array, j);
                        }
                    }
                }
                break;

            case 4:
                for(int i=0; i<array.length; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].nilai > array[j+1].nilai || array[j+1].nilai <= 0){
                            operData(array, j);
                        }
                    }
                }
                break;

            default:
                System.out.println("Menu yang anda pilih tidak tersedia");
                break;

        }
        return array;
    }

    // BUAT PINDAH DATANYA
    public void operData(Projek[] array, int j){
        tempKode = array[j].kode;
        array[j].kode = array[j+1].kode;
        array[j+1].kode = tempKode;
                    
        tempNama = array[j].nama;
        array[j].nama = array[j+1].nama;
        array[j+1].nama = tempNama;

        tempTahun = array[j].tahun;
        array[j].tahun = array[j+1].tahun;
        array[j+1].tahun = tempTahun;
                    
        tempNilai = array[j].nilai;
        array[j].nilai = array[j+1].nilai;
        array[j+1].nilai = tempNilai;
    }

    // MENAMBAH DATA
    public Projek[] tambahData(Projek[] array){
        indeksTambah = array.length;
        System.out.print("Masukkan jumlah data yang ingin dimasukkan: ");
        int jumlahData = sc.nextInt();
        int tambahPanjang = array.length + jumlahData; 
        Projek[] arrayBaruTambah = new Projek[tambahPanjang];
        System.arraycopy(array, 0, arrayBaruTambah, 0, array.length);
        array = arrayBaruTambah;
        System.out.println();
        return arrayBaruTambah;
    }

    // MENGISI DATA
    public void isiDariTambah(Projek[] array){
        for(int i=indeksTambah; i<array.length;i++){
            System.out.println("Masukkan data dari array ke "+(i+1)+" : ");
            System.out.print("Masukkan Kode Barang: ");
            sc.nextLine();
            String code = sc.nextLine().toUpperCase();
            System.out.print("Masukkan Tahun Barang: ");
            int year = sc.nextInt();
            System.out.print("Masukkan Nama Barang: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Masukkan Nilai Barang: ");  
            int value = sc.nextInt();
            array[i] = new Projek(code, year, name, value);
        }
    }

    // MENCARI DATA
    public void cariData(Projek[] array){
        System.out.println("=====MENU PENCARIAN=====");
        System.out.print("Cari Berdasarkan\n1. Kode Barang\n2. Tahun Barang\n3. Nama Barang\n4. Nilai\nPilih (1/2/3/4): ");
        int pilihan = sc.nextInt();
        int gagal = 0;
        System.out.println("=======CARI DATA BARANG BMN=======");
        switch(pilihan){
            // BERDASARKAN KODE BARANG
            case 1:
            System.out.print("Masukkan Kode Barang: ");
            sc.nextLine();
            String code = sc.nextLine();
            System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
            for(int i=0; i<array.length; i++){
                if(code.equalsIgnoreCase(array[i].kode)){
                    System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
                } else{
                    gagal += 1;
                }
            }
            break;
            
            // BERDASARKAN TAHUN BARANG
            case 2:
            System.out.print("Masukkan Tahun Barang: ");
            int tahun = sc.nextInt();
            System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
            for(int i=0; i<array.length; i++){
                if(tahun == array[i].tahun){
                    System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
                } else{
                    gagal += 1;
                }
            }
            break;
            
            // BERDASARKAN NAMA BARANG
            case 3:
            System.out.print("Masukkan Nama Barang: ");
            sc.nextLine();
            String nama = sc.nextLine();
            System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
            for(int i=0; i<array.length; i++){
                if(nama.equalsIgnoreCase(array[i].nama)){
                    System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
                } else{
                    gagal += 1;
                }
            }
            break;

            // BERDASARKAN NILAI BARANG
            case 4:
            System.out.print("Masukkan Nilai Barang: ");
                int nilai = sc.nextInt();
                System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
                for(int i=0; i<array.length; i++){
                    if(nilai==array[i].nilai){
                        System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
                    } else{
                        gagal += 1;
                    }
                }
                break;

            default:
                System.out.println("Menu yang anda pilih tidak tersedia");
                break;
        }

        if(gagal == array.length){
            System.out.println("Data yang anda cari tidak ada");
        }
    }

    //Hitung Statistik SUM, AVG, MIN, MAX
    // JUMLAH
    public static int hitungSum(int[] nilai) {
        int sum = 0;
        for ( int num : nilai) {
            sum += num;
        }
        return sum;
    }

    // Rata-Rata
    public static double hitungAvg(int[] nilai) {
        int sum = hitungSum(nilai);
        double avg = ((double)(sum))/nilai.length;
        return avg;
    }

    // NILAI MAKSIMAL
    public static int hitungMax(int[] nilai) {
        int max = nilai[0];
        for (int i = 1; i < nilai.length; i++) {
            if (nilai[i] > max) {
                max = nilai[i];
            }
        }
        return max;
    }

    // NILAI MINIMAL
    public static int hitungMin(int[] nilai) {
        int min = nilai[0];
        for (int i = 0; i < nilai.length; i++) {
            if (nilai[i] < min) {
                min = nilai[i];
            }
        }
        return min;
    }
}
