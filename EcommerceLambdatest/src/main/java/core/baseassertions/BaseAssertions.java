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

    protected String formatMessage(String errorMessage, String actualResult, String expectedResult) {
        return String.format("%s \n Actual Result: %s \n Expected Result: %s", errorMessage, actualResult, expectedResult);
    }
}