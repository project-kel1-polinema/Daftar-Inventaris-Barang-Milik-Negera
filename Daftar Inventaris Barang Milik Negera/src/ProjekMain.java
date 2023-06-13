public class ProjekMain {
    public static void main(String[] args) {
        Projek[] pj = new Projek[4];
        pj[0] = new Projek("PL-2304-02",2023, "Meja Kerja", 1000000); 
        pj[1] = new Projek("PL-2304-01",2023, "Meja Kerja", 1000000); 
        pj[2] = new Projek("PL-2208-13",2023, "Printer Espon T11", 1500000);
        pj[3] = new Projek("PL-1901-25",2023, "AC 1.5 PK LG", 3000000);
        int menu;
        do{
            System.out.println("==========MENU==========");
            System.out.print("1. Tampilkan Data BMN\n2. Cari Data BMN\n3. Tambah Data BMN\n4. Hapus Data BMN\n5. Urut Data BMN\n6. Exit\n");
            System.out.print("Pilih menu: ");
            menu = Projek.sc.nextInt();
            System.out.println();
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
                    return;

                default:
                    System.out.println("Menu yang anda pilih tidak tersedia");
                    break;
            }

        }while(menu!=0);
    }
}
