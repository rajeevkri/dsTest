package com.ds.array;

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited  = new boolean[arr.length];
        return canReach(arr, start, visited);
    }

    private boolean canReach(int[] arr, int start, boolean[] visited) {
        if(start>=arr.length || start<0)
            return false;
        if(arr[start]==0){
            return true;
        }
        if(visited[start])
            return false;
        visited[start] = true;
        int jump= arr[start];
        boolean isLeft =  canReach(arr, start-jump, visited);
        boolean isRight =  canReach(arr, start+jump, visited);
        return  isLeft || isRight;
    }

}
