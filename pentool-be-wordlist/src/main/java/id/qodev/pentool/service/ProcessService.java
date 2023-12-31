package id.qodev.pentool.service;

import io.quarkus.vertx.http.runtime.filters.Filters;
import org.jboss.logmanager.MDC;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;
import org.jboss.resteasy.reactive.server.ServerResponseFilter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import java.util.UUID;

@ApplicationScoped
public class ProcessService {
    private final String REQUEST_ID_HEADER = "X-Transaction-ID";
    private final String REQUEST_ID_MDC_KEY = "transactionId";

    public void filters(@Observes final Filters filters) {
        filters.register(rc -> {
            String uid= UUID.randomUUID().toString();
            String[] arrUid=uid.split("-");
            String requestId=arrUid[4];
            MDC.put(REQUEST_ID_MDC_KEY, requestId);
            rc.next();
        }, 9000);
    }

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
