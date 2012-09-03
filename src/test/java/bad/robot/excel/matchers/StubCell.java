/*
 * Copyright (c) 2012, bad robot (london) ltd.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package bad.robot.excel.matchers;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.util.Date;

import static org.apache.poi.ss.usermodel.Cell.*;

class StubCell {

    static Cell createBlankCell(int row, int column) {
        return create(row, column, CELL_TYPE_BLANK);
    }

    static Cell createCell(int row, int column, Boolean aBoolean) {
        Cell cell = create(row, column, CELL_TYPE_BOOLEAN);
        cell.setCellValue(aBoolean);
        return cell;
    }

    static Cell createCell(int row, int column, Byte value) {
        Cell cell = create(row, column, CELL_TYPE_ERROR);
        cell.setCellErrorValue(value);
        return cell;
    }

    static Cell createFormulaCell(int row, int column, String formula) {
        Cell cell = create(row, column, CELL_TYPE_FORMULA);
        cell.setCellFormula(formula);
        return cell;
    }

    static Cell createCell(int row, int column, Double aDouble) {
        Cell cell = create(row, column, CELL_TYPE_NUMERIC);
        cell.setCellValue(aDouble);
        return cell;
    }

    static Cell createCell(int row, int column, Date date) {
        Cell cell = create(row, column, CELL_TYPE_NUMERIC);
        cell.setCellValue(date);
        return cell;
    }

    static Cell createCell(int row, int column, String value) {
        Cell cell = create(row, column, CELL_TYPE_STRING);
        cell.setCellValue(value);
        return cell;
    }


    private static Cell create(int row, int column, int type) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        HSSFCell cell = sheet.createRow(row).createCell(column, type);
        return cell;
    }

}
