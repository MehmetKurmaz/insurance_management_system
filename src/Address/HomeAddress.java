package Address;

public class HomeAddress implements Address {
    private String province_name;
    private String district_name;
    private String neighbourhood_name;
    private String street_name;
    private String buildingName;
    private String DoorNumber;
    HomeAddress(){}
    HomeAddress(String province_name,String district_name,String neighbourhood_name,String street_name,String buildingName,String DoorNumber){
        this.province_name=province_name;
        this.district_name=district_name;
        this.neighbourhood_name=neighbourhood_name;
        this.street_name=street_name;
        this.buildingName=buildingName;
        this.DoorNumber=DoorNumber;
    }


    @Override
    public String getProvince_name() {
        return this.province_name;
    }

    @Override
    public void setProvince_name(String province_name) {
        this.province_name=province_name;
    }

    @Override
    public String getDistrict_name() {
        return this.district_name;
    }

    @Override
    public void setDistrict_name(String district_name) {
        this.district_name=district_name;
    }

    @Override
    public String getNeighbourhood_name() {
        return this.neighbourhood_name;
    }

    @Override
    public void setNeighbourhood_name(String neighbourhood_name) {
        this.neighbourhood_name=neighbourhood_name;
    }

    @Override
    public String getStreet_name() {
        return this.street_name;
    }

    @Override
    public void setStreet_name(String street_name) {
        this.street_name=street_name;
    }

    @Override
    public String getCompanyName_or_buildingName() {
        return this.buildingName;
    }

    @Override
    public void setCompanyName_or_buildingName(String CompanyName_or_buildingName) {
        this.buildingName=CompanyName_or_buildingName;
    }

    @Override
    public String getDoorNumber_or_residentialNumber() {
        return this.DoorNumber;
    }

    @Override
    public void setDoorNumber_or_residentialNumber(String DoorNumber_or_residentialNumber) {
        this.DoorNumber=DoorNumber_or_residentialNumber;
    }

}
