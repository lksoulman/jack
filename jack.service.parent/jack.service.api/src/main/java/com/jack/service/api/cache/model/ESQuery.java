package com.jack.service.api.cache.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @ClassName: ESQuery
 * @Description:
 * @author lksoulman
 * @date 2018-07-13 13:44:05
 */
@Data
public class ESQuery implements Serializable {

    /**
     * @Fields serialVersionUID :
     * @author lksoulman
     */
    private static final long serialVersionUID = 7298720518555043476L;

    private String queryStr;
    private String orderField;

    private int size;
    private int from;
}
