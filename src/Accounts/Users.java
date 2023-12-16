package Accounts;

import Address.Address;
import İnsurance.İnsurance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Users {

    private String first_name;
    private String last_name;
    private String job;
    private String email;
    private String password;
    private int age;
    private String companyName;
    private String companyEmail;
    private String sector;
    private boolean loginStatus=false;
    private List<Address> usersAddressList;
    private List<İnsurance> getUserİnsuranceList=new ArrayList<>();
    private Map<Users,LocalDateTime> loginTimeList=new HashMap<>();
    private LocalDateTime firstLogin;
    private LocalDateTime lastLogin;
    private LocalDateTime nowTime;
    private String strLastLoginİndividual;
    private String strLastLoginCorporate;

    public Users(){
        this.usersAddressList=new ArrayList<Address>();
    }
    Users(String companyName,String companyEmail,String sector,String password){
        this.companyName=companyName;
        this.companyEmail=companyEmail;
        this.sector=sector;
        this.password=password;
        this.usersAddressList=new ArrayList<Address>();
    }
    Users(String first_name,String last_name,String job,String email,String password,int age){
        this.first_name=first_name;
        this.last_name=last_name;
        this.job=job;
        this.email=email;
        this.password=password;
        this.age=age;
        this.usersAddressList=new ArrayList<Address>();

    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getUsersAddressList() {
        return usersAddressList;
    }

    public void setUsersAddressList(ArrayList<Address> usersAddressList) {
        this.usersAddressList = usersAddressList;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public  void setLastLogin(LocalDateTime lastLogin) {

        this.lastLogin = lastLogin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public HashMap<Users, LocalDateTime> getLoginTimeList() {
        return (HashMap<Users, LocalDateTime>) loginTimeList;
    }

    public void setLoginTimeList(HashMap<Users, LocalDateTime> loginTimeList) {
        this.loginTimeList = loginTimeList;
    }

    public LocalDateTime getNowTime() {
        return nowTime;
    }

    public void setNowTime(LocalDateTime nowTime) {
        this.nowTime = nowTime;
    }

    public LocalDateTime getFirstLogin() {
        return firstLogin;
    }
    public void setFirstLogin(LocalDateTime firstLogin) {
        this.firstLogin = firstLogin;
    }

    public String getStrLastLoginİndividual() {
        String str = null;

        List<Users>list=Account.getAccountList().get("Bireysel");
        for (Users users:list){
            if (users.getLastLogin()!=null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy");
                str = users.getLastLogin().format(formatter);
            }
        }

        return strLastLoginİndividual = str;
    }

    public void setStrLastLoginİndividual(String strLastLogin) {
        this.strLastLoginİndividual = strLastLogin;
    }

    public String getStrLastLoginCorporate() {
        String str = null;

        List<Users>list=Account.getAccountList().get("Kurumsal");
        for (Users users:list){
            if (users.getLastLogin()!=null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss-dd/MM/yyyy");
                str = users.getLastLogin().format(formatter);
            }
        }



        return strLastLoginCorporate=str;
    }

    public void setStrLastLoginCorporate(String strLastLoginCorporate) {
        this.strLastLoginCorporate = strLastLoginCorporate;
    }

    public List<İnsurance> getGetUserİnsuranceList() {
        return getUserİnsuranceList;
    }

    public void setGetUserİnsuranceList(List<İnsurance> getUserİnsuranceList) {
        this.getUserİnsuranceList = getUserİnsuranceList;
    }
}
