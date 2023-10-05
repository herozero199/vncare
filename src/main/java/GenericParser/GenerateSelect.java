package GenericParser;

import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Selection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenerateSelect {

    public static List<Selection<?>> Generate(Root<?> root, Object obj) {

        List<Selection<?>> result = new ArrayList<>();
//        List<Path<?>> result = new ArrayList<>();
        for(Field f : obj.getClass().getDeclaredFields())
            result.add(root.get(f.getName()));
//            result.add(root.get(f.getName()));
        return result;
    }
}
