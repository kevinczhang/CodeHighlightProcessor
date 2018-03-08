public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int firstBitInd = 0, lastBitInd = 31;
        while(firstBitInd < lastBitInd){
            int firstBit = (n >> firstBitInd) & 1;
            int lastBit = (n >> lastBitInd) & 1;
            // Set last bit
            if(firstBit > 0)
                n |= (1 << lastBitInd);
            else
                n &= ~(1 << lastBitInd);
            // Set first bit
            if(lastBit > 0)
                n |= (1 << firstBitInd);
            else
                n &= ~(1 << firstBitInd);
            firstBitInd++;
            lastBitInd--;
        }
        return n;
    }
}