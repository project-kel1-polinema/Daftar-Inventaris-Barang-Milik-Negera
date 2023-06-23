import java.util.Arrays;

public class ProjekMain {
    public static void main(String[] args) {
        Projek[] pj = new Projek[4];
        pj[0] = new Projek("PL-2304-02",2023, "Meja Kerja", 1000000);
        pj[1] = new Projek("PL-2304-01",2023, "Meja Kerja", 1000000);
        pj[2] = new Projek("PL-2208-13",2023, "Printer Espon", 1500000);
        pj[3] = new Projek("PL-1901-25",2023, "AC 1.5 PK LG", 3000000);

        boolean login;
        do{
            String[] username = {"Agung", "Dona", "Aldi", "Rafli", "Naura", "Zaidan"};
            char[][] passwords = {
                {'2', '2', '4', '1'},
                {'2', '2', '4', '1'},
                {'2', '2', '4', '1'},
                {'2', '2', '4', '1'},
                {'2', '2', '4', '1'},
                {'2', '2', '4', '1'}
            };
            
            System.out.print("Masukkan username: ");
            String inputUsername = pj[0].sc.nextLine();

            System.out.print("Masukkan password: ");
            String inputPassword = pj[0].sc.nextLine();
    
            login = false;
            for (int i = 0; i < username.length; i++) {
                if (inputUsername.equals(username[i]) && Arrays.equals(inputPassword.toCharArray(), passwords[i])) {
                    login = true;
                    break;
                }
            }

            if (login) {
                System.out.println("Login Berhasil\n");
                System.out.println("~ Selamat Datang, " + inputUsername + ".");

            } else {
                System.out.println("Login Gagal");
                System.out.println();
            }
        }while(!login);

    
        int menu;
        String fileName = "DataBMN.txt";
        do{
            System.out.println("=============MENU=============");
            System.out.println("|| 1. Tampilkan Data        ||");
            System.out.println("|| 2. Cari Data             ||");
            System.out.println("|| 3. Tambah Data           ||");
            System.out.println("|| 4. Hapus Data            ||");
            System.out.println("|| 5. Urut Data             ||");
            System.out.println("|| 6. Statistik Data        ||");
            System.out.println("|| 7. Riwayat Tambah Data   ||");
            System.out.println("|| 8. Riwayat Hapus Data    ||");
            System.out.println("|| 9. Cetak Data            ||");
            System.out.println("|| 0. Exit                  ||");
            System.out.println("==============================");

            System.out.print("Pilih menu: ");
            menu = pj[0].sc.nextInt();
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
                    pj[0].hitungStatistik(pj);
                    break;

                case 7:
                    pj[0].tampilRiwayatTambah();
                    break;
                
                case 8:
                    pj[0].tampilRiwayatHapus();
                    break;

                case 9:
                    pj[0].cetakDataKeFile(pj, fileName);
                    System.out.println("Data berhasil dicetak menjadi file .txt");
                    System.out.println();
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