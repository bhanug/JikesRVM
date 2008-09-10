/*
 *  This file is part of the Jikes RVM project (http://jikesrvm.org).
 *
 *  This file is licensed to You under the Common Public License (CPL);
 *  You may not use this file except in compliance with the License. You
 *  may obtain a copy of the License at
 *
 *      http://www.opensource.org/licenses/cpl1.0.php
 *
 *  See the COPYRIGHT.txt file distributed with this work for information
 *  regarding copyright ownership.
 */
package org.mmtk.plan.refcount.backuptrace;

import org.mmtk.plan.refcount.RCHeader;
import org.mmtk.policy.LargeObjectSpace;

import org.vmmagic.pragma.*;
import org.vmmagic.unboxed.*;

/**
 * This class implements the freeing of large objects during a backup trace.
 */
@Uninterruptible
public final class BTFreeLargeObjectSweeper extends LargeObjectSpace.Sweeper {

  public boolean sweepLargeObject(ObjectReference object) {
    if (!RCHeader.isMarked(object)) {
      // Free the object
      return true;
    }
    // Clear the mark-bit and retain the object.
    RCHeader.clearMarked(object);
    return false;
  }
}