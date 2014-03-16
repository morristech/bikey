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

public enum RideState {

    /**
     * Initial state: the ride has been created but has not started yet.
     */
    CREATED(0),

    /**
     * The ride is currently active and being recorded.<br>
     * Only one ride can be active at any time.
     */
    ACTIVE(1),

    /**
     * The ride has been started but recording is currently paused.
     */
    PAUSED(2);


    private int mValue;

    RideState(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public String getValueAsString() {
        return String.valueOf(mValue);
    }

    public static RideState from(int value) {
        for (RideState rideState : values()) {
            if (rideState.mValue == value) return rideState;
        }
        return null;
    }
}
