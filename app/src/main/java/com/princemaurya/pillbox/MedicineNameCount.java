package com.princemaurya.pillbox;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class MedicineNameCount extends BaseObservable {
    
    String meda,medb,medc,medd,counta,countb,countc,countd;


    public MedicineNameCount() {
    }

    public MedicineNameCount(String meda, String medb, String medc, String medd, String counta, String countb, String countc, String countd) {
        this.meda = meda;
        this.medb = medb;
        this.medc = medc;
        this.medd = medd;
        this.counta = counta;
        this.countb = countb;
        this.countc = countc;
        this.countd = countd;
    }

    public void setMeda(String meda) {
        this.meda = meda;
    }

    public void setMedb(String medb) {
        this.medb = medb;
    }

    public void setMedc(String medc) {
        this.medc = medc;
    }

    public void setMedd(String medd) {
        this.medd = medd;
    }
    @Bindable
    public String getCounta() {
        return counta;
    }
    @Bindable
    public String getCountb() {
        return countb;
    }
    @Bindable
    public String getCountc() {
        return countc;
    }

    public void setCounta(String counta) {
        this.counta = counta;
    }

    public void setCountb(String countb) {
        this.countb = countb;
    }

    public void setCountc(String countc) {
        this.countc = countc;
    }

    public void setCountd(String countd) {
        this.countd = countd;
    }

    @Bindable
    public String getCountd() {
        return countd;
    }

    @Bindable
    public String getMeda() {
        return meda;
    }
    @Bindable
    public String getMedb() {
        return medb;
    }
    @Bindable
    public String getMedc() {
        return medc;
    }
    @Bindable
    public String getMedd() {
        return medd;
    }
}
