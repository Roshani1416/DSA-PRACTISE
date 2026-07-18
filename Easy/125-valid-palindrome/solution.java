class Solution {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }

        String s1 = sb.toString();

        return palindrome(s1, 0, s1.length() - 1);
    }

    public boolean palindrome(String s1, int low, int high) {

        // Base case
        if (low >= high) {
            return true;
        }

        if (s1.charAt(low) != s1.charAt(high)) {
            return false;
        }

        return palindrome(s1, low + 1, high - 1);
    }
}
