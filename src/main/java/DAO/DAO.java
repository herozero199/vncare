package DAO;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.lang.reflect.Field;

public class DAO extends PanacheEntityBase {

    public void set(String name, Object value) throws NoSuchFieldException, IllegalAccessException {
        System.out.println(1);
        Field f = this.getClass().getDeclaredField(name);
        System.out.println(2);
        f.setAccessible(true);
        System.out.println(3);
        f.set(this, f.getType().cast(value));
        System.out.println(4);
    }
}
