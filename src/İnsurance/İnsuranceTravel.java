package İnsurance;

import java.util.Date;

public class İnsuranceTravel extends İnsurance{
    public İnsuranceTravel(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 1000;
    }
}
