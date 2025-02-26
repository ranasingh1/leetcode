class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        Stack<Integer[]> stack = new Stack<>();
        int oldColor = image[sr][sc];
        image[sr][sc] = color;

        stack.push(new Integer[]{sr, sc});


        while(!stack.isEmpty()){
          int row = stack.peek()[0];
          int col = stack.peek()[1];

          stack.pop();
                    if(isValid(row, col-1, image, oldColor, color)) {
                stack.push(new Integer[]{row, col -1});
                image[row][col-1] = color;
            }

            if(isValid(row, col +1, image, oldColor, color)) {
                stack.push(new Integer[]{row, col +1});
                image[row][col+1] = color;
            }

            if(isValid(row-1, col, image, oldColor, color)) {
                stack.push(new Integer[]{row-1, col});
                image[row-1][col] = color;
            }

            if(isValid(row+1, col, image, oldColor, color)) {
                stack.push(new Integer[]{row+1, col});
                image[row+1][col] = color;
            }
    

        }

        return image;
    }

    public boolean isValid(int row, int col, int[][] image, int oldColor, int color){
        if(row<image.length && row>=0 && col<image[0].length && col>=0 && image[row][col]==oldColor && image[row][col]!= color){
            return true;
        }

        return false;
    }
}