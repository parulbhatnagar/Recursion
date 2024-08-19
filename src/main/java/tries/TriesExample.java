package tries;

public class TriesExample {
    public static class Node{
        Node [] children;
        boolean eow;

        Node (){
            children = new Node[26];

            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    public static Node root = new Node();


    public static void insert(String word){

        Node curr = root;
        for (char letter : word.toCharArray()){
            int index = letter - 'a';

            if (curr.children[index] == null){
                curr.children[index] = new Node();
            }

            curr = curr.children[index];
        }

        curr.eow = true;


    }

    public static boolean search (String word){

        Node curr = root;
        for (char letter : word.toCharArray()){
            int index = letter - 'a';

            if (curr.children[index] == null){
                return false;
            }

            curr = curr.children[index];
        }
        return curr.eow == true;
    }

    public static boolean wordBreak (String key){
        // base condition

        if (key.length() == 0){
            return true;
        }

        for (int i = 1; i <= key.length(); i++){
            String first = key.substring(0, i);
            String second = key.substring(i);

            if (search(first)== true && wordBreak(second) == true){
                return true;
            }
        }
        return false;
    }


    public static boolean startsWith (String word){

        Node curr = root;
        for (char letter : word.toCharArray()){
            int index = letter - 'a';

            if (curr.children[index] == null){
                return false;
            }

            curr = curr.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
/*        String [] input = {"the", "a", "there", "their", "any"};
        String [] words = {"i", "like", "sam", "samsung", "mobile", "ice"};

        for(String word: words){
            insert(word);
        }

        System.out.println("Break words test - ilikesamsung = " + wordBreak("ilikesamsung"));
        System.out.println("Break words test - ilikesung = " + wordBreak("ilikesung"));

        System.out.println("startsWith test - sa = " + startsWith("sa"));

        System.out.println("startsWith test - sung = " + startsWith("sung"));

        System.out.println("Search in tries for word - there , result = " + search("samsung"));
        System.out.println("Search in tries for word - ant , result = " + search("i"));
        System.out.println("Search in tries for word - an , result = " + search("like"));*/

        //System.out.println("Count of unique sub strings - ababa = " + uniqueSubStrings("ababa"));

        //System.out.println("Count of unique sub strings - apple = " + uniqueSubStrings("apple"));

        // Longest Word with all prefixes

        //String [] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String [] words = {"a", "banana", "app"};

        for(String word: words){
            insert(word);
        }

        System.out.println("LongestWord with all prefixes  = " +( longestWordWithAppPrefix(root)));





    }

    private static String longestWordWithAppPrefix(Node root) {
        String returnString="";
        if (root == null ){
            return "";
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].eow==true ){
                // convert i + 'a' into a string, it should be a single letter
                // we will add that letter to the string
                returnString += String.valueOf((char)(i+'a'));
                returnString += longestWordWithAppPrefix(root.children[i]);
            }
        }
        if (returnString.length() == 0){
            return "";
        }

        return returnString.substring(0,returnString.length()-1);
    }

    private static int uniqueSubStrings(String input) {

        // traverse and collect all the suffixes and create a trie
        for (int i = 0; i < input.length(); i++) {
            insert(input.substring(i,input.length()));
        }

        // count the node of tries
        return count(root);
    }

    private static int count(Node root) {
        // base condition
        if (root==null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null){
                count += count(root.children[i]);
            }
        }
        return count+1;
    }

}

