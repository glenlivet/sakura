package org.glenlivet.sakura.utils;

import org.glenlivet.sakura.katharsis.domain.model.KatharsisModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JsonBeanUtils {

    public static <T extends KatharsisModel> void updateNonNullFields(T source, T target) throws BeansException {

        PropertyDescriptor[] propertiesDescriptors = BeanUtils.getPropertyDescriptors(source.getClass());

        for (PropertyDescriptor pd : propertiesDescriptors) {
            Method readMethod = pd.getReadMethod();
            if (readMethod != null) {
                try {
                    if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    Object value = readMethod.invoke(source);
                    if (value != null) {
                        Method writeMethod = pd.getWriteMethod();
                        if (writeMethod != null) {
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, value);
                        }
                    }
                } catch (Throwable ex) {
                    throw new FatalBeanException(
                            "Could not copy property '" + pd.getName() + "' from source to target", ex);
                }
            }
        }
    }
}
