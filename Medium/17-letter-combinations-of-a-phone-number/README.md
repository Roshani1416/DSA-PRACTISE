# 17. Letter Combinations of a Phone Number

**Difficulty:** Medium
**Tags:** Hash Table, String, Backtracking
**Language:** java
**Problem:** [https://leetcode.com/problems/letter-combinations-of-a-phone-number/](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

## Description

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in **any order**.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

![](https://assets.leetcode.com/uploads/2022/03/15/1200px-telephone-keypad2svg.png)

 

**Example 1:**
    
    
    **Input:** digits = "23"
    **Output:** ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    

**Example 2:**
    
    
    **Input:** digits = "2"
    **Output:** ["a","b","c"]
    

 

**Constraints:**

  * `1 <= digits.length <= 4`
  * `digits[i]` is a digit in the range `['2', '9']`.

## Solution

```java
class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new ArrayList<>();

        if(digits.length()==0){
            return ans;
        }

        String[] keypad={
            "",
            "",
            "abc",
            "def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };

        backtrack(digits,0,"",ans,keypad);

        return ans;
    }


    public void backtrack(String digits,int index,String current , List<String> ans , String[] keypad){

        if(index==digits.length()){
            ans.add(current);
            return;
        }

        String letters = keypad[digits.charAt(index)-'0'];

        for(int i = 0;i<letters.length();i++){

            char ch = letters.charAt(i);

            backtrack(digits,index+1,current+ch,ans,keypad);
        }
    }
}
```
