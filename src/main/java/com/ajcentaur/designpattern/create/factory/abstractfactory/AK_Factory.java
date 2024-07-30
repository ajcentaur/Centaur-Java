package com.ajcentaur.designpattern.create.factory.abstractfactory;

import com.ajcentaur.designpattern.create.factory.abstractfactory.product.AK;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.AK_Bullet;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Bullet;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Gun;

public class AK_Factory implements Factory {

    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AK_Bullet();
    }
}
