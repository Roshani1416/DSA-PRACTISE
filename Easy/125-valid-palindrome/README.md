# 125. Valid Palindrome

**Difficulty:** Easy
**Tags:** Two Pointers, String
**Language:** java
**Problem:** [https://leetcode.com/problems/valid-palindrome/](https://leetcode.com/problems/valid-palindrome/)

## Description

A phrase is a **palindrome** if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` _if it is a**palindrome** , or _`false` _otherwise_.

 

**Example 1:**
    
    
    **Input:** s = "A man, a plan, a canal: Panama"
    **Output:** true
    **Explanation:** "amanaplanacanalpanama" is a palindrome.
    

**Example 2:**
    
    
    **Input:** s = "race a car"
    **Output:** false
    **Explanation:** "raceacar" is not a palindrome.
    

**Example 3:**
    
    
    **Input:** s = " "
    **Output:** true
    **Explanation:** s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.
    

 

**Constraints:**

  * `1 <= s.length <= 2 * 105`
  * `s` consists only of printable ASCII characters.

## Solution

```java
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
```
