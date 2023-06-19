package org.example;

public class CensusService {
    public String exportData(){
        return "data exported";
    }

    public boolean isOdd(int number){
        if(number%2==0)
            return false;
        else
            return true;
    }

    public String sayHello(String user){
        return "Hello:" + user;
    }

    public boolean isEmpty(String name){
        return name.isBlank();
    }
}
