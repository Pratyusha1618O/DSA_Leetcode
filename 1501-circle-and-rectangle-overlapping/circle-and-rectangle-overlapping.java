class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // if(y1 > yCenter){
        //     return false;
        // }
        
        // if(y2 < yCenter){
        //     return false;
        // }


        // return true;

        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // horizontal distance
        int dx = xCenter - closestX;

        // vertical distance
        int dy = yCenter - closestY;

        //check distance
        return dx * dx + dy * dy <= radius * radius;

    }
}