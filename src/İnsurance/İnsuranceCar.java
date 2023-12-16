package İnsurance;

import Accounts.Users;

import java.util.Date;

public class İnsuranceCar extends İnsurance{

    İnsuranceCar(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 2800;
    }

    public static void insuranceCarBuy(Users users){
        İnsurance car=new İnsuranceCar("Otomobil",2800,new Date(),new Date());
        users.getGetUserİnsuranceList().add(car);

    }
}

