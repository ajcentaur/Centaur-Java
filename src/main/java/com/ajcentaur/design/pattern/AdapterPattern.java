package com.ajcentaur.design.pattern;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 17:06
 * @description: 适配器模式
 */
public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println(new Adapter(new Speaker()).translate());
    }
}

class Speaker{
    public String speak(){
        return "我是詹密";
    }
}

interface Translator{
    String translate();
}

/**
 * 适配器
 */
class Adapter implements Translator{
    private Speaker speaker;

    public Adapter(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public String translate() {
        String result = speaker.speak();
        //对result进行某种转换
        return result;
    }
}
