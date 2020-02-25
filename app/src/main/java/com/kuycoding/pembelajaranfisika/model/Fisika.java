package com.kuycoding.pembelajaranfisika.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Fisika implements Parcelable {
    private String judul;
    private String materi1;
    private String materi2;
    private int sampul, poster;
    private int gambar1, gambar2;

    public Fisika(Parcel in) {
        judul = in.readString();
        materi1 = in.readString();
        materi2 = in.readString();
        sampul = in.readInt();
        poster = in.readInt();
        gambar1 = in.readInt();
        gambar2 = in.readInt();
    }

    public static final Creator<Fisika> CREATOR = new Creator<Fisika>() {
        @Override
        public Fisika createFromParcel(Parcel in) {
            return new Fisika(in);
        }

        @Override
        public Fisika[] newArray(int size) {
            return new Fisika[size];
        }
    };

    public Fisika() {

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getMateri1() {
        return materi1;
    }

    public void setMateri1(String materi1) {
        this.materi1 = materi1;
    }

    public String getMateri2() {
        return materi2;
    }

    public void setMateri2(String materi2) {
        this.materi2 = materi2;
    }

    public int getSampul() {
        return sampul;
    }

    public void setSampul(int sampul) {
        this.sampul = sampul;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getGambar1() {
        return gambar1;
    }

    public void setGambar1(int gambar1) {
        this.gambar1 = gambar1;
    }

    public int getGambar2() {
        return gambar2;
    }

    public void setGambar2(int gambar2) {
        this.gambar2 = gambar2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(judul);
        dest.writeString(materi1);
        dest.writeString(materi2);
        dest.writeInt(sampul);
        dest.writeInt(poster);
        dest.writeInt(gambar1);
        dest.writeInt(gambar2);
    }
}
