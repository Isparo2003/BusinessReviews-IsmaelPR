package main;

import data.*;

import java.util.Arrays;
import java.util.Scanner;

public class Management {
    public Business[] businesses = new Business[6] ;
    public User[] users = new User[10] ;

    public void initialize(){
        //CREATE THE USERS
        users[0] = new User( "User1" , "contraseña"  );
        users[1] = new User( "User2" , "contraseña"  );
        users[2] = new User( "User3" , "contraseña"  );
        users[3] = new User( "User4" , "contraseña"  );
        users[4] = new User( "User5" , "contraseña"  );
        users[5] = new User( "User6" , "contraseña"  );
        users[6] = new User( "User7" , "contraseña"  );
        users[7] = new User( "User8" , "contraseña"  );
        users[8] = new User( "User9" , "contraseña"  );
        users[9] = new User( "User10" , "contraseña"  );

        //CREATE THE REVIEWS
        Review[] Positivereviews1 = new Review[2];
        Positivereviews1[0] = new Review( users[0] , "It's a great place" , 5 );
        Positivereviews1[1] = new Review( users[2] , "I love this place :)" , 4 );

        Review[] Positivereviews2 = new Review[2];
        Positivereviews2[0] = new Review( users[0] , "It's a great place" , 5 );
        Positivereviews2[1] = new Review( users[2] , "I love this place :)" , 4 );

        Review[] Positivereviews3 = new Review[2];
        Positivereviews3[0] = new Review( users[0] , "It's a great place" , 5 );
        Positivereviews3[1] = new Review( users[2] , "I love this place :)" , 4 );

        Review[] Negativevereviews1 = new Review[2];
        Negativevereviews1[0] = new Review( users[0] , "I hate this place so much , you cant imagine" , 1 );
        Negativevereviews1[1] = new Review( users[1] , "I don't like this business , that much" , 2 );

        Review[] Negativevereviews2 = new Review[2];
        Negativevereviews2[0] = new Review( users[0] , "I hate this place so much , you cant imagine" , 1 );
        Negativevereviews2[1] = new Review( users[1] , "I don't like this business , that much" , 2 );

        Review[] Negativevereviews3 = new Review[2];
        Negativevereviews3[0] = new Review( users[0] , "I hate this place so much , you cant imagine" , 1 );
        Negativevereviews3[1] = new Review( users[1] , "I don't like this business , that much" , 2 );

        //CREATE THE BUSINESSES
        businesses[0] = new Restaurant( "Bar Manolo" , "Asturias" , Positivereviews1 , "Spanish" );
        businesses[1] = new Restaurant( "Bar Paco" , "Logroño" , Negativevereviews1 , "Spanish" );
        businesses[2] = new Hairdresser( "Peluquería Paco" , "Alicante" , Positivereviews2 , true );
        businesses[3] = new Hairdresser( "Peluquería Manolo" , "Madrid" , Negativevereviews2 , false );
        businesses[4] = new Garage( "Garage Manolo" , "Barcelona" , Negativevereviews3 , 30 );
        businesses[5] = new Garage( "Garage Manolo" , "Girona" , Positivereviews3 , 2 );

    }
    public User User_login (String login, String password){
        for ( int i = 0 ; i < users.length ; i++){
            if ( login.equals(users[i].getLogin()) && password.equals(users[i].getPsswrd()) ){
                return users[i];
            }
        }
        return null;
    }
    public void showBusinesses ( ){
        for ( int i = 0 ; i < 6 ; i++ ){
            System.out.println( businesses[i].toString() );
            System.out.println("");
        }
    }
    public void showReviews ( User login){
        for ( int i = 0 ; i < 6 ; i++ ){
            System.out.println( businesses[i].getName());
            for ( Review r: businesses[i].getReviews() ){
                if ( r.getUser() == login ){
                    System.out.println( r.toString());
                }
            }
            System.out.println("");
        }
    }
    public void OrderByRating ( String tipo){
        if ( tipo.equals("1") ){
            for ( int i = 0 ; i < 6 ; i++ ){
                if ( businesses[i].getClass() == Restaurant.class ){
                    System.out.println( businesses[i].toString() );
                    System.out.println("");
                }
            }
        }
        if ( tipo.equals("2") ){
            for ( int i = 0 ; i < 6 ; i++ ){
                if ( businesses[i].getClass() == Hairdresser.class ){
                    System.out.println( businesses[i].toString() );
                    System.out.println("");
                }
            }
        }
        if ( tipo.equals("3") ){
            for ( int i = 0 ; i < 6 ; i++ ){
                if ( businesses[i].getClass() == Garage.class ){
                    System.out.println( businesses[i].toString() );
                    System.out.println("");
                }
            }
        }
    }
    public void ListaNegociosSimple(){
        for ( int i = 0 ; i < 6 ; i++ ){
            System.out.println(i + " " + businesses[i].getName() );
        }
    }
    public void EditReview( int negocio , User user){
        Scanner sc = new Scanner(System.in);
        for ( int i = 0 ; i < businesses[negocio].reviews.length ; i++ ){
            if ( businesses[negocio].reviews[i].getUser() == user ){
                System.out.println(businesses[negocio].reviews[i].toString());
            }
        }
        int change;
        System.out.println("- Chande rating(1) or comment(2)? ");
        change = sc.nextInt();
        if ( change == 1 ){
            int newRating;
            System.out.println("- New rating: ");
            newRating = sc.nextInt();
            for ( int i = 0 ; i < businesses[negocio].reviews.length ; i++ ){
                if ( businesses[negocio].reviews[i].getUser() == user ){
                    businesses[negocio].reviews[i].setRating(newRating);
                    businesses[negocio].reviews[i].setComment(businesses[negocio].reviews[i].getComment());
                }
            }
        }
        if ( change == 2 ){
            Scanner scaner = new Scanner(System.in);
            String newComment;
            System.out.println("- New comment: ");
            newComment = scaner.nextLine();
            for ( int i = 0 ; i < businesses[negocio].reviews.length ; i++ ){
                if ( businesses[negocio].reviews[i].getUser() == user ){
                    businesses[negocio].reviews[i].setComment(newComment);
                    businesses[negocio].reviews[i].setRating(businesses[negocio].reviews[i].getRating());
                }
            }
        }
    }
}
