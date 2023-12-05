package com.ajcentaur.basics;


public class BasicsDemo {

    public static void main(String[] args) {
        //Integer缓存池 Demo
        integerInstantDemo();

        stringDemo();
    }

    private static void integerInstantDemo(){
        System.out.println("-----integerInstantDemo-----");
        // new Integer() 每次都会创建一个新对象
        Integer a1 = new Integer(123);
        Integer a2 = new Integer(123);
        System.out.println(a1 == a2); //false
        // Integer.valueOf() 每次都从缓冲池获取对象，多次调用会获取同一对象的引用
        // 缓冲池只保存在-128~127之间的值
        Integer b1 = Integer.valueOf(12);
        Integer b2 = Integer.valueOf(12);
        System.out.println(b1 == b2); //true
        //如果是范围外的值，就会使用new创建新对象
        Integer c1 = Integer.valueOf(311);
        Integer c2 = Integer.valueOf(311);
        System.out.println(c1 == c2); //false
    }

    private static void stringDemo(){
        short a = 1;
        System.out.println("-----stringDemo-----");
        // 使用双引号赋值会自动将“val”放入 String Pool中,或者从String Pool中查找
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        // 使用new的方式， 不会将引用放入String pool
        String s3 = new String("ccd");
        String s4 = new String("ccd");
        System.out.println(s3 == s4);
        //使用intern()，会将引用放入String Pool ，再取出引用
        String s5 = s3.intern();
        System.out.println(s3.intern() == s5);

    }

    //Equals示例
    public class EqualExample {
        private int x;
        private int y;
        private int z;

        public EqualExample(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            EqualExample that = (EqualExample) o;

            if (x != that.x) return false;
            if (y != that.y) return false;
            return z == that.z;
        }

        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }
    }

}
