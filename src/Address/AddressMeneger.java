package Address;

import Accounts.Account;
import Accounts.Users;
import java.util.Scanner;
public class AddressMeneger {


public static void addressAdd(Users users){

    System.out.println("Adres Ekle :\n1-Ev Adresi\n2-İş Adresi\n3-Çıkış");
    Scanner scanner=new Scanner(System.in);
    int select=scanner.nextInt();
    switch (select){
        case 1:homeAddressAdd(users);
        break;
        case 2:businessAddressAdd(users);
        break;
        case 3:
        default:System.out.println("Lütfen Geçerli bir Tercih yapınız..");

    }


}
public static void homeAddressAdd(Users users){
    Address homeAddress=new HomeAddress();
    System.out.print("İkamet ettiğiniz yerin :\nİL :");
    Scanner scanner=new Scanner(System.in);
    homeAddress.setProvince_name(scanner.nextLine());
    System.out.print("İLÇE :");
    homeAddress.setDistrict_name(scanner.nextLine());
    System.out.print("MAHALLE :");
    homeAddress.setNeighbourhood_name(scanner.nextLine());
    System.out.print("SOKAK :");
    homeAddress.setStreet_name(scanner.nextLine());
    System.out.print("BİNA ADI :");
    homeAddress.setCompanyName_or_buildingName(scanner.nextLine());
    System.out.print("KAPI NO :");
    homeAddress.setDoorNumber_or_residentialNumber(scanner.nextLine());
    try {
        users.getUsersAddressList().add(homeAddress);
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Ev Adresi Başarı ile eklendi..");
        System.out.println("---------------------------------------------------------------------");
    }catch (Exception e){
        System.out.println(e.getMessage());
    }


}
    public static void businessAddressAdd(Users users){
        Address businessAddress=new Business();
        System.out.print("İş Yerinizin :\nİL :");
        Scanner scanner=new Scanner(System.in);
        businessAddress.setProvince_name(scanner.nextLine());
        System.out.print("İLÇE :");
        businessAddress.setDistrict_name(scanner.nextLine());
        System.out.print("MAHALLE :");
        businessAddress.setNeighbourhood_name(scanner.nextLine());
        System.out.print("SOKAK :");
        businessAddress.setStreet_name(scanner.nextLine());
        System.out.print("ŞİRKET ADI :");
        businessAddress.setCompanyName_or_buildingName(scanner.nextLine());
        System.out.print("YERLEŞİM NO :");
        businessAddress.setDoorNumber_or_residentialNumber(scanner.nextLine());
        try {

            users.getUsersAddressList().add(businessAddress);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("İş Adresi Başarı ile eklendi..");
            System.out.println("------------------------------------------------------------------------");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
    public static void deleteAddressİndividual(Users users) {
        for (Address address : users.getUsersAddressList()) {
            try {
                users.getUsersAddressList().remove(address);
                System.out.println("---------------------------------------------------------------------------");
                System.out.println("Adres Silme İşlemi Başarılı..");
                System.out.println("---------------------------------------------------------------------------");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static void deleteAddressCorporate(Users users){
        try {
            for (Address address:users.getUsersAddressList()){
                users.getUsersAddressList().remove(address);
                System.out.println("-------------------------------------------------------------------------");
                System.out.println("Adres Silme İşlemi Başarılı..");
                System.out.println("-------------------------------------------------------------------------");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
