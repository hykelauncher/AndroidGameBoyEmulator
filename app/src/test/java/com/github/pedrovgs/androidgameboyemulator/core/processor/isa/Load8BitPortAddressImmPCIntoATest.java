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

package com.github.pedrovgs.androidgameboyemulator.core.processor.isa;

import com.github.pedrovgs.androidgameboyemulator.InstructionTest;
import com.github.pedrovgs.androidgameboyemulator.core.processor.Register;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Load8BitPortAddressImmPCIntoATest extends InstructionTest {

  @Test public void shouldIncrementProgramCounterInOneUnit() {
    z80.setProgramCounter(ANY_16BIT_REGISTER_VALUE);
    Instruction instruction = new Load8BitPortAddressImmPCIntoA(z80, mmu);

    instruction.execute();

    int expectedPCValue = ANY_16BIT_REGISTER_VALUE + 1;
    assertEquals(expectedPCValue, z80.getProgramCounter());
  }

  @Test public void shouldUseThreeCyclesAsLastExecutionTime() {
    Instruction instruction = new Load8BitPortAddressImmPCIntoA(z80, mmu);

    instruction.execute();

    assertEquals(3, z80.getLastInstructionExecutionTime());
  }

  @Test public void shouldLoad8BitMemoryValuePointedByThePortAddressOfPCIntoA() {
    z80.setProgramCounter(ANY_16BIT_REGISTER_VALUE);
    int pcPortAddress = (mmu.readByte(z80.getProgramCounter()) & 0xFF) + 0xFF00;
    when(mmu.readByte(pcPortAddress)).thenReturn(ANY_MEMORY_BYTE_VALUE);
    Instruction instruction = new Load8BitPortAddressImmPCIntoA(z80, mmu);

    instruction.execute();

    assertEquals(ANY_MEMORY_BYTE_VALUE, z80.get8BitRegisterValue(Register.A));
  }
}