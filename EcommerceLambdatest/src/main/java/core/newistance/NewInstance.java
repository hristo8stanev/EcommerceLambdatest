package core.newistance;

import java.lang.reflect.ParameterizedType;

public class NewInstance {

    @SuppressWarnings("unchecked, rawtypes")
    public static <T> T createByTypeParameter(Class parameterClass, int index) {
        try {
            var elementsClass = (Class) ((ParameterizedType) parameterClass.getGenericSuperclass()).getActualTypeArguments()[index];
            return (T) elementsClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}