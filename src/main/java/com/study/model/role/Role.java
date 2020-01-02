package com.study.model.role;

import com.sun.xml.internal.ws.api.FeatureListValidatorAnnotation;

/**
 * 角色模型,如维修人员,开发人员,实习生,老板等
 */
public class Role {

    Long id;

    String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
