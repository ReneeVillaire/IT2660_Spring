import java.util.Random;

public class Main {
    public static int[] Sort(int[] data) {
        //1) base case is if the data.length == 1
        if(data.length == 1) {
            return data;
        }
        else {
            var leftHandLength = Math.floorDiv(data.length, 2);
            var rightHandLength = data.length - leftHandLength;
            var rhIndex = leftHandLength;

/*            if(leftHandLength > 1)
                rhIndex = leftHandLength - 1;*/

            var lhData = split(data, 0, leftHandLength);
            var rhData = split(data, rhIndex, rightHandLength);
            var lhResult = Sort(lhData);
            var rhResult = Sort(rhData);
            var finalResult = Merge(lhResult, rhResult);
            return finalResult;
        }
    }

    public static int[] Merge(int[] lh, int[] rh) {
        int[] merged = new int[lh.length + rh.length];
        int lhIdx = 0;
        int rhIdx = 0;
        boolean lhRemaining = true;
        boolean rhRemaining = true;

        for(var idx = 0; idx < merged.length; idx++) {
            if(lhRemaining & rhRemaining) {
                //meaning there is still data in both
                if(lh[lhIdx] <= rh[rhIdx]) {
                    merged[idx] = lh[lhIdx];
                    lhIdx++;

                    if(lhIdx == lh.length)
                        lhRemaining = false;
                }
                else {
                    merged[idx] = rh[rhIdx];
                    rhIdx++;

                    if(rhIdx == rh.length)
                        rhRemaining = false;
                }
            }
            else if(lhRemaining) {
                //we only have elements in the LH remaining
                //and we know they're in sorted order, just copy them out
                merged[idx] = lh[lhIdx];
                lhIdx++;

                if(lhIdx == lh.length)
                    lhRemaining = false;
            }
            else {
                //there are only elements left in the RH
                //same as else if statement above
                merged[idx] = rh[rhIdx];
                rhIdx++;

                if(rhIdx == rh.length)
                    rhRemaining = false;
            }
        }

        return merged;
    }

    public static int[] split(int[] data, int startingIndex, int length) {
        //should error check but fuck that shit
        if(startingIndex < data.length) {
            int[] sub = new int[length];

            for(var idx = 0; idx < length; idx++)
                sub[idx] = data[startingIndex + idx];

            return sub;
        }
        else
            return null;
    }

    public static void printArray(int[] data) {
        System.out.print("Data is: ");

        for(var value : data)
            System.out.print(value + " ");

        System.out.println();
    }

    public static void main(String[] args) {
        //int[] testData = new int[] { 5, 25, 1, 0, 23, 30, 100, 45, 80, 8, 10, 9 };
        int[] testData = new int[100];
        Random random = new Random();

        for(var idx = 0; idx < testData.length; idx++)
            testData[idx] = Math.abs(random.nextInt(300));

        System.out.println("Unsorted array of length: " + testData.length);
        printArray(testData);
        System.out.println("Sorting data...");
        var result = Sort(testData);
        System.out.println("Data sorted.  Length is: " + result.length);
        printArray(result);
    }
}
