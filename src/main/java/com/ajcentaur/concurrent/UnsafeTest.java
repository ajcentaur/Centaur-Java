package com.ajcentaur.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class UnsafeTest {

    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static { 
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        }catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

//    public static void main(String[] args){
//        UnsafeTest test = new UnsafeTest();
//        Boolean sucess = unsafe.compareAndSwapInt(test,stateOffset,0,1);
//        System.out.println(sucess);
//    }

    public static void main(String[] args){
        int[] nums = new int[]{2,7,11,15,9};
        int target = 9;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                System.out.println(new int[]{map.get(temp),i});
            }
            map.put(nums[i],i);
        }
        System.out.println(new int[]{-1,-1});

    }

}
