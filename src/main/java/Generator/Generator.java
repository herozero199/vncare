package Generator;

import DAO.DmcThongTinKhoaPhong;
import DAO.OrgOrganization;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generator {

//    private Map<String, Object> requestField = new HashMap<>();
//    private List<PanacheEntityBase> DAOs;
//
//    public Generator(List<PanacheEntityBase> DAOs, Request requestObject) throws IllegalAccessException {
//
//        this.DAOs = DAOs;
//
//        Field[] fieldList = requestObject.getClass().getDeclaredFields();
//        for (Field f :fieldList) {
//            f.setAccessible(true);
//            this.requestField.put(f.getName(), f.get(requestObject));
//        }

//        for (Field f : fieldList) {
//            System.out.println(f.getName() + " " + f.get(requestObject));
//        }
//    }
//
//    public List<PanacheEntityBase> generate() {
//
//        for(PanacheEntityBase DAO : this.DAOs) {
//            this.requestField.forEach((key, value) -> {
//                try {
//                    System.out.println("declared: "+ DAO.getClass().getDeclaredField(key) + ", key: " + key);
//                    Field f = DAO.getClass().getDeclaredField(key);
//                    f.setAccessible(true);
//                    f.set(DAO, value);
//                    System.out.println(DAO.toString());
//                } catch (NoSuchFieldException | IllegalAccessException ignored) {
//                    System.out.println(org_organization.class+", key: "+key+", "+"value: "+value);
//                }
//            });
//        }
//        System.out.println(((org_organization) DAOs.get(0)));
//        System.out.println(((dmc_thongtinkhoaphong) DAOs.get(1)));
//        return this.DAOs;
//    }

}
