package İnsurance;

import java.util.Date;

public class İnsuranceHousing extends İnsurance{
    public İnsuranceHousing(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 15000;
    }
}
