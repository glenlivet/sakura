package org.glenlivet.sakura.integration.messaging.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SkuRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("jms:sakura.sku")
                .to("log:sample");
    }
}
