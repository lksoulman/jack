package com.jack.service.api.cache.model;

import java.io.IOException;
import java.io.Serializable;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import lombok.Data;

/**
 * 
 * @ClassName: ESIndex
 * @Description:
 * @author lksoulman
 * @date 2018-07-13 15:57:36
 */
@Data
public class ESIndex implements Serializable {

    /**
     * @Fields serialVersionUID :
     * @author lksoulman
     */
    private static final long serialVersionUID = -7180485834222108626L;

    private String name;

    private String type;

    private ESField[] fields;

    public XContentBuilder toXContentBuilder() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.startObject(name);
        builder.startObject("properties");

        for (ESField field : fields) {
            builder.startObject(field.getName());
            builder.field("type", field.getType());
            builder.field("index", Boolean.toString(field.isIndex()));
            builder.endObject();
        }

        builder.endObject();
        builder.endObject();
        builder.endObject();
        return builder;
    }
}
