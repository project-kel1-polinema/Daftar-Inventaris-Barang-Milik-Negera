public class BMN {}
    public String kode;
    public int tahunAnggaran;
    public String nama;
    public int nilai;

    public class Login {
        public String[] user = {"Agung", "Dona", "Aldi", "Rafli", "Naura", "Zaidan"};
        public String[] passwords = {"2241760135", "2241760", "2241760", "2241760", "2241760", "2241760"};

        public boolean login(String username, String password) {
            for (int i = 0; i < user.length; i++) {
                if (username.equals(user[i]) && password.equals(passwords[i])) {
                    return true;
                }
            }
            return false;
        }
    }

    public BMN(String code, int thnAnggaran,  String name, int nilai) {
        this.kode = code;
        this.tahunAnggaran = thnAnggaran;
        this.nama = name;
        this.nilai = nilai;
    }

    public String getKode() {
        return kode;
    }

    public int getTahunAnggaran() {
        return tahunAnggaran;
    }
    public String getNama() {
        return nama;
    }
}