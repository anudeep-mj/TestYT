package challenges;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * Example:
 *
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 *
 * Then 4 is the first bad version.
 */
public class FirstBadVersion {
    /**
     * Brute force way would be: iterate from n -> 0. when first non-bad version, then return the version released after
     */
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    public static int firstBadVersion(int n) {
        return firstBadVersion(0, n);
    }

    private static int firstBadVersion(int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (isBadVersion(mid) && !isBadVersion(mid-1)) {
                return mid;
            }
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static boolean isBadVersion(int mid) {
        if (mid == 0) {
            return false;
        } else if (mid == 1) {
            return false;
        } else if (mid == 2) {
            return true;
        } else if (mid == 3) {
            return true;
        } else if (mid == 4) {
            return true;
        } else if (mid == 5) {
            return true;
        } else if (mid == 6) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        firstBadVersion(0, 6);
    }
}
