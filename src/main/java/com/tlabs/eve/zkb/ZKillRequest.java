package com.tlabs.eve.zkb;

import com.tlabs.eve.EveRequest;

import org.apache.commons.lang.StringUtils;

import java.util.Map.Entry;

//https://github.com/zKillboard/zKillboard/blob/master/api.wiki
public class ZKillRequest<T extends ZKillResponse> extends EveRequest<T> {

    protected ZKillRequest(Class<T> responseClass, String page) {
        super(responseClass, "api/" + page);
        limit(50).withItems(false).withAttackers(false);
    }

    @Override
    public final String toURI(String root) {
        return buildUriZKill(root, this);
    }

    public final <T extends ZKillRequest> T withItems(final boolean with) {
        removeParam("no-items");
        if (!with) {
            putParam("no-items", "");
        }
        return (T)this;
    }

    public final <T extends ZKillRequest> T withAttackers(final boolean with) {
        removeParam("no-attackers");
        if (!with) {
            putParam("no-attackers", "");
        }
        return (T)this;
    }

    public final <T extends ZKillRequest> T page(final int pageNumber) {
        putParam("page", (pageNumber < 0) ? "1" : "" + (pageNumber + 1));
        removeParam("limit");
        return (T)this;
    }

    public final <T extends ZKillRequest> T limit(final int limit) {
        if (limit > 0) {
            putParam("limit", "" + limit);
            removeParam("page");
        }
        return (T)this;
    }

    public final <T extends ZKillRequest> T asc() {
        return direction("asc");
    }

    public final <T extends ZKillRequest> T desc() {
        return direction("desc");
    }

    private final <T extends ZKillRequest> T direction(final String dir) {
        removeParam("orderDirection");
        putParam("orderDirection", dir);
        return (T)this;
    }


    private static String buildUriZKill(final String rootUri, final ZKillRequest<?> request) {
        final StringBuilder sb =
                new StringBuilder().
                        append(rootUri).
                        append("/").
                        append(request.getPage());
        for (Entry<String, String> e: request.getParameters().entrySet()) {
            sb.append(e.getKey());
            sb.append("/");
            if (StringUtils.isNotBlank(e.getValue())) {
                sb.append(e.getValue());
                sb.append("/");
            }
        }
        return sb.toString();
    }
}
