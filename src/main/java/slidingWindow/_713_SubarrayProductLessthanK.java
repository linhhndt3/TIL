package slidingWindow;

public class _713_SubarrayProductLessthanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int rs = 0;
        int startWindow = 0;
        int product = 1;
        for (int endWindow = 0; endWindow < nums.length; endWindow++) {
            product = product * nums[endWindow];
            if (product >= k) {
                int numberOfWay = 0;
                if (product >= k) {
                    numberOfWay = numberOfSubset(endWindow - startWindow);
                }
                rs += numberOfWay;
                System.out.println("sW="+startWindow);
                while (product >= k) {
                    System.out.println("eW="+endWindow);
                    product = product / nums[startWindow];
                    startWindow++;
                }
            } else {
                if (endWindow == nums.length - 1) {
                    int numberOfWay = numberOfSubset(endWindow - startWindow + 1);
                    rs += numberOfWay;
                    return rs;
                }
            }
        }
        return rs;
    }

    private int numberOfSubset(int n) {
        if (n < 0) {
            return 0;
        }
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        new _713_SubarrayProductLessthanK().numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100);
    }
}
