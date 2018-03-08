public class Solution {
    public String replaceWithSpace(char[] originStr) {
        int readPosition = 0;
        int writePosition = 0;

        while(readPosition < originStr.length){
            // If find %20
            if(originStr[readPosition] == '%' &&
                    readPosition + 2 < originStr.length &&
                    originStr[readPosition + 1] == '2' &&
                    originStr[readPosition + 2] == '0'){
                readPosition += 3; // Update read position
                // Don't write multiple spaces
                if(writePosition - 1 >= 0 && originStr[writePosition - 1] != ' ')
                    originStr[writePosition++] = ' ';
            } else {
                originStr[writePosition++] = originStr[readPosition++];
            }
        }

        return String.valueOf(originStr).substring(0, writePosition);
    }
}