/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Gabika
 */
public class KosarElem implements Serializable {

    private Cd elem;
    private int mennyiseg;

    public KosarElem() {
    }

    public double getOsszAr() {
        return mennyiseg * elem.getPrice();
    }

    public KosarElem(Cd elem, int mennyiseg) {
        this.elem = elem;
        this.mennyiseg = mennyiseg;
    }

    public int getMennyiseg() {
        return mennyiseg;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = mennyiseg;
    }

    public Cd getElem() {
        return elem;
    }

    public void setElem(Cd elem) {
        this.elem = elem;
    }

}
