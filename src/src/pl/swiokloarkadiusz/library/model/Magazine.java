package pl.swiokloarkadiusz.library.model;

import java.util.Objects;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;
    
    public Magazine(String title, String publisher, String language, int year, int month, int day) {
        this.setTitle(title);
        this.setPublisher(publisher);
        this.setYear(year);
        this.language = language;
        this.month = month;
        this.day = day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Magazine magazin = (Magazine) o;
        return month == magazin.month &&
                day == magazin.day &&
                Objects.equals(language, magazin.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day, language);
    }

    @Override
    public String toString() {
        return super.toString() +
                "month=" + month +
                ", day=" + day +
                ", language='" + language + '\'' +
                '}';
    }

}
