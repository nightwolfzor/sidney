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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sidney.core.Bytes;
import org.sidney.core.Registrations;
import org.sidney.core.SidneyException;
import org.sidney.core.serde.serializer.Serializer;
import org.sidney.core.serde.serializer.SerializerRepository;

import java.io.IOException;
import java.io.InputStream;

public abstract class BaseReader {
    protected Registrations registrations;
    protected Class type;
    protected Class[] typeParams;
    protected InputStream inputStream;
    protected ReadContext context;
    protected ObjectMapper json = new ObjectMapper();
    protected Serializer serializer;
    protected TypeReader typeReader = new TypeReader();
    protected int recordCount = 0;
    protected SerializerRepository serializerRepository;
    protected PageHeader currentPageHeader = null;
    protected boolean isOpen = false;

    public BaseReader(Registrations registrations) {
        this.registrations = registrations;
        this.serializerRepository = new SerializerRepository(registrations);
    }

    /**
     * Check for new items
     *
     * @return whether there are more items
     */
    public boolean hasNext() {
        if (currentPageHeader == null) {
            loadNextPage();
            return hasNext();
        }

        if (recordCount-- > 0) {
            return true;
        }

        if (!currentPageHeader.isLastPage()) {
            loadNextPage();
            return hasNext();
        }

        return false;
    }

    /**
     * Open the given {@link java.io.InputStream} for reading.
     */
    public void open(InputStream inputStream) {
        this.inputStream = inputStream;
        this.recordCount = 0;
        this.isOpen = true;
    }

    /**
     * Marks this reader as closed
     */
    public void close() {
        try {
            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        inputStream = null;
        isOpen = false;
    }

    private void loadNextPage() {
        try {
            int size = Bytes.readIntFromStream(inputStream);
            byte[] bytes = new byte[size];
            int numRead = inputStream.read(bytes);
            if (numRead < size) {
                throw new SidneyException("Could not fully read buffer.");
            }
            currentPageHeader = json.readValue(bytes, PageHeader.class);
            currentPageHeader.prepareForRead();
            context = new ReadContext(
                    new ColumnReader(
                            serializer
                    )
            );
            recordCount = currentPageHeader.getPageSize();
            context.setPageHeader(currentPageHeader);
            context.getColumnReader().loadFromInputStream(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}