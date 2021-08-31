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
package org.eclipse.persistence.testing.tests.manual;

import org.eclipse.persistence.testing.framework.*;
import org.eclipse.persistence.testing.models.inheritance.Car;

public class ReadToSeeMultipleIDsTest extends ManualVerifyTestCase {
    public ReadToSeeMultipleIDsTest() {
        setDescription("Check select SQL and make sure that ID's are not printed multiple times.");
    }

    @Override
    public void test() {
        getSession().readAllObjects(Car.class);
    }
}
