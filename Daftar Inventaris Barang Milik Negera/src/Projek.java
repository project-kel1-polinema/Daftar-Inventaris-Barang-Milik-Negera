import java.io.BufferedWriter;
import java.io.Console;
import java.io.FileWriter;
import java.io.IOException;
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
        {'2', '2', '4'},
        {'2', '2', '4'},
        {'2', '2', '4'},
        {'2', '2', '4'},
        {'2', '2', '4'},
        {'2', '2', '4'}
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
    public void tampilData(Projek[] array) {
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < array.length; i++) {
            System.out.println("|  " + (i + 1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| "
                    + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
        }
        System.out.println(
                "+-----------------------------------------------------------------------------------------------+");
        System.out.println();
    }

    // MENGHAPUS DATA   
    public Projek[] hapusData(Projek[] array){
        int jumHapus = 0;
        for(int i=0; i<array.length; i++){
            System.out.print("Apakah anda ingin menghapus Data baris ke "+(i+1)+" (y/n): ");
            String jawab = sc.next();
            if(jawab.equalsIgnoreCase("y")){
                array[i].kode = "zzzzzzzzzzzzzzzzzzzzz";
                array[i].tahun = -1;
                array[i].nama = "zzzzzzzzzzzzzzzzzzzzzz";
                array[i].nilai = -1;
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
                for(int i=0; i<array.length; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].kode.compareToIgnoreCase(array[j+1].kode)>0){
                            operData(array, j);
                        }
                    }
                }
                break;

            case 2:
                for(int i=0; i<array.length; i++){
                    for(int j=0; j<array.length-1; j++){
                        if(array[j].tahun > array[j+1].tahun || array[j+1].tahun <= 0){
                            operData(array, j);
                        }
                    }
                }
                break;

            case 3:
                for(int i=0; i<array.length; i++){
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

    // MEMBUAT FILE .txt BUAT EXPORT
    public static void writeArrayToFile(Projek[] pj, String fileName) {
        String garis = "+====================================================================+\n";
        String atas = "| Kode BMN    | Tahun Anggaran  | Nama Barang\t\t| Nilai(Rp.) |\n";
        String penutup = "+--------------------------------------------------------------------+";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(garis);
            bufferedWriter.write(atas);
            bufferedWriter.write(garis);
            for (int i = 0; i < pj.length; i++) {
                    bufferedWriter.write("| "+pj[i].kode+"  | "+pj[i].tahun+"\t\t| "+pj[i].nama+"\t\t| "+pj[i].nilai+"    |"); //iki maksute yaopo  iku gae convert di
                    bufferedWriter.write(" ");
                bufferedWriter.newLine();
            }
            bufferedWriter.write(penutup);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    //Hitung Statistik SUM, AVG, MIN, MAX
    public void hitungStatistik(Projek[] array) {
        
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            sum += array[i].nilai;
            max = Math.max(max, array[i].nilai);
            min = Math.min(min, array[i].nilai);
        }

        double avg = (double) sum / array.length;

        System.out.println("========= STATISTIK =========");
        System.out.println("| Jumlah Data : " + array.length +" |");
        System.out.println("| Total Nilai (Rp.) : " + sum + " |");
        System.out.println("| Rata-Rata Nilai (Rp.) : " + avg + " |");
        System.out.println("| Nilai Maksimum : " + max + " |");
        System.out.println("| Nilai Minimum : " + min + " |");
        System.out.println("======================================");
    }
}
