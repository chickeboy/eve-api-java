package com.tlabs.eve.api;

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

import com.tlabs.eve.api.Contact.Group;

import java.util.LinkedList;
import java.util.List;

public final class ContactListResponse extends EveAPIResponse {

    private static final long serialVersionUID = 1803692879940276962L;

    private final List<Group> contactGroups = new LinkedList<>();

    public final List<Group> getContactGroups() {
        return this.contactGroups;
    }

    public final void addGroup(final Group group) {
        this.contactGroups.add(group);
    }
}
