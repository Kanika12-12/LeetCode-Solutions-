class Solution {
    public List<String> letterCombinations(String digits) {
         Map<Character, String> map = getMap();
         List<String> ans = new ArrayList<>();
         if(digits.length()==0)
          return ans;
         solve(0, digits, "", ans, map);
         return ans;   
    }
    private void solve(int i, String digits, String s, List<String> ans, Map<Character, String>map){
        if(i==digits.length()){
            ans.add(s);
            return;
        }
        for(char c: map.get(digits.charAt(i)).toCharArray()){
            String temp = new String(s);
            temp+=c;
            solve(i+1, digits, temp, ans, map);
        }
    }
    private Map<Character, String> getMap(){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        return map;}
}