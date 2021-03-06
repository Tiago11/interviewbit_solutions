// Longest non-repeating substring
// https://www.interviewbit.com/problems/longest-substring-without-repeat/
public class Solution {
	public int lengthOfLongestSubstring(String A) {

        int count = 0;
        int max = 0;
	    int n = A.length();
	    HashMap<Character, Integer> hashMap = new HashMap<>();
	    char c;
	    int prevIndex;

	    for (int i = 0; i < n; i++) {

	        c = A.charAt(i);

	        if (hashMap.containsKey(c)) {
	            prevIndex = hashMap.get(c);
	            count = Math.min(count + 1, i - prevIndex);
	            hashMap.put(c, i);
	        } else {
	            count++;
	            hashMap.put(c, i);
	        }

	        max = Math.max(max, count);
	    }

	    return max;
	}

	/**
		Use a sliding window strategy and use a hashset to account for the distinct letters
		Start with a left and right pointer at 0.  As you read A[right], determine if it's in the
		set.  If it is, that means you can't move forward anymore and have to move the left
		pointer up; shrinking the window till the distinct letter condition becomes true.

		Everytime the window grows, you can examine the difference between the right and left.
	
		Run time: O(n) and Space is O(p) where P is the number of distince characters 
	*/
	public int lengthOfLongestSubstring(String A) {
		// used to track distinct characters
		HashSet<Character> map = new HashSet<Character>();
		int l = 0;
		int r = 0;

		int maxLen = 0;

		while( l<= r &&  r  < input.length()) {
			Character c = input.charAt(r);
			if(map.contains(c)) {
				// Is the substring longer?
				maxLen = Math.max(maxLen, r-l);
				// keep shrinking window until you can remove
				// the duplicate character from the map
				while(l <= r && input.charAt(l) != c) {
					map.remove(input.charAt(l));
					l++;
				}
			} else {
				// increase the window
				map.add(c);
				r++;
			}
		}

		return maxLen;
	}
}
