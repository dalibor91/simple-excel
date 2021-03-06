/*
 * Copyright (c) 2012-2013, bad robot (london) ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package bad.robot.excel.sheet;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.Iterator;

class SheetIterator implements Iterator<Sheet> {

    private final Workbook workbook;
    private int index;

    public SheetIterator(Workbook workbook) {
        this.workbook = workbook;
    }

    @Override
    public boolean hasNext() {
        return index < workbook.getNumberOfSheets();
    }

    @Override
    public Sheet next() {
        return workbook.getSheetAt(index++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
