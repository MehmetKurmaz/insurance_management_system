package İnsurance;

import java.util.Date;

public class İnsuranceHealth extends İnsurance{
    public İnsuranceHealth(String insuranceName, int insurancePrice, Date insuranceStartDate, Date insuranceFinishDate) {
        super(insuranceName, insurancePrice, insuranceStartDate, insuranceFinishDate);
    }

    @Override
    public double calculate() {
        return 400;
    }

}
