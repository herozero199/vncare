package DAO;

import CustomAnnotation.Concept;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import java.lang.reflect.Field;
public class DAO extends PanacheEntityBase {

//    public String get (String meaning) throws IllegalAccessException {
//        for(Field f : this.getClass().getDeclaredFields()) {
//            if(f.getAnnotation(Concept.class) == null)
//                continue;
//            else if(f.getAnnotation(Concept.class).value().equals(meaning))
//                return f.getName();
//        }
//        return null;
//    }
//
//    public void set (String meaning, Object value) throws IllegalAccessException {
//
//        for(Field f : this.getClass().getDeclaredFields()) {
//            if(f.getAnnotation(Concept.class) == null)
//                System.out.println(f.getName());
//            else if(f.getAnnotation(Concept.class).value().equals(meaning))
//                f.set(this, value);
//        }
//    }
//
//    public Object getValue (String meaning) throws IllegalAccessException {
//        for(Field f : this.getClass().getDeclaredFields()) {
//            if(f.getAnnotation(Concept.class) == null)
//                System.out.println(f.getName());
//            else if(f.getAnnotation(Concept.class).value().equals(meaning))
//                return f.get(this);
//        }
//        return null;
//    }
}
