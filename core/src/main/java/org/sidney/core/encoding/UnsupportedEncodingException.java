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
package org.sidney.core.encoding;

import org.sidney.core.schema.Type;

public class UnsupportedEncodingException extends RuntimeException {
    public UnsupportedEncodingException(Encoding encoding, Type type) {
        super(String.format("Encoding %s is not supported for type %s", encoding, type));
    }
}
