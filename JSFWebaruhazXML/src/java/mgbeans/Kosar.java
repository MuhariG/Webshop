/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgbeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cd;
import model.KosarElem;

/**
 *
 * @author Gabika
 */
@ManagedBean
@SessionScoped
public class Kosar {

    private List<KosarElem> elemek;

    public Kosar() {
        elemek = new ArrayList<>();
    }

    public void hozzaad(Cd cd) {
        KosarElem ke = keres(cd);

        if (ke == null) {
            ke = new KosarElem(cd, 1);
            elemek.add(ke);
        } else {
            mennyisegNovel(ke);
        }
    }

    public double getTotal() {
        double total = 0;
        for (KosarElem ke : elemek) {
            total += ke.getOsszAr();
        }
        return total;
    }

    public int getOsszDarabszam() {
        int ossz = 0;
        for (KosarElem ke : elemek) {
            ossz += ke.getMennyiseg();
        }
        return ossz;
    }

    public void torol(KosarElem ke) {
        elemek.remove(ke);
    }

    public void mennyisegNovel(KosarElem ke) {
        ke.setMennyiseg(ke.getMennyiseg() + 1);
    }

    public void mennyisegCsokkent(KosarElem ke) {
        if (ke.getMennyiseg() > 1) {
            ke.setMennyiseg(ke.getMennyiseg() - 1);
        } else {
            torol(ke);
        }
    }

    public KosarElem keres(Cd cd) {
        for (KosarElem k : elemek) {
            if (k.getElem().equals(cd)) {
                return k;
            }
        }
        return null;
    }

    public List<KosarElem> getElemek() {
        return elemek;
    }

    public void setElemek(List<KosarElem> elemek) {
        this.elemek = elemek;
    }

}
