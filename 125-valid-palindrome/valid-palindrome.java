class Solution {
    public boolean isPalindrome(String s) {

        String fil = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        StringBuilder newstr = new StringBuilder(fil);

        String rev = newstr.reverse().toString();

        return fil.equals(rev);

    }
}