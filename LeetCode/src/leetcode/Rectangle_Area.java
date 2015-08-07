package leetcode;

/**
 * @author Sunshine
 */
public class Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        
        long h1 = Math.max(A, E);
        long h2 = Math.min(C, G);
        long h = h2 - h1;
        
        long v1 = Math.max(B, F);
        long v2 = Math.min(D, H);
        long v = v2 - v1;
        int overlap = (int)((h <= 0 || v <= 0) ? 0 : h*v);
        
        return area1 + area2 - overlap;
    }
    
    public static void main(String[] args) {
        Rectangle_Area test = new Rectangle_Area();
        System.out.println(test.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
    }
}
