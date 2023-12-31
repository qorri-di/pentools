package id.qodev.pentool.service;

import org.jboss.logging.MDC;
import org.jboss.resteasy.reactive.server.*;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.container.*;
import java.util.UUID;

@ApplicationScoped
public class ProcessService {

    private final String REQUEST_ID_HEADER = "X-Transaction-ID";
    private final String REQUEST_ID_MDC_KEY = "transactionId";

    @ServerRequestFilter
    void getRequestFilter(ContainerRequestContext requestContext) {
        String requestId = requestContext.getHeaderString(REQUEST_ID_HEADER);
        if (requestId==null || requestId.isEmpty()) {
            String uid= UUID.randomUUID().toString();
            String[] arrUid=uid.split("-");
            requestId=arrUid[4];
        }
        MDC.put(REQUEST_ID_MDC_KEY, requestId);
    }

    @ServerResponseFilter
    void getResponseFilter(ContainerResponseContext responseContext) {
        MDC.remove(REQUEST_ID_MDC_KEY);
    }

}
