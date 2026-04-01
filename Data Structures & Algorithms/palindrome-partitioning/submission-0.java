
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);
        return res;
    }

    private void dfs(int i, String s, List<String> part, List<List<String>> res) {
        // If we've reached the end of the string, we found a valid partition
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        // Try every possible substring starting from index i
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                // If the substring s[i..j] is a palindrome, add it to our current path
                part.add(s.substring(i, j + 1));
                // Recurse to find the next palindromic substring starting from j + 1
                dfs(j + 1, s, part, res);
                // Backtrack: remove the last added substring to try other possibilities
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
