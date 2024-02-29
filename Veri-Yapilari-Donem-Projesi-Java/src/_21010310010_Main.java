import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class _21010310010_Main {

    static Map<String, Integer> sehirKodlari = new HashMap<>();

    static Map<String, String> kisiler = new HashMap<>();

    static ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();

    public static Scanner okuma(String dosyaAdi) throws FileNotFoundException {

            Scanner scanner = new Scanner(new File(dosyaAdi));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] sehir = scanner.nextLine().split(" ");
                if (sehir.length == 2) {
                    sehirKodlari.put(sehir[0], Integer.parseInt(sehir[1]));
                } else {
                    break;
                }
            }

            int sehirSayisi = sehirKodlari.size();

           scanner.nextLine();

            for (int i = 0; i < sehirSayisi; i++) {
                String tempData = scanner.nextLine();
                String [] tempDataArray  = tempData.replace("\t" ,"-").split("-");
                int counter = 1;
                ArrayList<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < sehirSayisi; j++) {
                    tempList.add(Integer.parseInt(tempDataArray[counter]));
                    counter++;
                }
                bigList.add(tempList);
            }
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] kisi = scanner.nextLine().split(" ");
                if (kisi.length == 2) {
                    kisiler.put(kisi[0], kisi[1]);
                } else {
                    break;
                }
            }
            return scanner;
    }
    public static void yol(String sc,Scanner scanner) {

        while (scanner.hasNextLine()) {

            String[] dizi = scanner.nextLine().split(" ");
            double hiz = Double.parseDouble(dizi[2].replace("km/dk", "").replace(",", "."));
            String[] guzergah = dizi[1].split("-");
            int[] yolToplam = new int[guzergah.length];

            for (int i = 0; i < guzergah.length - 1; i++) {
                yolToplam[i] = bigList.get(sehirKodlari.get(guzergah[i]) - 1).get(sehirKodlari.get(guzergah[i + 1]) - 1);
            }

            int toplam = 0;
            for (int j = 0; j < yolToplam.length - 1; j++) {
                toplam += yolToplam[j];
            }

            if (sehirKodlari.get(guzergah[0]) == sehirKodlari.get(kisiler.get(sc))) {
                System.out.println(dizi[0] + " toplam yol uzunluğu " + toplam + " km");

            }
        }
    }
    public static void süre(String sc,Scanner scanner) {

        while (scanner.hasNextLine()) {

            String[] dizi = scanner.nextLine().split(" ");
            double hiz = Double.parseDouble(dizi[2].replace("km/dk", "").replace(",", "."));
            String[] guzergah = dizi[1].split("-");
            int[] yolToplam = new int[guzergah.length];

            for (int i = 0; i < guzergah.length - 1; i++) {
                yolToplam[i] = bigList.get(sehirKodlari.get(guzergah[i]) - 1).get(sehirKodlari.get(guzergah[i + 1]) - 1);
            }

            int toplam = 0;
            for (int j = 0; j < yolToplam.length - 1; j++) {
                toplam += yolToplam[j];
            }

            double zaman = (int) toplam / hiz;

            if (sehirKodlari.get(guzergah[0]) == sehirKodlari.get(kisiler.get(sc))) {
                System.out.println(dizi[0] +" "+ guzergah[guzergah.length-1] +" varış süresi "+zaman  + " dk");
            }

        }

    }

    public static void soru4(String sc,Scanner scanner) {
        String[] girilen = sc.split(" ");
        int count = 0;

            while (scanner.hasNextLine()) {
                if(count == 0 ) {
                String[] dizi = scanner.nextLine().split(" ");
                double hiz = Double.parseDouble(dizi[2].replace("km/dk", "").replace(",", "."));
                String[] guzergah = dizi[1].split("-");
                int[] yolToplam = new int[guzergah.length];

                for (int i = 0; i < guzergah.length - 1; i++) {
                    yolToplam[i] = bigList.get(sehirKodlari.get(guzergah[i]) - 1).get(sehirKodlari.get(guzergah[i + 1]) - 1);
                }

                int toplam = 0;
                for (int j = 0; j < yolToplam.length - 1; j++) {
                    toplam += yolToplam[j];
                }

                double zaman = (int) toplam / hiz;

                if (bigList.get(sehirKodlari.get(girilen[0]) - 1).get(sehirKodlari.get(girilen[1]) - 1) == 0) {
                    System.out.println(girilen[0] + " " + girilen[1] + " arasında direkt yol yoktur.");
                    count++;
                }
                else {
                    System.out.println(girilen[0] + " " + girilen[1] + " arasında direkt yol vardır.");
                    count++;
                }
            }
                else {
                    break;
                }
        }
    }

    public static void soru3(String sc,Scanner scanner) {
        int count = 0;

        while (scanner.hasNextLine()) {

            if (count == 0) {
                String[] dizi = scanner.nextLine().split(" ");
                double hiz = Double.parseDouble(dizi[2].replace("km/dk", "").replace(",", "."));
                String[] guzergah = dizi[1].split("-");
                int[] yolToplam = new int[guzergah.length];

                for (int i = 0; i < guzergah.length - 1; i++) {
                    yolToplam[i] = bigList.get(sehirKodlari.get(guzergah[i]) - 1).get(sehirKodlari.get(guzergah[i + 1]) - 1);
                }

                int toplam = 0;
                for (int j = 0; j < yolToplam.length - 1; j++) {
                    toplam += yolToplam[j];
                }

                double zaman = (int) toplam / hiz;

                int baslangıcDakika = 8 * 60;
                String[] ara = sc.split(" ");
                String[] girilen = ara[1].split(":");
                int saat = Integer.parseInt(girilen[0]);
                int dakika = Integer.parseInt(girilen[1]);
                int toplamDakika = (saat * 60) + dakika;
                int fark = toplamDakika - baslangıcDakika;
                if(ara[0].contains(dizi[0])) {
                    int tmp = 0;
                    toplam = tmp;
                    for (int i = 0; i < yolToplam.length-1; i++) {
                        toplam += yolToplam[i];
                        if ((toplam / hiz) > fark) {
                            System.out.println(ara[0] + " " + ara[1] + " itibariyle " + guzergah[i] + " " + guzergah[i+1] + " arasındadır.");
                        }

                    }
                    if((toplam / hiz) < fark) {
                    	System.out.println("yolculuk bitmiş");
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        Scanner sc2 = okuma("Bilgiler.txt");
        System.out.println("Varış süresi hesaplanacak olan kişinin ismini giriniz: ");
        String süre = sc.nextLine();
        süre(süre, sc2);

        Scanner scanner = okuma("Bilgiler.txt");
        System.out.println("Toplam yol uzunluğu hesaplanacak olan kişinin ismini giriniz: ");
        String yol = sc.nextLine();
        yol(yol, scanner);

        Scanner sc4 = okuma("Bilgiler.txt");
        System.out.println("İki şehir arasında direkt yol olup olmadığını sorgulamak için şehir isimlerini aralarında bir boşluk bırakarak giriniz:");
        String soru4 = sc.nextLine();
        soru4(soru4, sc4);

        Scanner sc3 = okuma("Bilgiler.txt");
        System.out.println("Kimin hangi saat itibariyle hangi noktada olduğunu hesaplamak için, aralarında bir boşluk bırakarak kişi ismini ve saati giriniz:");
        String soru3 = sc.nextLine();
        soru3(soru3, sc3);

        sc3.close();;

    }
}