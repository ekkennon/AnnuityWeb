/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.text.NumberFormat;

/**
 *
 * @author Erin K Kennon
 */
public class AnnuityMonth {
    private int month;
    private double begBal;
    private double begDep;
    private double endDep;
    private double iearn;
    private double endBal;
    private NumberFormat curr = NumberFormat.getCurrencyInstance();
                            
    public AnnuityMonth() {
        setMonth(0);
        setBegBal(0);
        setBegDep(0);
        setEndDep(0);
        setIearn(0);
        setEndBal(0);
    }
    
    public AnnuityMonth(int month, double bb, double ie, double eb, double bd, double ed) {
        setMonth(month);
        setBegBal(bb);
        setBegDep(bd);
        setEndDep(ed);
        setIearn(ie);
        setEndBal(eb);
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the bbal
     */
    public String getBegBal() {
        return curr.format(begBal);
    }

    /**
     * @param bbal the bbal to set
     */
    public void setBegBal(double bbal) {
        this.begBal = bbal;
    }

    /**
     * @return the dep
     */
    public String getBegDep() {
        return curr.format(begDep);
    }

    /**
     * @param dep the dep to set
     */
    public void setBegDep(double dep) {
        begDep = dep;
    }
    
    public String getEndDep() {
        return curr.format(endDep);
    }
    
    public void setEndDep(double dep) {
        endDep = dep;
    }

    /**
     * @return the iearn
     */
    public String getIearn() {
        return curr.format(iearn);
    }

    /**
     * @param iearn the iearn to set
     */
    public void setIearn(double iearn) {
        this.iearn = iearn;
    }

    /**
     * @return the endbal
     */
    public String getEndBal() {
        return curr.format(endBal);
    }

    /**
     * @param endbal the endbal to set
     */
    public void setEndBal(double endbal) {
        this.endBal = endbal;
    }
}
