package com.jack.service.api.cache.model;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @ClassName: ESField
 * @Description:
 * @author lksoulman
 * @date 2018-07-13 16:06:21
 */
@Data
public class ESField implements Serializable {
    /**
     * @Fields serialVersionUID :
     * @author lksoulman
     */
    private static final long serialVersionUID = 3319774183545433552L;

    private String name;
    private String type;
    private boolean isIndex;
}
