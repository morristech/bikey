/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2013 Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jraf.android.bikey.backend.provider.ride;

import java.util.Date;

import org.jraf.android.bikey.backend.provider.base.AbstractSelection;

/**
 * Selection for the {@code ride} table.
 */
public class RideSelection extends AbstractSelection<RideSelection> {
    public RideSelection id(long... value) {
        addEquals(RideColumns._ID, toObjectArray(value));
        return this;
    }

    public RideSelection name(String... value) {
        addEquals(RideColumns.NAME, value);
        return this;
    }

    public RideSelection nameNot(String... value) {
        addNotEquals(RideColumns.NAME, value);
        return this;
    }


    public RideSelection createdDate(Date... value) {
        addEquals(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection createdDateNot(Date... value) {
        addNotEquals(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection createdDate(long... value) {
        addEquals(RideColumns.CREATED_DATE, toObjectArray(value));
        return this;
    }

    public RideSelection createdDateAfter(Date value) {
        addGreaterThan(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection createdDateAfterEq(Date value) {
        addGreaterThanOrEquals(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection createdDateBefore(Date value) {
        addLessThan(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection createdDateBeforeEq(Date value) {
        addLessThanOrEquals(RideColumns.CREATED_DATE, value);
        return this;
    }

    public RideSelection state(int... value) {
        addEquals(RideColumns.STATE, toObjectArray(value));
        return this;
    }

    public RideSelection stateNot(int... value) {
        addNotEquals(RideColumns.STATE, toObjectArray(value));
        return this;
    }

    public RideSelection stateGt(int value) {
        addGreaterThan(RideColumns.STATE, value);
        return this;
    }

    public RideSelection stateGtEq(int value) {
        addGreaterThanOrEquals(RideColumns.STATE, value);
        return this;
    }

    public RideSelection stateLt(int value) {
        addLessThan(RideColumns.STATE, value);
        return this;
    }

    public RideSelection stateLtEq(int value) {
        addLessThanOrEquals(RideColumns.STATE, value);
        return this;
    }

    public RideSelection activatedDate(Date... value) {
        addEquals(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDateNot(Date... value) {
        addNotEquals(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDate(Long... value) {
        addEquals(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDateAfter(Date value) {
        addGreaterThan(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDateAfterEq(Date value) {
        addGreaterThanOrEquals(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDateBefore(Date value) {
        addLessThan(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection activatedDateBeforeEq(Date value) {
        addLessThanOrEquals(RideColumns.ACTIVATED_DATE, value);
        return this;
    }

    public RideSelection duration(long... value) {
        addEquals(RideColumns.DURATION, toObjectArray(value));
        return this;
    }

    public RideSelection durationNot(long... value) {
        addNotEquals(RideColumns.DURATION, toObjectArray(value));
        return this;
    }

    public RideSelection durationGt(long value) {
        addGreaterThan(RideColumns.DURATION, value);
        return this;
    }

    public RideSelection durationGtEq(long value) {
        addGreaterThanOrEquals(RideColumns.DURATION, value);
        return this;
    }

    public RideSelection durationLt(long value) {
        addLessThan(RideColumns.DURATION, value);
        return this;
    }

    public RideSelection durationLtEq(long value) {
        addLessThanOrEquals(RideColumns.DURATION, value);
        return this;
    }

    public RideSelection distance(double... value) {
        addEquals(RideColumns.DISTANCE, toObjectArray(value));
        return this;
    }

    public RideSelection distanceNot(double... value) {
        addNotEquals(RideColumns.DISTANCE, toObjectArray(value));
        return this;
    }

    public RideSelection distanceGt(double value) {
        addGreaterThan(RideColumns.DISTANCE, value);
        return this;
    }

    public RideSelection distanceGtEq(double value) {
        addGreaterThanOrEquals(RideColumns.DISTANCE, value);
        return this;
    }

    public RideSelection distanceLt(double value) {
        addLessThan(RideColumns.DISTANCE, value);
        return this;
    }

    public RideSelection distanceLtEq(double value) {
        addLessThanOrEquals(RideColumns.DISTANCE, value);
        return this;
    }
}
