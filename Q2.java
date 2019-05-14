public class Q2{

   // Return type of this function will be an int (positive number : greater, 0 : equal, negative number : less)
   public static int isVersionEqual( String version1, String version2){
    
     float fversion1 = Float.parseFloat(version1);
     float fversion2 = Float.parseFloat(version2);

    return Float.compare(fversion1, fversion2);
   }
    public static void main(String[] args) {
        // Test Cases:
        System.out.println("Test case equal, expected value is 0 and actual value is : " + isVersionEqual("1.1", "1.1"));
        System.out.println("Test case less than, expected value is -1 and actual value is : " + isVersionEqual("1.1", "1.2"));
        System.out.println("Test case greater than, expected value is 1 and actual value is : " + isVersionEqual("1.2", "1.1"));
        System.out.println("Test case equal highly precise numbers, expected value is 0 and actual value is : " + isVersionEqual("1.23456789", "1.23456789"));
        System.out.println("Test case integers, expected value is -1 and actual value is : " + isVersionEqual("1", "3"));
        System.out.println("Test case zero value, expected value is -1 and actual value is : " + isVersionEqual("0", "1.2"));
        System.out.println("Test case negative value, expected value is -1 and actual value is : " + isVersionEqual("-1", "1.2"));
        // I should have used a testing framework for the tests over here (eg junit) but due to time constraints on my side I manually written a bunch of cases.
}
}