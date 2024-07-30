package com.ajcentaur.designpattern.create.factory.abstractfactory;

import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Bullet;
import com.ajcentaur.designpattern.create.factory.abstractfactory.product.Gun;

public interface Factory {

    Gun produceGun();

    Bullet produceBullet();

}
