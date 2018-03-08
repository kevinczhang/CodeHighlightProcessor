public class Solution {
    public String[] findWords(String[] words) {
        boolean[] inds = new boolean[words.length];
        int count = 0;
        for(int i = 0; i < words.length; i++){
            int wordLen = words[i].length();
            if(wordLen == 0) continue;
            int j = 0;
            int initalRow = getRowNum(words[i].charAt(j++));
            boolean rowChanged = false;
            while(j < wordLen){
            	if(initalRow != getRowNum(words[i].charAt(j++))){
            		rowChanged = true;
            		break;
            	}
            }
            if(!rowChanged){
            	inds[i] = true;
                count++;
            }
        }

        String[] res = new String[count];
        int ind = 0;
        for(int i = 0; i < words.length; i++){
            if(inds[i]){
                res[ind] = words[i];
                ind++;
            }
        }
        return res;
    }

    private int getRowNum(char c){
        char[] firstRow = {'Q', 'q', 'W', 'w', 'E', 'e', 'R', 'r', 'T', 't', 'Y', 'y', 'U', 'u', 'I', 'i', 'O', 'o', 'P', 'p'};
        char[] secondRow = {'A', 'a', 'S', 's', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h', 'J', 'j', 'K', 'k', 'L', 'l'};

        for(int i = 0; i < firstRow.length; i++){
            if(firstRow[i] == c) return 1;
        }

        for(int i = 0; i < secondRow.length; i++){
            if(secondRow[i] == c) return 2;
        }
        return 3;
    }
}