package business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Annuity {
   private double begDeposit;
   private double endDeposit;
   private double rate;
   private int term;
   private double[] bbal;
   private double[] iearn;
   private double[] ebal;
   private boolean built;
   private NumberFormat curr = NumberFormat.getCurrencyInstance();
   private NumberFormat percent = NumberFormat.getPercentInstance();

   public Annuity(double begDeposit, double endDeposit, double rate, int term) {
       setBegDeposit(begDeposit);
       setEndDeposit(endDeposit);
       setRate(rate);
       setTerm(term);
       buildAnnuity();
   }
   
   public Annuity() {
       setBegDeposit(0);
       setEndDeposit(0);
       setRate(0);
       setTerm(0);
       built = false;
   }

   public double getBegDeposit() {
       return this.begDeposit;
   }
   
   public String getStrBegDep() {
       return curr.format(this.begDeposit);
   }
   
   public double getEndDeposit() {
       return this.endDeposit;
   }
   
   public String getStrEndDep() {
       return curr.format(this.endDeposit);
   }
   
    /**
     * @param deposit the deposit to set
     */
    public void setBegDeposit(double deposit) {
        this.begDeposit = deposit;
    }
    
    public void setEndDeposit(double deposit) {
        this.endDeposit = deposit;
    }

   public double getRate() {
       return this.rate;
   }
   
   public String getStrRate() {
       return percent.format(this.rate);
   }

    /**
     * @param rate the rate to set
     */
    public void setRate(double rate) {
        this.rate = rate;
    }

   public int getTerm() {
       return this.term;
   }

    /**
     * @param term the term to set
     */
    public void setTerm(int term) {
        this.term = term;
    }
   
   public double getFinalValue() {
       if (!built) {
           buildAnnuity();
       }
       return ebal[term-1];
   }
   
   public String getStrFV() {
       return curr.format(getFinalValue());
   }
   
   public double getBegBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.bbal[m-1];
   }
   public double getIntEarn(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.iearn[m-1];
   }
   
   public String getStrIntEarned() {
       double totalInt = 0;
       for (int i=1;i<=this.term;i++) {
           totalInt += getIntEarn(i);
       }
       return curr.format(totalInt);
   }
   
   public double getEndBal(int m) {
       if (!built) {
           buildAnnuity();
       }
       return this.ebal[m-1];
   }
   
   private void buildAnnuity() {
       bbal = new double[term];
       iearn = new double[term];
       ebal = new double[term];

       bbal[0] = 0;
       for (int i=0; i < this.term; i++) {
           if (i > 0) {
               bbal[i] = ebal[i-1];
           }
           iearn[i] = (bbal[i] + this.begDeposit) * (this.rate / 12.0);
           ebal[i] = (bbal[i] + this.begDeposit + this.endDeposit + iearn[i]);
       }
       built = true;
   }
   
   public ArrayList<AnnuityMonth> getMonthData() {
       ArrayList<AnnuityMonth> months = new ArrayList<>();
       if (!built) {
           buildAnnuity();
       }
       
       for (int i=0;i<this.term;i++) {
           months.add(new AnnuityMonth(i+1,this.bbal[i],this.iearn[i],this.ebal[i],this.begDeposit,this.endDeposit));
       }
       return months;
   }
}
