/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.


*/


class Solution {
    public String frequencySort(String s) {
        TreeMap<Character, Integer> frequency = new TreeMap<>();
        
        for(char c: s.toCharArray()){
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> orderFreq = new PriorityQueue<>((x, y) -> 
                                frequency.get(y) - frequency.get(x));
        
        orderFreq.addAll(frequency.keySet());
        
        StringBuilder result = new StringBuilder();
        while(!orderFreq.isEmpty()){
            char temp = orderFreq.remove();
            for(int i=0;i<frequency.get(temp);i++)
                result.append(temp);
        }
        
        return result.toString();
    }
}
