/**
 * @Author: ouyangyameng
 * @Date: 2023/1/17 13:39
 * @Version 1.0
 */
public class E28FindTheIndexOfTheFirstOccurrenceInAString {
    public static void main(String[] args) {
        System.out.println(new E28FindTheIndexOfTheFirstOccurrenceInAString().strStr("ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb", "abbabbbabaa"));
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        long hash = 0l;
        long cur = 0;
        long pow = 1;
        long p = (long) Math.pow(2, 32);
        for (int i = 0; i < needle.length(); i++) {
            hash = (hash * 26l + (needle.charAt(i) - 'a' + 1)) % p;
            cur = (cur * 26l + (haystack.charAt(i) - 'a' + 1)) % p;
            pow = (pow * 26l) % p;
        }
        if (hash == cur && (haystack.startsWith(needle))) {
            return 0;
        }
        int i = 1;
        int result = -1;
        while (i <= haystack.length() - needle.length()) {
            cur = ((cur * 26l - (haystack.charAt(i - 1) - 'a' + 1) * pow) + (haystack.charAt(i - 1 + needle.length()) - 'a' + 1)) % p;
            if (cur < 0) {
                cur += p;
            }
            if (hash == cur && (haystack.startsWith(needle, i))) {
                result = i;
                break;
            }
            i++;
        }
        return result;
    }
}
