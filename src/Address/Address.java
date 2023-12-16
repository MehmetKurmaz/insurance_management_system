package Address;

public  interface Address {

    public String getProvince_name();
    public void setProvince_name(String province_name);
    public String getDistrict_name();
    public void setDistrict_name(String district_name);
    public String getNeighbourhood_name();
    public void setNeighbourhood_name(String neighbourhood_name);
    public String getStreet_name();
    public void setStreet_name(String street_name);
    public String getCompanyName_or_buildingName();
    public void setCompanyName_or_buildingName(String companyName_or_buildingName);
    public String getDoorNumber_or_residentialNumber();
    public void setDoorNumber_or_residentialNumber(String doorNumber_or_residentialNumber);
}
