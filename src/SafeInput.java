import java.util.Scanner;

public class SafeInput
{ public static String getNonZerolenString(Scanner pipe, String prompt)
{ String retString = "";
do {
    System.out.println ("\n" + prompt + ": ");
    retString = pipe.nextLine ();
}while (retString.length ()==0);
return retString;
}
public static int getInt(Scanner pipe,String prompt)
{
    int retVal =0;
    String trash ="";
    boolean done = false;
    do {
        System.out.println ("\n" + prompt + ": ");
        if (pipe.hasNextInt())
        {retVal = pipe.nextInt ();
            pipe.nextLine ();
        done= true;}
        else
        {trash = pipe.nextLine ();
            System.out.println ("you must enter an int: "+ trash);}

    }while (!done);
    return retVal;
}
public static double getDouble(Scanner pipe,String prompt)
{
    double retVal =0;
    String trash ="";
    boolean done = false;
    do {
        System.out.println ("\n" + prompt + ": ");
        if (pipe.hasNextDouble ())
        {
            retVal = pipe.nextDouble();
            pipe.nextLine ();
            done= true;
        }
        else
        {trash = pipe.nextLine ();
            System.out.println ("you must enter a double: "+ trash);}

    }while (!done);
    return retVal;
}
public static int getRangedInt(Scanner pipe, String prompt, int low , int high)
{
    int retVal =0;
    String trash ="";
    boolean done = false;
    do
    {
        System.out.println ("\n" + prompt + "[" + low + "-" + high + "]: ");
        if (pipe.hasNextInt ())
        {retVal = pipe.nextInt ();
        pipe.nextLine ();
        if(retVal>=low && retVal<= high)
        {done = true;}
        else
        {
            System.out.println ("\nNumber is out of range ["+ low +"-" + high +"]: "+ retVal);
        }
        }else {trash= pipe.nextLine ();
            System.out.println ("you must enter an int: "+ trash);
        }
    }while (!done);
    return retVal;
}
public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
{
    double retVal =0;
    String trash ="";
    boolean done = false;
    do {
        System.out.println ("\n" + prompt + "[" + low + "-" + high + "]: ");
        if (pipe.hasNextDouble ())
        {retVal = pipe.nextDouble ();
            pipe.nextLine ();
            if(retVal>=low && retVal<= high)
            {done = true;}
            else
            {
                System.out.println ("\nNumber is out of range ["+ low +"-" + high +"]: "+ retVal);
            }
        }else {trash= pipe.nextLine ();
            System.out.println ("you must enter a double: "+ trash);
        }
    }while(!done);
    return retVal;
}
public static boolean getYNConfirm(Scanner pipe, String prompt)
{
    boolean retVal = true;
    String response ="";
    boolean gotAVal = false;
    do
    {
        System.out.println ("\n" + prompt + "[Y/N]");
        response = pipe.nextLine ();
        if (response.equalsIgnoreCase ( "y" ))
        {gotAVal = true;
        retVal = true;
        }
        else if (response.equalsIgnoreCase ( "N" ))
        {
            gotAVal= true;
            retVal= false;
        }
        else
        {
            System.out.println (" You must enter {Y/N}; + response");
        }
    }while(!gotAVal);
    return retVal;
}
public static String getRegExString(Scanner pipe,String prompt,String regExPattern)
{
    String response ="";
    boolean gotAVal = false;
do {
    System.out.println ("\n" + prompt + ": ");
    response = pipe.nextLine ();
    if (response.matches ( regExPattern ))
    {gotAVal= true;}
    else {
        System.out.println ("\n"+ response +"must match the pattern"+ regExPattern);
        System.out.println ("TRY AGAIN!");
    }
}while(!gotAVal);
return response;
}
    public static String prettyHeader(String msg) {
        String header = "";
        System.out.println("\n" + msg + ": ");
        for (int c= 0; c < 1; c++) {
            for (int f = 0; f <= 60; f++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int c= 0; c < 1; c++) {

            System.out.print("***");
            for (int i = 0; i <= 13; i++) {
                System.out.print(" ");
            }
            System.out.print(msg);
            for (int i = 0; i <= 20; i++) {
                System.out.print(" ");
            }
            System.out.print("***");
        }
        for (int c= 0; c < 1; c++) {
            System.out.println(" ");
            for (int i = 0; i<= 60; i++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        return header;
}
}
