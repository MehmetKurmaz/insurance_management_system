package Accounts;

import Address.Address;
import Address.AddressMeneger;
import İnsurance.İnsurance;
import java.time.LocalDateTime;
import java.util.*;


public abstract class Account implements Address{
    private  Users user;
    static Address Address;
    private List<İnsurance> userInsuranceList;

    private static HashMap<String, ArrayList<Users>> accountList= new HashMap<>(){
        {
            put("Bireysel",new ArrayList<>());
            put("Kurumsal",new ArrayList<>());
        }
    };
    Account(Users users){
        this.user=users;
        this.userInsuranceList=new ArrayList<>();
    }

    public static void Start(){
        boolean status=true;
        while (status) {
            System.out.println("Patika Sigorta Acentesine Hoş Geldiniz..\nYapmak istediğiniz İşlem Türünü Seçiniz :\n1-Bireysel Giriş\n2-Kurumsal Giriş\n3-Üye Ol\n4-Çıkış");
            Scanner scanner = new Scanner(System.in);
            int Select = scanner.nextInt();
            switch (Select) {
                case 1:
                    Account.individualLogin();
                    break;
                case 2:
                    Account.corporateLogin();
                    break;
                case 3:
                    Account.membershipType();
                    break;
                case 4:System.out.println("Tekrar Görüşünceye Kadar Hoşça Kalın...");
                    status = false;

                    break;
            }
        }
    }
    public static void userProfile(Users users){
        boolean status=true;
        while (status) {
            System.out.println("---------------------------------KULLANICI PROFİLİ-------------------------------------");
            System.out.println("Adı :" + users.getFirst_name());
            System.out.println("Soyadı :" + users.getLast_name());
            System.out.println("Mesleği :" + users.getJob());
            System.out.println("Son Aktif olduğu zaman :" + users.getStrLastLoginİndividual());
            System.out.println("---------------------------------ADRES BİLGİLERİ---------------------------------------");

            if (users.getUsersAddressList() != null) {
                for (Address address : users.getUsersAddressList()) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("İL :" + address.getProvince_name() + "\nİLÇE :" + address.getDistrict_name() +
                            "\nMAHALLE :" + address.getNeighbourhood_name() + "\nSOKAK :" + address.getStreet_name() +
                            "\nBİNA ADI :" + address.getCompanyName_or_buildingName() + "\nKAPI NO :" + address.getDoorNumber_or_residentialNumber());
                    System.out.println("-------------------------------------------------------------------------------");
                }
            } else System.out.println(users.getFirst_name() + "'in Adres Listesinde Gösterilecek Eleman yok");

            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("1-Sigorta İşlemleri \n2-Adres Ekle\n3-Adres Sil\n4-Çıkış");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    İnsuranceTransaction(users);
                    break;
                case 2:
                    AddressMeneger.addressAdd(users);
                    break;
                case 3:
                    AddressMeneger.deleteAddressİndividual(users);
                    break;
                case 4: Start();
                    break;
            }
        }
    }
    public static void companyProfile(Users users){
        boolean status=true;
        while (status) {
            System.out.println("---------------------------------ŞİRKET PROFİLİ-------------------------------------");
            System.out.println("Adı :" + users.getCompanyName());
            System.out.println("Sektör :" + users.getSector());
            System.out.println("Son Aktif olduğu Zaman :" + users.getStrLastLoginCorporate());

            System.out.println("---------------------------------ADRES BİLGİLERİ---------------------------------------");
            if (users.getUsersAddressList() != null) {
                for (Address address : users.getUsersAddressList()) {
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("İL :" + address.getProvince_name() + "\nİLÇE :" + address.getDistrict_name() +
                            "\nMAHALLE :" + address.getNeighbourhood_name() + "\nSOKAK :" + address.getStreet_name() +
                            "\nYERLEŞKE NO :" + address.getDoorNumber_or_residentialNumber());
                    System.out.println("-------------------------------------------------------------------------------");
                }
            } else System.out.println(users.getFirst_name() + "'Adres Listesinde Gösterilecek Eleman Yok...");
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("1-Sigorta İşlemleri\n2-Adres Ekle\n3-Adres Sil\n4-Çıkış");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    İnsuranceTransaction(users);
                    break;
                case 2:
                    AddressMeneger.addressAdd(users);
                    break;
                case 3:
                    AddressMeneger.deleteAddressCorporate(users);
                    break;
                case 4:
                    Start();
                    break;
            }
        }

    }
    public static void membershipType(){
        System.out.println("Üyelik Tipini Seçiniz :\n1-Bireysel Üyelik\n2-Kurumsal Üyelik");
        Scanner scanner=new Scanner(System.in);
        int select=scanner.nextInt();
        switch (select){
            case 1:individualMember();
            break;
            case 2:corporateMember();
            break;
        }
    }
    public static void individualMember(){
        Users users=new Users();
        Scanner scanner=new Scanner(System.in);
        System.out.print("İsim :");
        users.setFirst_name(scanner.nextLine());
        System.out.print("Soyisim :");
        users.setLast_name(scanner.nextLine());
        System.out.print("Yaşınız :");
        users.setAge(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Mesleğiniz :");
        users.setJob(scanner.nextLine());
        System.out.print("email :");
        users.setEmail(scanner.nextLine());
        System.out.print("Şifre Oluştur :");
        users.setPassword(scanner.nextLine());
        AddressMeneger.addressAdd(users);
        try {
            accountList.get("Bireysel").add(users);
            System.out.println("-----------------------------------------------------------------------------");
            System.out.println("Bireysel Kullanıcı Üyeliği Başarılı ile Oluşturuldu..");
            System.out.println("-----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void corporateMember(){
        Users users=new Users();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Şirket Adını Giriniz :");
        users.setCompanyName(scanner.nextLine());
        System.out.print("Şirket Emaili Giriniz :");
        users.setCompanyEmail(scanner.nextLine());
        System.out.print("Sektör Belirtiniz :");
        users.setSector(scanner.nextLine());
        System.out.print("Şifre Oluştur :");
        users.setPassword(scanner.nextLine());
        AddressMeneger.addressAdd(users);
        try {
            accountList.get("Kurumsal").add(users);
            System.out.println("----------------------------------------------------------------------------");
            System.out.println("Kurumsal Kullanıcı Üyeliği Başarı ile Oluşturuldu..");
            System.out.println("----------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void individualLogin(){
        System.out.print("Email Adresini Giriniz :");
        Scanner scanner=new Scanner(System.in);
        String inputEmail=scanner.nextLine();
        System.out.print("Şifre Giriniz :");
        String inputPassword=scanner.nextLine();
        List<Users>list=accountList.get("Bireysel");
        for (Users users:list){

            if (users.getEmail().equals(inputEmail)&&users.getPassword().equals(inputPassword)){
                users.setLastLogin(users.getLoginTimeList().get(users));
                if (users.getLoginTimeList()==null){
                    users.setLastLogin(users.getNowTime());
                }
                users.setNowTime(LocalDateTime.now());
                users.setFirstLogin(users.getNowTime());
                users.getLoginTimeList().put(users,users.getFirstLogin());
                users.setLoginStatus(true);
                Account.userProfile(users);
            }else {
                System.out.println("Hatalı Giriş Yaptınız..!\nLütfen Bilgilerinizi Kontrol Edip Tekrar Deneyiniz..");
            }

        }

    }
    public static void corporateLogin(){
        System.out.print("Email Adresini Giriniz :");
        Scanner scanner=new Scanner(System.in);
        String inputEmail=scanner.nextLine();
        System.out.print("Şifre Giriniz :");
        String inputPassword=scanner.nextLine();
        List<Users>list=accountList.get("Kurumsal");
        for ( Users users:list){

            if (users.getCompanyEmail().equals(inputEmail)&&users.getPassword().equals(inputPassword)){
                users.setLastLogin(users.getLoginTimeList().get(users));
                if (users.getLoginTimeList()==null){
                    users.setLastLogin(users.getNowTime());
                }
                users.setNowTime(LocalDateTime.now());
                users.setFirstLogin(users.getNowTime());
                users.getLoginTimeList().put(users,users.getFirstLogin());
                users.setLoginStatus(true);
                Account.companyProfile(users);

            }else {
                System.out.println("Hatalı Giriş Yaptınız...");
            }
        }
    }
    public static void İnsuranceTransaction(Users users){
        boolean status=true;
        while (status) {
            System.out.println("1-Sigortalarımı Listele\n2-Araç Sigortası Satın Al\n3-Konut Sigortası Satın Al\n4-Sağlık Sigotası Satın Al\n5-Seyahat Sigortası Satın Al\n6-Çıkış");
            Scanner scanner = new Scanner(System.in);
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    insuranceListWiew(users);
                    break;
                case 2:
                    İnsurance.insuranceCarBuy(users);
                    break;
                case 3:
                    İnsurance.insuranceHousingBuy(users);
                    break;
                case 4:
                    İnsurance.insuranceHealthBuy(users);
                    break;
                case 5:
                    İnsurance.insuranceHTravelBuy(users);
                    break;
                case 6: status=false;
            }
        }
    }
    public static void insuranceListWiew(Users users){
        boolean status=true;
        while (status) {
            if (users.getGetUserİnsuranceList().isEmpty()) {
                System.out.println("--------------------------------------------------------------------");
                System.out.println("Listenizde Gösterilecek eleman bulunmamaktadır..");
                System.out.println("---------------------------------------------------------------------");
            } else {
                System.out.println("-------------------------------------SİGORTA LİSTENİZ-------------------------------");
                for (İnsurance list : users.getGetUserİnsuranceList()) {
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.println("Sigorta Adı : " + list.getInsuranceName());
                    System.out.println("Sigorta Fiyatı : " + list.getInsurancePrice());
                    System.out.println("Sigorta Başlangıç Tarihi : " + list.getInsuranceStartDate());
                    System.out.println("Sigorta Bitiş Tarihi : " + list.getInsuranceFinishDate());
                    System.out.println("------------------------------------------------------------------------------------");
                }
            }
            System.out.println("Çıkış Yapmak İçin 1'e Basınız..");
            Scanner scanner=new Scanner(System.in);
            int select=scanner.nextInt();
            if (select==1){
                status=false;
            }else System.out.println("Geçerli Bir Giriş Yapınız...");
        }
    }


    public List<İnsurance> getUserInsuranceList() {
        return userInsuranceList;
    }

    public void setUserInsuranceList(List<İnsurance> userInsuranceList) {
        this.userInsuranceList = userInsuranceList;
    }

    public Users getUser() {
        return this.user;
    }

    public void setUser(Users user) {
        this.user = user;
    }


    public static HashMap<String, ArrayList<Users>> getAccountList() {
        return accountList;
    }

    public static void setAccountList(HashMap<String, ArrayList<Users>> accountList) {
        Account.accountList = accountList;
    }


}
