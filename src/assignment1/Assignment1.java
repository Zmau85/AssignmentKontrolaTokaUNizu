package assignment1;

import java.util.Arrays;

/**
 * Assignment - Korišćenje naredbi za kontrolu toka u obradi niza
 *
 * @author Nemanja Koprivica
 */
public class Assignment1 {

    public static void main(String[] args) {

        // Niz koji se obradjuje(iz zadatka)
        int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};
        //int[] array = {1, 1, 5, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87, 545, -4, -55, 43, 12, 0, -999, -87};

        // Poziv metode za štampanje dva nova niza
        stampanjeNizova(array);

        // Poziv metode za štampanje duplikata
        stampanjeDuplikata(array);

    }

    // Metoda za štampanje članova dva nova niza
    public static void stampanjeNizova(int[] array) {

        int countP = 0;         //pomoćni brojač za određivanje dužine niza pozitivnih brojeva
        int countN = 0;         //pomoćni brojač za određivanje dužine niza negativnih brojeva

        // For petlja za odredjivanje dužina dva nova niza(niza pozitivnih i niza negativnih brojeva
        for (int i = 0; i < array.length; i++) {
            // If else uslov za odredjivanje koliko ima pozitivnih, a koliko negativnih brojeva
            if (array[i] > 0) {
                countP += 1;
            } else if (array[i] < 0) {
                countN += 1;
            }
        }

        //Štampanje vrednosti oba pomoćna brojača, radi provere
        System.out.println("Broj pozitivnih članova niza: " + countP + ", "
                + "broj negativnih članova niza: " + countN);
        System.out.println("--------------------------------------------------------");

        // Deklarisanje dva nova niza: 
        // arrayP - za pozitivne vrednosti, arrayN - za negativne vrednosti
        int[] arrayP = new int[countP];
        int[] arrayN = new int[countN];

        // Resetovanje pomoćnih brojača
        countP = 0;
        countN = 0;

        // For petlja za razvrstavanje pozitivnih i negativnih članova u nove nizove
        for (int i = 0; i < array.length; i++) {

            if (array[i] > 0) {
                arrayP[countP] = array[i];
                countP++;
            } else if (array[i] < 0) {
                arrayN[countN] = array[i];
                countN++;
            }
        }
        System.out.println("Članovi niza sa negativnim vrednostima su: ");
        for (int i : arrayP) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("Članovi niza sa negativnim vrednostima su: ");
        for (int i : arrayN) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("--------------------------------------------------------");

    }

    // Metoda za pronalaženje članova niza čije se vrednosti ponavljaju u nizu
    public static void stampanjeDuplikata(int[] array) {
        //int count1 = 1;
        //int count2 = 0;

        // Arrays.sort(array);
        // Štampanje svih članova niza, radi preglednosti, prilikom provere dobijenih rezultata
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("");

       
        // Pomoćna promenljiva za privremeno čuvanje vrednosti svakog člana u nizu 
        // i dodeljujemo joj vrednost prvog člana niza
        int pom = array[0];
        // Sortiranje niza za lakše prebrajanje elemenata koji se ponavljaju
        //(Pošto je u metodi, ne kvari početni niz array)
        Arrays.sort(array);
        // Brojač koji ima početnu vrednost 1, jer čim pronadje prva dva ista broja,
        // njegova vrednost mora da bude dva
        int count = 1;
        // For petlja za proveru članova niza, i ima početnu vrednost 1, 
        // jer u pom se na početku čuva vrednost prvog člana 
        for (int i = 1; i < array.length; i++) {
            // If uslov za traženje jednakih vrednosti, u kome se povećava i brojač
            if (pom == array[i]) {
                count++;
            // Else uslov za sve ostale slučajeve, odnosno kad se prekine podniz isih brojeva,
            // koji u sebi sadrži ugnježdeni if else uslov
            } else {  
                //if uslov koji reguliše vrednost brojača prilikom prolaska kroz niz sa nejednakim vrednostima
                if (count == 1) {
                    count = 1;
                //else uslov koji štampa broj koji ima duplikata i broj ponavljanja 
                //i resetuje brojač nakon prolaska kroz podniz isith brojeva
                } else {
                    System.out.println("Broj " + pom + " se pojavljuje " + count + " puta"); // štampa pom koji sadrži trenutnu vrednost array[i-1]
                    count = 1;
                }
                pom = array[i]; //pom dobija vrednost trenutnog člana sa indeksom i 
            }
        }
    }
}
