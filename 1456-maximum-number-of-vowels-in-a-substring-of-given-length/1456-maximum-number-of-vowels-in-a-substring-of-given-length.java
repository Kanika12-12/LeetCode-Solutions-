class Solution {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int currentVowels = 0;
        for(int i = 0; i < k ; i++){
           if(isVowel(chars[i])){
            currentVowels++;
           }
        }
        int maxVowels = currentVowels;
        for(int i =k; i < chars.length; i++){
            if(isVowel(chars[i])){
                currentVowels++;
            }
           
           if(isVowel(chars[i-k])){
            currentVowels--;
           }
           maxVowels = Math.max(maxVowels, currentVowels); }
        return maxVowels ;  
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}
}