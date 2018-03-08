public class Solution {
    public int calculate(String s) {
        s = s.trim();
		if (s.length() == 0) return 0;
		int curIndex = 0, total = 0, curNum = 0, sign = 1;
		if (s.charAt(0) == '+' || s.charAt(0) == '-')
			sign = s.charAt(0) == '+' ? 1 : -1;

		while(curIndex < s.length()){
			// 1. if ' '
			if(s.charAt(curIndex) == ' '){
				curIndex++;
				continue;
			}
			// 2. if current char is digit
			if(s.charAt(curIndex) - '0' >= 0 && s.charAt(curIndex) - '0' <= 9){
				curNum = curNum*10 + s.charAt(curIndex) - '0';
			}
			// 3. if +/-
			if(s.charAt(curIndex) == '+' || s.charAt(curIndex) == '-'){
				total += sign*curNum;
				curNum = 0;
				sign = s.charAt(curIndex) == '+' ? 1 : -1;
			}
			// 4. if * or /
			if(s.charAt(curIndex) == '*' || s.charAt(curIndex) == '/'){
				// Find next number
				int nextNum = 0, multipler = s.charAt(curIndex++);
				while(curIndex < s.length() && (s.charAt(curIndex) == ' ' ||
						(s.charAt(curIndex) - '0' >= 0 && s.charAt(curIndex) - '0' <= 9))){
					if (s.charAt(curIndex) == ' '){
						curIndex++;
						continue;
					}
					nextNum = nextNum*10 + s.charAt(curIndex++) - '0';
				}
				curNum = (multipler == '*') ? curNum*nextNum : curNum/nextNum;
				curIndex--;
			}
			curIndex++;
		}
		return total += sign*curNum;
    }
}