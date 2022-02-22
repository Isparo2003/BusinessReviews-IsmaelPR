package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
        management.initialize();
        Scanner sc = new Scanner(System.in);

        System.out.println(management.users[0].toString());
        String login ;
        boolean correctuser = false;
        do
        {
            System.out.println("Login: ");
            login = sc.nextLine();
            System.out.println("Password: ");
            String password = sc.nextLine();

            if ( management.User_login( login , password ) != null ) {
                correctuser = true;
                break;
            }else {System.out.println("Your User or Password are incorrect...");}
        }while( correctuser != true );

        String op = "";
        do
        {
            System.out.println(" --- MENU ---");
            System.out.println(" 1 -- My reviews ");
            System.out.println(" 2 -- Business list");
            System.out.println(" 3 -- Top rated businesses");
            System.out.println(" 4 -- Edit my review");
            System.out.println(" 5 -- Quit");
            System.out.println(" -----------");
            op = sc.nextLine();
            switch (op){
                case "1":
                    System.out.println(" --- Your reviews ---");
                    for ( int i = 0 ; i < management.users.length ; i++ ){
                        if ( management.users[i].getLogin().equals(login) ){
                            management.showReviews( management.users[i] );
                        }
                    }
                    break;
                case "2":
                    System.out.println(" --- Businesses ---");
                    management.showBusinesses();
                    break;
                case "3":
                    String tipo = "";
                    System.out.println(" ---  Top rated businesses ---");
                    System.out.println(" 1 - By restaurants");
                    System.out.println(" 2 - By Hairdessers");
                    System.out.println(" 3 - By Garage");
                    tipo = sc.nextLine();
                    management.OrderByRating( tipo );

                    break;
                case "4":
                    int business ;
                    management.ListaNegociosSimple();
                    System.out.println("- Choose a business number : ");
                    business = sc.nextInt();
                    for ( int i = 0 ; i < management.users.length ; i++ ){
                        if ( management.users[i].getLogin().equals(login) ){
                            management.EditReview(business , management.users[i]);
                        }
                    }

                    break;
                case "5":
                    System.exit(0);
                    break;
            }
        }while( op != "5" );
    }
}
