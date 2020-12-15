package service;

import constant.Constants;

import java.util.Scanner;

public class AskService {

    private static Scanner getScanner(){
       return new Scanner(System.in) ;
    }


           public static String whatUserWants() {
               System.out.println(Constants.WHAT_YOU_WANT);
               return getScanner().nextLine();
           }
    }
