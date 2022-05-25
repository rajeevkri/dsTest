package com.ds.array;

public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0) return true;
        if(flowerbed == null || flowerbed.length == 0)
            return false;
        int l = flowerbed.length;
        int count = 0;
        if(l ==1 && flowerbed[0] == 1)
            return false;
        if(l ==1 && flowerbed[0] == 0 && n <=1)
            return true;
        int b[] = new int[l];
        System.arraycopy(flowerbed, 0, b, 0, l);
        if(b[0] == 0 && b[1] == 0) {
            count++;
            b[0] =1;
        }
        for(int i =1; i< l-1; i++) {
            if(b[i] == 1)
                continue;
            if(b[i-1] ==0 && b[i+1] == 0) {
                count++;
                b[i] = 1;
            }
        }
        if(b[l-1] == 0 && b[l-2] == 0) {
            count++;
            b[l-1] =1;
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        PlaceFlowers placeFlowers = new PlaceFlowers();
        boolean isPossible = placeFlowers.canPlaceFlowers(flowerbed, 1);
        System.out.println(isPossible);
    }
}
