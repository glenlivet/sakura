package org.glenlivet.sakura.model;

/**
 * In order to make JSONAPI update resource work as defined, all the fields of a Katharsis model
 * shall be objects. No primitive types are allowed. That is to make {@link org.glenlivet.sakura.utils.JsonBeanUtils}
 * method {@code updateNonNullFields} work as expected.
 */
public interface KatharsisModel {
}
