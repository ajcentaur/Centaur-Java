package com.ajcentaur.designpattern.create.factory.abstractfactory;

import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Bullet;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Gun;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.M4A1;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.M4A1_Bullet;

public class M4A1_Factory implements Factory {
    @Override
    public Gun produceGun() {
        return new M4A1();
    }

    @Override
    public Bullet produceBullet() {
        return new M4A1_Bullet();
    }
}
