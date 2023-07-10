public class Test {


    public static void main(String[] args) {

        if(args.length > 0) {
            System.out.println(args.length);
        }
        float aFloatNumber = 0.051011111111123f;
        System.out.println(aFloatNumber);

        aFloatNumber = 0.0510f;

        System.out.printf("%.8f",aFloatNumber);

        double total = 0.05;

//        for (int i = 0; i < 100; i++) {
//            total += 0.2;
//        }
//        System.out.println("total = " + total);


        String s1 = "yes" ;
        String s2 = "yes" ;
        String s3 = new String ( s1);

        System.out.println(s1==s2);

        int g = 3;
        System.out.println(++g*8);

        int[] arr = new int[]{1,2,3,4,5};

        for(int i = 0; i < arr.length - 2; ++i) {
            System.out.println(arr[i]);
        }

        int var1 = 5;
        int var2 = 6;

        if((var1 = 1) == var2 ) {

        } else {
            System.out.println(++var1);
        }
    }

    private int testMethod() {
        int i;
       i = testMethod();
        return i;
    }

}