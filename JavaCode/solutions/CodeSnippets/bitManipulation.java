操作原理
        符号	规则
        &	两个位都为1时, 结果才为1
        |	两个位都为0时, 结果才为0
        ~	取反
        ^	两个位相同为0, 相异为1
        位操作只能用于整形数据,
        对float和double类型进行位操作会被编译器报错.

        常见位操作
        1. 获取(第i位)
        boolean getBit(int i, int num){
            return ( (num & (1 << i)) != 0 );
        }

        2. 置位(第i位)
        int setBit(int i, int num){
            return num | (1 << i);
        }

        3. 清零
        3.1    清零i位
        int clearBit(int num, int i) {
            int mask = ~(1 << i);
            return num & mask;
        }
        3.2    清零num最高位至i位
        int clearBitMSBthroughI(int num, int i){
            int mask = (1<< i) -1;
            return num & mask;
        }
        3.3    清零i位到0位
        int clearBitsIThrough0(int i, int num) {
            int mask = ~( (1 << (i+1) )  -1 );
            return num & mask;
        }

        4. 去掉数字n中最右一位1
        int clearOne(int num) {
            num = (num & (num - 1));
            return num;
        }
