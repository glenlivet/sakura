package org.glenlivet.sakura.mongo.domain;

import java.util.Map;

public interface ProductSku {

    String getId();

    Money getBasePrice();

    Map<String, String> getAttributes();
}
