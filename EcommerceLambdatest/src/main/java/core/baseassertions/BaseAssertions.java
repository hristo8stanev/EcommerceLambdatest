package core.baseassertions;

import core.basemap.BaseMap;

import java.lang.reflect.ParameterizedType;

public abstract class BaseAssertions<ElementsT extends BaseMap> {

    protected ElementsT elementsT() {
        try {
            var elementsClass = (Class<ElementsT>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return elementsClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }
}