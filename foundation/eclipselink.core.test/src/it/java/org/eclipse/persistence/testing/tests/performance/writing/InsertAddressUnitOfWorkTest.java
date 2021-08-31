/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//     Oracle - initial API and implementation from Oracle TopLink
package org.eclipse.persistence.testing.tests.performance.writing;

import org.eclipse.persistence.sessions.*;
import org.eclipse.persistence.queries.*;
import org.eclipse.persistence.testing.models.performance.Address;
import org.eclipse.persistence.testing.tests.performance.PerformanceTest;

/**
 * This tests the performance of unit of work inserts.
 * Its purpose is to compare the test result with previous release/label results.
 * It also provides a useful test for profiling performance.
 */
public class InsertAddressUnitOfWorkTest extends PerformanceTest {
    public InsertAddressUnitOfWorkTest() {
        setDescription("This tests the performance of unit of work inserts.");
    }

    /**
     * Insert address and then reset database/cache.
     */
    @Override
    public void test() throws Exception {
        UnitOfWork uow = getSession().acquireUnitOfWork();
        Address address = new Address();
        address.setCity("NewCity");
        address.setPostalCode("N5J2N5");
        address.setProvince("ON");
        address.setStreet("1111 Mountain Blvd. Floor 13, suite 1");
        address.setCountry("Canada");
        uow.registerObject(address);
        uow.commit();
        getSession().getIdentityMapAccessor().initializeAllIdentityMaps();
        getSession().executeNonSelectingCall(new SQLCall("Delete from ADDRESS where CITY = 'NewCity'"));
    }
}
