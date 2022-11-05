public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.characterReplacement("ABAB", 2));
        System.out.println(s.characterReplacement("AABABBA", 1));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 3));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 4));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 6));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 2));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 1));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 0));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 7));
        System.out.println(s.characterReplacement("XXXYYYZZZZYYYXXX", 16));
        System.out.println(s.characterReplacement("ABABABABABABABAB", 8));
        System.out.println(s.characterReplacement("ABABABABABABABAB", 1));
        System.out.println(s.characterReplacement("AAAABXAAAA", 1));
        System.out.println(s.characterReplacement("AAAABXAAAA", 0));
        System.out.println(s.characterReplacement("AAAABXAAAA", 2));
        System.out.println(s.characterReplacement("AAAABXAAAA", 10));
        System.out.println(s.characterReplacement("AAAABXAAAA", 3));
        System.out.println(s.characterReplacement("A", 0));
        System.out.println(s.characterReplacement("A", 1));
        System.out.println(s.characterReplacement("A", 2));
        System.out.println(s.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}