package com.ajcentaur.designpattern.create.factory.abstractfactory;

public class Test {

    public static void main(String[] args){
        Factory factory;
        factory = new AK_Factory();
        Gun AK = factory.produceGun();
        Bullet AK_Bullet = factory.produceBullet();
        AK.shooting();
        AK_Bullet.load();

        factory = new M4A1_Factory();
        Gun M4A1 = factory.produceGun();
        Bullet M4A1_Bullet = factory.produceBullet();
        M4A1.shooting();
        M4A1_Bullet.load();
    }

}
