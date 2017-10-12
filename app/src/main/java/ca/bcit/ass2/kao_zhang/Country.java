package ca.bcit.ass2.kao_zhang;

/**
 * Created by Lel on 2017-10-10.
 */

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.List;

import static android.content.ContentValues.TAG;

public class Country implements Parcelable{
    private String name;

    private String capital;

    private String region;

    private int population;

    private int area;

    private List<String> borders;

    private String flag;

    public Country(){

    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return this.name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return this.capital;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getRegion() {
        return this.region;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea() {
        return this.area;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public List<String> getBorders() {
        return this.borders;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getFlag() {
        return this.flag;
    }

    public int describeContents() {
        return 0;
    }

    public Country(Parcel source) {
        Log.v(TAG, "Putting the Country back together.");
        name = source.readString();
        capital = source.readString();
        region = source.readString();
        population = source.readInt();
        area = source.readInt();
        source.readList(borders, null);
        flag = source.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        Log.v(TAG, "writeToParcel..." + flags);
        dest.writeString(name);
        dest.writeString(capital);
        dest.writeString(region);
        dest.writeInt(population);
        dest.writeInt(area);
        dest.writeList(borders);
        dest.writeString(flag);
    }

    public class MyCreator implements Parcelable.Creator<Country> {
        public Country createFromParcel(Parcel source) {
            return new Country(source);
        }

        public Country[] newArray(int size) {
            return new Country[size];
        }
    }
}
