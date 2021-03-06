/*
 *  This file is part of the Jikes RVM project (http://jikesrvm.org).
 *
 *  This file is licensed to You under the Eclipse Public License (EPL);
 *  You may not use this file except in compliance with the License. You
 *  may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/eclipse-1.0.php
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package org.jikesrvm.scheduler;

import org.jikesrvm.architecture.StackFrameLayout;
import org.vmmagic.pragma.NonMoving;

/**
 * Represents the thread that the Jikes RVM uses to boot itself. It
 * is created during bootimage writing.
 */
@NonMoving
public final class BootThread extends SystemThread {

  public BootThread() {
    super(new byte[StackFrameLayout.getStackSizeBoot()], "Jikes_RBoot_Thread");
  }

  @Override
  public void run() {
    // Not reached.
  }
}
