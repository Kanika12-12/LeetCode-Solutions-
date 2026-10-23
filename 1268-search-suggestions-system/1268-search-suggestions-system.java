class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        
        int left = 0;
        int right = products.length - 1;
        
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }
            
            List<String> suggestions = new ArrayList<>();
            for (int j = left; j <= Math.min(left + 2, right); j++) {
                suggestions.add(products[j]);
            }
            
            result.add(suggestions);
        }
        
        return result;
    }
}