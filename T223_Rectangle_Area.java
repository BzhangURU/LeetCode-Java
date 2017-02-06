public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1=(C-A)*(D-B);
        int area2=(G-E)*(H-F);
        int width,height;
        if(C<=E||G<=A)
        	return area1+area2;
        else width=Math.min(C, G)-Math.max(A, E);
        if(B>=H||F>=D)
        	return area1+area2;
        else height=Math.min(D, H)-Math.max(B, F);
        return area1+area2-width*height;
    }
}
