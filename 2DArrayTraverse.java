class Solution {
    public ArrayList<ArrayList<Integer>> formCoils(int n) {
        // code here
        boolean t=false;
        int[] dr={-1,-1,-1,0,0,1,1,1};
        int[] dc={-1,0,1,-1,1,-1,0,1};
        for(i=0 to total row){
            for(j=0 to total column){
                for(k=0 to 8){
                    int row=i+dr[k];
                     int col=j+dc[k];
                if(row>=0 && row<matrix.length && col>=0 && col<matrix[0].length){
                    if(matrix[row][col]==1){
                        matrix[row][col]=2;
                        t=true;
                    }
                }
                
                }
                if(t){
                hour++;}
                
            }
        }
    }
}
