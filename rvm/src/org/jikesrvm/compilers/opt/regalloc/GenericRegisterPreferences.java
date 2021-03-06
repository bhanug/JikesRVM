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
package org.jikesrvm.compilers.opt.regalloc;

import org.jikesrvm.compilers.opt.ir.IR;
import org.jikesrvm.compilers.opt.ir.Register;

/**
 * This class helps manage register preferences for coalescing and
 * register allocation.
 */
public abstract class GenericRegisterPreferences {
  /**
   * The main backing data structure;
   */
  private final CoalesceGraph graph = new CoalesceGraph();

  /**
   * Adds a affinity of weight w between two registers.
   *
   * @param w the affinity
   * @param r1 the first register
   * @param r2 the second register
   */
  protected void addAffinity(int w, Register r1, Register r2) {
    graph.addAffinity(w, r1, r2);
  }

  /**
   * Sets up register preferences for an IR. This is machine-dependent.
   *
   * @param ir the IR
   */
  public abstract void initialize(IR ir);

  /**
   * @return the backing graph holding the preferences.
   */
  public CoalesceGraph getGraph() {
    return graph;
  }
}
