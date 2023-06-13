import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Projek {
    static Scanner sc = new Scanner(System.in);
    public int nilai, tahun, angka, jmlHapus = 0, indeksTambah;
    public String nama, kode;

    public Projek(String kode,int tahun, String nama, int nilai){
        this.kode = kode;
        this.tahun = tahun;
        this.nama = nama;
        this.nilai = nilai;
    }

    public void tampilData(Projek[] array){
        System.out.println("No\tKode BMN\tTahun Anggaran\tNama Barang\tNilai(Rp.)");
        for(int i=0; i<array.length; i++){
            System.out.println((i+1)+"\t"+array[i].kode+"\t"+array[i].tahun+"\t"+array[i].nama+"\t\t"+array[i].nilai);
        }
    }

    public Projek[] hapusData(Projek[] array){
        int jumHapus = 0;
        for(int i=0; i<array.length; i++){
            System.out.print("Apakah anda ingin menghapus Data baris ke "+(i+1)+" (y/n): ");
            String jawab = sc.next();
            if(jawab.equalsIgnoreCase("y")){
                array[i].kode = null;
                array[i].tahun = 0;
                array[i].nama = null;
                array[i].nilai = 0;
                jumHapus += 1;
            }
        }
        jmlHapus = jumHapus;
        Projek[] arrayBaruHapus = new Projek[array.length-jmlHapus];
        System.arraycopy(array, 0, arrayBaruHapus, 0, array.length-jmlHapus);
        return arrayBaruHapus;
    }

    public void urutData(Projek[] array){
        Arrays.sort(array, Comparator.nullsLast(Comparator.comparing(p -> p.kode, String.CASE_INSENSITIVE_ORDER)));
    }

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

    public void cariData(Projek[] array){
        System.out.println("=====MENU PENCARIAN=====");
        System.out.print("Cari Berdasarkan\n1. Kode Barang\n2. Tahun Barang\n3. Nama Barang\n4. Nilai\nPilih (1/2/3/4): ");
        int pilihan = sc.nextInt();
        int gagal = 0;
        System.out.println("=======CARI DATA BARANG BMN=======");
        switch(pilihan){
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
}
