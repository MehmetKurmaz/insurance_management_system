package İnsurance;

import Accounts.Users;

import java.util.Date;

public abstract class İnsurance {
    private String insuranceName;
    private int insurancePrice;
    private Date insuranceStartDate;
    private Date insuranceFinishDate;

    İnsurance(String insuranceName,int insurancePrice,Date insuranceStartDate,Date insuranceFinishDate){
        this.insuranceName=insuranceName;
        this.insurancePrice=insurancePrice;
        this.insuranceStartDate=insuranceStartDate;
        this.insuranceFinishDate=insuranceFinishDate;

    }
    public abstract double calculate();

    public static void insuranceCarBuy(Users users){
        try {
            İnsurance car=new İnsuranceCar("Otomobil",2800,new Date(),new Date());
            users.getGetUserİnsuranceList().add(car);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Araç Sigortası Satın Alındı...");
            System.out.println("-----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void insuranceHousingBuy(Users users){
        try {
            İnsurance home=new İnsuranceHousing("Ev",15000,new Date(),new Date());
            users.getGetUserİnsuranceList().add(home);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Konut Sigortası Alındı...");
            System.out.println("-----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void insuranceHealthBuy(Users users){
        try {
            İnsurance health=new İnsuranceHealth("Sağlık",400,new Date(),new Date());
            users.getGetUserİnsuranceList().add(health);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Sağlık Sigortası Alındı...");
            System.out.println("-----------------------------------------------------------------------------");
    }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public static void insuranceHTravelBuy(Users users){
        try {
            İnsurance travel=new İnsuranceTravel("Seyahat",1000,new Date(),new Date());
            users.getGetUserİnsuranceList().add(travel);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Seyahat Sigortası Alındı...");
            System.out.println("-----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }


    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public int getInsurancePrice() {
        return insurancePrice;
    }

    public void setInsurancePrice(int insurancePrice) {
        this.insurancePrice = insurancePrice;
    }

    public Date getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(Date insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public Date getInsuranceFinishDate() {
        return insuranceFinishDate;
    }

    public void setInsuranceFinishDate(Date insuranceFinishDate) {
        this.insuranceFinishDate = insuranceFinishDate;
    }
}
