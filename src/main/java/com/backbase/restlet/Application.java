package com.backbase.restlet;

import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Simple Demo application in to configure Restlet with SLF4J logging
 */
public class Application extends org.restlet.Application {

    public static void main(String... args) throws Exception {

        // needed to bind Restlet with SLF4J
        System.setProperty("org.restlet.engine.loggerFacadeClass", "org.restlet.ext.slf4j.Slf4jLoggerFacade");

        Component comp = new Component();

        // the only way to disable the following INFO line:
        // 10:33:24.669 [Restlet-79123022] INFO  LogService - 2013-10-23	10:33:24	0:0:0:0:0:0:0:1
        // if you know a better way, please fork this example and send a pull request
        comp.getLogService().setEnabled(false);

        comp.getServers().add(Protocol.HTTP, 3000);

        // Attach the application to the default host and start it
        comp.getDefaultHost().attach("/v1", new Application());
        comp.start();

    }

}
