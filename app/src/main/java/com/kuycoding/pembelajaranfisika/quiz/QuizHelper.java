package com.kuycoding.pembelajaranfisika.quiz;

import java.util.Random;

public class QuizHelper {
    private String[] mSoal = {
            "Besaran yang menjadi dasar untuk menetapkan besaran yang lain adalah...",
            "Berikut ini adalah besaran pokok kecuali",
            "Alat yang digunakan untuk besaran suhu adalah...",
            "Zat yang memiliki gaya tarik-menarik antar molekul sangat kuat adalah...",
            "Perubahan wujud zat yang semula berwujud zat padat menjadi zat gas",
            "Pada objek bergerak mengalami perubahan jarak serta dapat pula  mengalami perubahan posisi yang disebut...",
            "Sebuah truk dengan massa 2.000 kg melaju dengan kecepatan 36 km/jam, kemudian menabrak sebuah pohon dan berhenti dalam waktu 0,1 sekon. Gaya rata-rata pada truk selama berlangsungnya tabrakan adalah….",
            "Sebuah truk memiliki 8 roda berisi 2,5 ton muatan dan akan melintasi jembatan. Luas permukaan bidang sentuh roda dengan permukaan jalan seluruhnya adalah 400 cm2. Berapakah tekanan yang dialami setiap ban?",

            "Yang bukan merupakan jenis gelombang berdasarkan medium perambatannya adalah",
            "Berikut ini adalah sifat-sifat cahaya, kecuali"

    };


    private String[][] mChoices = {
            {"Besaran Turunan", "Besaran Pokok", "Besaran Primer"},
            {"Suhu","Jumlah Zat","Kecepatan"},
            {"Avometer", "Barometer", "Termometer"},
            {"Zat Padat","Zat Cair","Zat Gas"},
            {"Menyublim","Mencair","Mengkristal"},
            {"Gerakan","Perpindahan","Perubahan"},
            {"2000 N","20000 N","200000 N"},
            {"78.125 Pa","88.225 Pa","32.315 Pa"},

            {"Gelombang Mekanik","Gelombang Elektromagnetik","Gelombang Interval"},
            {"Cahaya Merambat Lurus","Cahaya tidak dapat dipantulkan", "Cahaya dapat diuraikan"}

    };


    private String[] mCorrectAnswers = {
            "Besaran Pokok",
            "Kecepatan",
            "Termometer",
            "Zat Padat",
            "Menyublim",
            "Perpindahan",
            "200000 N",
            "78.125 Pa",

            "Gelombang Interval",
            "Cahaya tidak dapat dipantulkan"
    };

    public String getQuestion(int a) {
        Random random = new Random();
        return mSoal[a];
    }

    public String getChoice1(int a) {
        return mChoices[a][0];
    }


    public String getChoice2(int a) {
        return mChoices[a][1];
    }

    public String getChoice3(int a) {
        return mChoices[a][2];
    }

    public String getCorrectAnswer(int a) {
        return mCorrectAnswers[a];
    }

    public int getQuestion() {
        return mSoal.length;
    }
}
