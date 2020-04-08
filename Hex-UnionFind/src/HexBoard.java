public class HexBoard {
    UnionFind boardList;
    int left;
    int right;
    int top;
    int bottom;
    public HexBoard(){
        this.boardList = new UnionFind(125);
        this.left = 122;
        this.right = 123;
        this.top = 124;
        this.bottom = 125;
    }

    private boolean isEmpty(int hex){
        return boardList.set[hex] == -1;
    }

    private boolean isGameOver(int player){
        if(player == 1){
            return boardList.find(top) == boardList.find(bottom);
        }
        if(player == 0){
            return boardList.find(left) == boardList.find(right);
        }
        return false;
    }

    public void union(int root1, int root2) {
        int top1 = root1;
        int top2 = root2;
        if (top1 > -1)
            top1 = find(top1);
        if (top2 > -1)

            top2 = find(top2);

        if (boardList.set[top1] > boardList.set[top2]) {
            boardList.set[top2] += boardList.set[top1];
            boardList.set[top1] = top2;
        } else {
            boardList.set[top1] += boardList.set[top2];
            boardList.set[top2] = top1;
        }
    }
    public int find(int value) {
        if (boardList.set[value] < 0)
            return value;
        else {
            boardList.set[value] = find(boardList.set[value]); //Recursively update all values to the root.
            return boardList.set[value];
        }
    }

    private void neighorUnion(int hex, int player){
        if(player == 0)
            boardList.blueMoves
    }


}
