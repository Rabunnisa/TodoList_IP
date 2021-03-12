package com.sda.kth;

import java.util.Scanner;

public class Validator
{
    Scanner scanner = new Scanner(System.in); //todo ask nour about refactoring

    public int validateInt(int min, int max)
    {
        while(true)
        {
            try
            {
                String input = scanner.nextLine();
                int res = Integer.parseInt(input); // nhis fdfd
                // use min an dmax
                return res;
            }
            catch(NumberFormatException e)
            {
                System.out.println("please enter a correct the number");
            }
        }
    }

    public String validateString()
    {
        while(true)
        {
            String input = scanner.nextLine();
            if (! input.equals(""))
                return input;
            else
                System.out.println("...."); //todo

        }
    }




}
