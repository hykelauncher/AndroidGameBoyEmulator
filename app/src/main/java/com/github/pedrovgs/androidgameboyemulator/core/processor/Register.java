/*
 * Copyright (C) 2015 Pedro Vicente Gomez Sanchez.
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
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.github.pedrovgs.androidgameboyemulator.core.processor;

public enum Register {
  A, F, B, C, D, E, H, L, AF(0), BC(2), DE(4), HL(6);

  private final int registerIndex;

  Register() {
    this.registerIndex = ordinal();
  }

  Register(int registerIndex) {
    this.registerIndex = registerIndex;
  }

  public int getRegisterIndex() {
    return registerIndex;
  }
}
