import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Projek {
    
    // ATTRIBUTE
    public Scanner sc = new Scanner(System.in);
    public int nilai, tahun, tempNilai, tempTahun, indeksTambah;
    public String nama, kode, tempNama, tempKode;
    public List<Projek> riwayatHapus = new ArrayList<>();
    public ArrayList<Projek> riwayat = new ArrayList<>();
    public List<Projek> riwayatTambah = new ArrayList<>();

    
    // CONSTRUCTOR
    public Projek(String kode,int tahun, String nama, int nilai){
        this.kode = kode;
        this.tahun = tahun;
        this.nama = nama;
        this.nilai = nilai;
    }
    
    // MENAMPILKAN DATA
    public void tampilData(Projek[] array) {
        System.out.println("");
        System.out.println("============================  Daftar Inventaris Barang Milik Negera  ============================");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
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

    // MENCARI DATA
    public void cariData(Projek[] array){
        System.out.println("");
        System.out.println("=========================================  Cari Data  ===========================================");
        System.out.print("Cari Berdasarkan:\n1. Kode Barang\n2. Tahun Barang\n3. Nama Barang\n4. Nilai\n5. Kembali\nPilih (1/2/3/4/5): ");
        int pilihan = sc.nextInt();
        int gagal = 0;
        switch(pilihan){
            // BERDASARKAN KODE BARANG
            case 1:
                System.out.print("Masukkan kode barang: ");
                sc.nextLine();
                String code = sc.nextLine();
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                for(int i=0; i<array.length; i++){
                    if(code.equalsIgnoreCase(array[i].kode)){
                        System.out.println("|  " + (i+1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| " + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
                    } else{
                        gagal += 1;
                    }
                }
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println();
                break;
            
            // BERDASARKAN TAHUN BARANG
            case 2:
                System.out.print("Masukkan tahun barang: ");
                int tahun = sc.nextInt();
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                for(int i=0; i<array.length; i++){
                    if(tahun == array[i].tahun){
                        System.out.println("|  " + (i+1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| " + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
                    } else{
                        gagal += 1;
                    }
                }
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println();
                break;
            
            // BERDASARKAN NAMA BARANG
            case 3:
                System.out.print("Masukkan nama barang: ");
                sc.nextLine();
                String nama = sc.nextLine();
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                for(int i=0; i<array.length; i++){
                    if(nama.equalsIgnoreCase(array[i].nama)){
                        System.out.println("|  " + (i+1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| " + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
                    } else{
                        gagal += 1;
                    }
                }
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println();
                break;

            // BERDASARKAN NILAI BARANG
            case 4:
                System.out.print("Masukkan nilai barang: ");
                int nilai = sc.nextInt();
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                for(int i=0; i<array.length; i++){
                    if(nilai==array[i].nilai){
                        System.out.println("|  " + (i+1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| " + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
                    } else{
                        gagal += 1;
                    }
                }
                System.out.println("+-----------------------------------------------------------------------------------------------+");
                System.out.println();

                break;
            
            case 5:
                System.out.println();
                break;

            default:
                System.out.println("Menu yang Anda pilih tidak tersedia.");
                System.out.println();
                break;
        }

        if(gagal == array.length){
            System.out.println("Data yang Anda cari tidak ada.");
            System.out.println();
        }
    }

    // MENAMBAH DATA
    public Projek[] tambahData(Projek[] array){
        indeksTambah = array.length;
        System.out.println();
        System.out.println("=========================================  Tambah Data  ===========================================");
        System.out.print("Masukkan jumlah data yang ingin ditambahkan: ");
        int jumlahData = sc.nextInt();
        int tambahPanjang = array.length + jumlahData; 
        Projek[] arrayBaruTambah = new Projek[tambahPanjang];
        System.arraycopy(array, 0, arrayBaruTambah, 0, array.length);
        array = arrayBaruTambah;
        return arrayBaruTambah;
    }

    // MENGISI DATA
    public void isiDariTambah(Projek[] array) {
    for (int i = indeksTambah; i < array.length; i++) {
        System.out.println("~Barang ke-" + (i + 1));
        System.out.print("Masukkan kode barang: ");
        sc.nextLine();
        String code = sc.nextLine().toUpperCase();
        System.out.print("Masukkan tahun barang: ");
        int year = sc.nextInt();
        System.out.print("Masukkan nama barang: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("Masukkan nilai barang: ");
        int value = sc.nextInt();
        array[i] = new Projek(code, year, name, value);

        // Membuat objek baru untuk menyimpan data ke dalam riwayatTambah
        Projek riwayatDataTambah = new Projek(code, year, name, value);
        riwayat.add(riwayatDataTambah);
        riwayatTambah.add(riwayatDataTambah); // Menambahkan data yang baru ditambahkan ke dalam riwayatTambah
        System.out.println();
    }
    if (array.length > indeksTambah) {
        System.out.println("Data berhasil ditambahkan.");
    }
    System.out.println();
}
    
    // MENGHAPUS DATA
    public Projek[] hapusData(Projek[] array) {
        System.out.println();
        System.out.println("=========================================  Hapus Data  ===========================================");
        int jumHapus = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print("Apakah anda ingin menghapus data baris ke " + (i + 1) + " (y/n): ");
            String jawab = sc.next();
            if (jawab.equalsIgnoreCase("y")) {
                Projek dataHapus = new Projek(array[i].kode, array[i].tahun, array[i].nama, array[i].nilai);
                riwayatHapus.add(dataHapus); // Menyimpan data yang dihapus ke dalam riwayatHapus
                array[i].kode = "zzzzzzzzzzzzzzzzzzzzz";
                array[i].tahun = -1;
                array[i].nama = "zzzzzzzzzzzzzzzzzzzzzz";
                array[i].nilai = -1;
                jumHapus += 1;
            }
        }
        array[0].urutDataDefault(array);
        Projek[] arrayBaruHapus = new Projek[array.length - jumHapus];
        System.arraycopy(array, 0, arrayBaruHapus, 0, array.length - jumHapus);
        return arrayBaruHapus;
    }

    // MENGURUTKAN DATA BERDASARKAN PILIHAN
    public Projek[] urutData(Projek[] array){
        System.out.println();
        System.out.println("=========================================  Urut Data  ===========================================");
        System.out.print("Urut Berdasarkan\n1. Kode Barang\n2. Tahun Barang\n3. Nama Barang\n4. Nilai\n5. Kembali\nPilih (1/2/3/4/5): ");
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
            
            case 5:
                break;

            default:
                System.out.println("Menu yang anda pilih tidak tersedia");
                break;

        }
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        for (int i = 0; i < array.length; i++) {
            System.out.println("|  " + (i + 1) + " | " + array[i].kode + "\t| " + array[i].tahun + "\t\t\t| "
                    + array[i].nama + "       \t\t| " + array[i].nilai + "\t|");
        }
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println();
        return array;
    }

    // BUAT PINDAH DATA
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
    
    // MENGURUTKAN DATA TAPI YANG DEFAULTNYA, INI BUAT METHOD HAPUS AJA SUPAYA TIDAK ERROR
    public void urutDataDefault(Projek[] array){
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1; j++){
                if(array[j].kode.compareTo(array[j+1].kode)>0){
                    operData(array, j);
                }
            }
        }
    }
    
    // HITUNG STATISTIK DATA
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
        System.out.println();
        System.out.println("-----------  Statistik Data  ------------");
        System.out.println("| Jumlah Data     : " + array.length +"\t\t\t|");
        System.out.println("| Total Nilai     : " + sum + "          \t|");
        System.out.println("| Rata-Rata Nilai : " + avg + "          \t|");
        System.out.println("| Nilai Maksimum  : " + max + "          \t|");
        System.out.println("| Nilai Minimum   : " + min + "          \t|");
        System.out.println("-----------------------------------------");
        System.out.println();
    }
    
    // RIWAYAT PERUBAHAN DATA (TAMBAH)
    public void tampilRiwayatTambah() {
        System.out.println("==== Riwayat Perubahan Data ====");
        if (riwayatTambah.isEmpty()) {
            System.out.println("Tidak ada riwayat data yang ditambahkan");
            System.out.println();
        }else {
            for (int i = 0; i < riwayatTambah.size(); i++) {
                Projek data = riwayatTambah.get(i);
                System.out.println();
                System.out.println("Penambahan data ke-" + (i + 1));
                System.out.println("Kode BMN: " + data.kode);
                System.out.println("Tahun Anggaran: " + data.tahun);
                System.out.println("Nama Barang: " + data.nama);
                System.out.println("Nilai: " + data.nilai);
                System.out.println();
            }
        }
    }

    // MENAMPILKAN RIWAYAT (HAPUS)
    public void tampilRiwayatHapus() {
        System.out.println();
        System.out.println("==================================  Riwayat Data Yang Dihapus  ==================================");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println("| No | Kode BMN\t\t| Tahun Anggaran\t| Nama Barang\t\t\t| Nilai(Rp.)\t|");
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        
        if (riwayatHapus.isEmpty()) {
        System.out.println("|                              Tidak ada riwayat data yang dihapus                              |");
        }else {
            for (int i = 0; i < riwayatHapus.size(); i++) {
                System.out.println("|  " + (i + 1) + " | " + riwayatHapus.get(i).kode + "\t| " + riwayatHapus.get(i).tahun + "\t\t\t| "
                        + riwayatHapus.get(i).nama + "       \t\t| " + riwayatHapus.get(i).nilai + "\t|");
            }
        }
        System.out.println("+-----------------------------------------------------------------------------------------------+");
        System.out.println();
    }

    // MENYIMPAN RIWAYAT HAPUS KE FILE
    public void simpanRiwayatHapusKeFile(String fileName) {
        String garis = "+====================================================================+\n";
        String atas = "| Kode BMN    | Tahun Anggaran   | Nama Barang                     | Nilai(Rp.) |\n";
        String bawah = "+--------------------------------------------------------------------+\n";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(garis);
            writer.write(atas);
            writer.write(bawah);
            for (int i = 0; i < riwayatHapus.size(); i++) {
                String data = String.format("| %-12s | %-16s | %-30s | %-10s |\n",
                        riwayatHapus.get(i).kode, riwayatHapus.get(i).tahun, riwayatHapus.get(i).nama, riwayatHapus.get(i).nilai);
                writer.write(data);
            }
            writer.write(bawah);
            writer.write("\n");
            System.out.println("Riwayat data yang dihapus berhasil disimpan ke file " + fileName);
            System.out.println();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan riwayat data yang dihapus ke file " + fileName);
            e.printStackTrace();
        }
    }

    // MEMBUAT FILE .txt BUAT EXPORT
    public void writeArrayToFile(Projek[] pj, String fileName) {
        String judul = "                Daftar Inventaris Barang Milik Negera                 \n";
        String garis = "+====================================================================+\n";
        String atas = "| Kode BMN    | Tahun Anggaran  | Nama Barang\t\t| Nilai(Rp.) |\n";
        String penutup = "+--------------------------------------------------------------------+";
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(judul);
            bufferedWriter.write(garis);
            bufferedWriter.write(atas);
            bufferedWriter.write(garis);
            for (int i = 0; i < pj.length; i++) {
                    bufferedWriter.write("| "+pj[i].kode+"  | "+pj[i].tahun+"\t\t| "+pj[i].nama+"\t\t| "+pj[i].nilai+"    |"); 
                    bufferedWriter.write(" ");
                bufferedWriter.newLine();
            }
            bufferedWriter.write(penutup);

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

}