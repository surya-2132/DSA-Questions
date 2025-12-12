package Hashing.Easy;

public class SumOfHighestAndLowestFreqElem {
    public static void main(String[] args) {
        int[] nums = {0, 9, 7, 7, 8, 8, 8};
        System.out.println("Sum of Least & Highest occurring element itself: "
                + sumHighestAndLowestFrequencyElements(nums));

        System.out.println("Sum of Least & Highest occurring element's frequency: "
                + sumHighestAndLowestFrequency(nums));
    }

    public static int sumHighestAndLowestFrequency(int[] nums) {
        System.out.print(HighestOccElem.mostFrequentElementOptimal(nums) +" + ");
        System.out.println(LeastOccElem.leastOccElemOptimal(nums));
        return HighestOccElem.mostFrequentElementOptimal(nums)
                + LeastOccElem.leastOccElemOptimal(nums);
    }

    public static int sumHighestAndLowestFrequencyElements(int[] nums) {
        System.out.print(HighestOccElem.mostFrequentElementBetter(nums)+" + ");
        System.out.println(LeastOccElem.leastOccElemBetter(nums));
        return HighestOccElem.mostFrequentElementBetter(nums)
                + LeastOccElem.leastOccElemBetter(nums);
    }

}