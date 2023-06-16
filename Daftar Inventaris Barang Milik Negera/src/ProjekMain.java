public class ProjekMain {
    public static void main(String[] args) {
        Projek[] pj = new Projek[4];
        pj[0] = new Projek("PL-2304-02",2023, "Meja Kerja", 1000000); 
        pj[1] = new Projek("PL-2304-01",2023, "Meja Kerja", 1000000); 
        pj[2] = new Projek("PL-2208-13",2023, "Printer Espon", 1500000);
        pj[3] = new Projek("PL-1901-25",2023, "AC 1.5 PK LG", 3000000);

        pj[0].login();
        if(pj[0].login(pj[0].username, pj[0].password)){
            for(int i=0; i<1;){
                break;
            }
        }

        int menu;
        String fileName = "DataBMN.txt";
        do{
            System.out.println("==========MENU==========");
            System.out.println("1. Tampilkan Data BMN");
            System.out.println("2. Cari Data BMN");
            System.out.println("3. Tambah Data BMN");
            System.out.println("4. Hapus Data BMN");
            System.out.println("5. Urut Data BMN");
            System.out.println("6. Cetak Data BMN");
            System.out.println("7. Statistik Data BMN");
            System.out.println("0. Exit");
            System.out.print("Pilih menu: ");
            menu = Projek.sc.nextInt();
            switch(menu){
                case 1:
                    pj[0].tampilData(pj);
                    break;

                case 2:
                    pj[0].cariData(pj);
                    break;
                
                case 3:
                    pj = pj[0].tambahData(pj);
                    pj[0].isiDariTambah(pj);
                    break;
                
                case 4:
                    pj=pj[0].hapusData(pj);
                    break;

                case 5:
                    pj[0].urutData(pj);
                    break;

                case 6:
                    pj[0].writeArrayToFile(pj, fileName);
                    System.out.println("Array berhasil dicetak ke file.");
                    break;

                case 7:
                    pj[0].hitungStatistik(pj);
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Menu yang anda pilih tidak tersedia");
                    break;
            }

        }while(menu!=0);
    }
}
