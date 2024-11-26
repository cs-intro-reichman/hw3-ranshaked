public class Algebra {
    public static void main(String args[]) {
        //Tests some of the operations
        System.out.println(plus(2,3));   // 2 + 3
        System.out.println(minus(7,2));  // 7 - 2
        System.out.println(minus(2,7));  // 2 - 7
        System.out.println(times(3,4));  // 3 * 4
        System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
        System.out.println(pow(5,3));      // 5^3
        System.out.println(pow(3,5));      // 3^5
        System.out.println(div(12,3));   // 12 / 3    
        System.out.println(div(5,5));    // 5 / 5  
        System.out.println(div(25,7));   // 25 / 7
        System.out.println(mod(25,7)); // 25 % 7 = 4
        System.out.println(mod(120,6));  // 120 % 6    
        System.out.println(sqrt(36));
        System.out.println(sqrt(263169));
        System.out.println(sqrt(76123));
    }  

    public static int plus(int x1, int x2) {
        while(x2>0)
        {
            x1++;
            x2--;
        }
        return x1;
    }

    public static int minus(int x1, int x2) {
        while(x2>0)
        {
            x1--;
            x2--;
        }
        return x1;
    }

    public static int times(int x1, int x2) {
        int x3 = x1;
        int x4 = x1;
        int x5 = x2;
        int x6 =x1;
        while(x5>1)
        {
            x3 =x4;
            while(x3>0)
            {
                x6++;
                x3--;
            }
            x5--;
        }
        return x6 ;
    }

    // Returns x^n (for n >= 0)
        public static int pow(int x, int n) {
            int x1 = x;
            for(int i = 1 ; i<n ; i++)
            {
                x1 = times(x1,x);
            }

        return x1;
    }

    public static int div(int x1, int x2) {
        int x = 1 ;
        while(times(x,x2) < x1)
        {
            x++;
        }
        if(times(x,x2) != x1)
        {
            x--;
        }
        return  x;
    }

        public static int mod(int x1, int x2) {
        int x3 = x1;
        int div = div(x1, x2);
        if(x2 > x1)
        {
        return x1;
        }else{
        int mod = minus(x3, Algebra.times(x2, div));
        return mod;
        }
    }
    public static int sqrt(int x) {
        int x1 = 1;
        int x2 = 1;
        while(times(x1,x2) < x)
        {
            x1++;
            x2++;
        }
        if(times(x1, x2) == x)
        {
        return x1;
        }else{
            x1--;
            return x1;
        }
    }         
}

