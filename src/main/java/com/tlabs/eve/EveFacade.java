package com.tlabs.eve;

/*
 * #%L
 * This source code is part of the Evanova Android application:
 * https://play.google.com/store/apps/details?id=com.tlabs.android.evanova
 * 
 * ------------------------------------------------------------------------
 * %%
 * Copyright (C) 2011 - 2013 Traquenard Labs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.io.IOException;
import java.io.InputStream;

import com.tlabs.eve.api.EveAPI;
import com.tlabs.eve.api.EveAPIRequest;
import com.tlabs.eve.ccp.CCP;
import com.tlabs.eve.central.EveCentral;
import com.tlabs.eve.central.EveCentralRequest;
import com.tlabs.eve.crest.CREST;
import com.tlabs.eve.crest.CRESTRequest;

public final class EveFacade {

    private EveFacade() {
    }

    public static <T extends EveResponse> T parse(final EveRequest<T> request, InputStream in) throws IOException {
        if (request instanceof EveAPIRequest) {
            return (T) EveAPI.parse((EveAPIRequest) request, in);
        }
        if (request instanceof EveCentralRequest) {
            return (T) EveCentral.parse((EveCentralRequest) request, in);
        }
        if (request instanceof CRESTRequest) {
            return (T) CREST.parse((CRESTRequest) request, in);
        }
        return CCP.parse(request, in);
    }

}
