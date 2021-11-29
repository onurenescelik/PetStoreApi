package com.techproed.pojos;

public class BookingDatesPojo {

    //"checkin": "2020-09-09",
    //"checkout": "2020-09-21"

    //private degiskenler
    private String checkin;
    private String checkout;

    //getter ve setter methodlar

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    //3- constructor p.li ve p.siz


    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}