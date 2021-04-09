package Hot100;

/**
 * @author wqf
 * @date 2021/3/28 12:45
 * @Email:284660487@qq.com
 */
public class Solution79 {

    public boolean exist(char[][] board, String word) {
        boolean[][] flags = new boolean[board.length][board[0].length];
        for(int positionX = 0; positionX < board.length; ++positionX){
            for (int positionY = 0; positionY < board[0].length; ++positionY){
                if(dfs(board, positionX, positionY, flags, word, 0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int positionX, int positionY, boolean[][] flags, String word, int wordIndex){
        if(flags[positionX][positionY] || board[positionX][positionY] != word.charAt(wordIndex)) return false;
        if(wordIndex == word.length() - 1) return true;
        flags[positionX][positionY] = true;
        if(positionX < board.length - 1){
            boolean flag = dfs(board, positionX + 1, positionY, flags, word, wordIndex + 1);
            if(flag) return true;
        }

        if(positionX > 0){
            boolean flag = dfs(board, positionX - 1, positionY, flags, word, wordIndex + 1);
            if(flag) return true;
        }
        if(positionY < board[0].length - 1){
            boolean flag = dfs(board, positionX, positionY + 1, flags, word, wordIndex + 1);
            if(flag) return true;
        }
        if(positionY > 0){
            boolean flag = dfs(board, positionX, positionY - 1, flags, word, wordIndex + 1);
            if(flag) return true;
        }
        flags[positionX][positionY] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        System.out.println(solution79.exist(new char[][]{{'a'}}, "a"));
    }

}
