package com.ajcentaur.design.pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 17:13
 * @description: 观察者模式
 */
public class ObServerPattern {
    public static void main(String[] args) {
        Debit zhangSan = new ZhangSan();
        zhangSan.borrow(new LiSi());
        zhangSan.borrow(new WangWu());
        zhangSan.notifyCredit();
    }

}

/**
 * 主题对象
 */
interface Debit{
    void borrow(Credit credit);

    void notifyCredit();
}

class ZhangSan implements Debit{
    private List<Credit> list = new ArrayList<>();

    @Override
    public void borrow(Credit credit) {
        list.add(credit);
    }

    @Override
    public void notifyCredit() {
        //某种条件改变后，通知被观察的人
        list.forEach(it-> it.takeMoney());
    }
}

/**
 * 观察者
 */
interface Credit{
    void takeMoney();
}

class LiSi implements Credit{

    @Override
    public void takeMoney() {
        System.out.println("还钱给李四");
    }
}

class WangWu implements Credit{

    @Override
    public void takeMoney() {
        System.out.println("还钱给王五");
    }
}

