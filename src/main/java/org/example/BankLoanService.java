package org.example;

public class BankLoanService {
    public float calcSimpleInterestAmount(float principle, float rate, float time){
        if(principle<=0 || rate<=0 || time<=0) throw new IllegalArgumentException("Invalid Inputs");
//        try{
//            Thread.sleep(10000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return principle*rate*time/100.0f;
    }
}
