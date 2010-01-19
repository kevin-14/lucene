package org.apache.lucene.index;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.IOException;

import org.apache.lucene.util.AttributeSource;
import org.apache.lucene.util.BytesRef;

public abstract class PositionsEnum {

  private AttributeSource atts = null;

  /**
   * Returns the related attributes.
   */
  public AttributeSource attributes() {
    if (atts == null) atts = new AttributeSource();
    return atts;
  }
  
  // nocommit
  public String desc;

  /** Returns the next position.  You should only call this
   *  up to {@link FormatPostingsDocsEnum#freq()} times else
   *  the behavior is not defined. */
  public abstract int next() throws IOException;

  /** Returns length of payload at current position */
  public abstract int getPayloadLength();

  /** Returns the payload at this position, or null if no
   *  payload was indexed. */
  public abstract BytesRef getPayload() throws IOException;

  public abstract boolean hasPayload();
}
