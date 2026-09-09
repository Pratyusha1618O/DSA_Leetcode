class Solution {
    public long countCommas(long n) {
       
        if(n <= 999){
            return 0;
        }
        
        long comma = 0;

        // 1000 to 999999 (4-6 digit)
        if(n >= 1000){
            long end = Math.min(n, 999999);
            comma += end - 1000 + 1;
        }

        // 1000000 to 999999999 (7-9 digit)
        if(n >= 1000000){
            long end = Math.min(n, 999999999);
            comma += (end - 1000000 + 1) * 2;
        }
        
        // 1000000000 to 999999999999 (10-12 digit)
        if( n >= 1000000000 ){
            long end = Math.min(n, 999999999999L);
            comma += (end - 1000000000 + 1) * 3;
        }

        // 1000000000000 to 999999999999999 (13-15 digit)
        if(n >= 1000000000000L){
            long end = Math.min(n, 999999999999999L);
            comma += (end - 1000000000000L + 1) * 4;
        }

        // 1000000000000000 (>=16 digit)
        if(n >= 1000000000000000L){
            comma += 5;
        }

        return comma;


    }
}