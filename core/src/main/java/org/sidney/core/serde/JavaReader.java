/**
 * Copyright 2014 Jason Ruckman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sidney.core.serde;

import org.sidney.core.JavaTypeRefBuilder;
import org.sidney.core.SidneyConf;

public class JavaReader<T> extends BaseReader<T> implements Reader<T> {
    public JavaReader(Class type, SidneyConf conf, Class[] typeParams) {
        super(conf, JavaTypeRefBuilder.typeRef(type, typeParams));
    }
}