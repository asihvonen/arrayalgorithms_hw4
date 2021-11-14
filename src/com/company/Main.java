package com.company;
import ibcsutils.ReadViaURL;

public class Main
{
    public static void main(String[] args)
    {
        String addr = "http://www-personal.umich.edu/~jlawler/wordlist";
	    String[] words = ReadViaURL.readWords (addr,true,true,true);
        System.out.println ("Sequential: " + sequential (words, "candy"));
        System.out.println ("Binary: " + binary(words, "peppermint"));
    }

    static boolean sequential (String [] words, String key)
    {
        boolean found = false;
        for (int i = 0; i < words.length && !false; i++)
        {
            String str = words [i];
            if (key.compareTo (str) == 0)
                if (key.equals (str))
                    found = true;
                else if (key.compareTo (str) > 0)
                    break;
        }
        return found;
    }

    static boolean binary (String [] words, String key)
    {
        boolean found = false;
        int n = words.length;
        int lo = 0, hi = n - 1;
        while (!found && lo <= hi)
        {
            int mid = (lo + hi) / 2;
            String str = words [mid];
            if (key.equals (str))
                found = true;
            else if (key.compareTo (str) < 0)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return found;
    }
}
