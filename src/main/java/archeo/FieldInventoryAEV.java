package archeo;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by arybasova on 28.04.17.
 */
public class FieldInventoryAEV extends AbstractXlsView {
    private List<Fieldinventory> fieldinventories;

    public FieldInventoryAEV(List<Fieldinventory> fieldinventory) {
        this.fieldinventories = fieldinventory;

    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Sheet sheet = workbook.createSheet("Полевая опись");

        CellStyle dateCellStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dataFormat.getFormat("DD.MM.YY"));

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Номер в описи");
        header.createCell(1).setCellValue("Шифр");
        header.createCell(2).setCellValue("Материал");
        header.createCell(3).setCellValue("Описание");
        header.createCell(4).setCellValue("Объект");
        header.createCell(5).setCellValue("Характеристика");
        header.createCell(6).setCellValue("Предмет");
        header.createCell(7).setCellValue("Квадрат");
        header.createCell(8).setCellValue("Глубина(см)");
        header.createCell(9).setCellValue("Коорд_Север");
        header.createCell(10).setCellValue("Коорд_Запад");
        header.createCell(11).setCellValue("Слой");
        header.createCell(12).setCellValue("Размер_X");
        header.createCell(13).setCellValue("Размер_Y");
        header.createCell(14).setCellValue("Размер_Z");
        header.createCell(15).setCellValue("Площадь находки");
        header.createCell(16).setCellValue("Дата находки");
        header.createCell(17).setCellValue("Памятник");
        header.createCell(18).setCellValue("Регион");

        int rowNum = 1;
        for (Fieldinventory fieldinventory : this.fieldinventories) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(fieldinventory.getId());
            row.createCell(1).setCellValue(fieldinventory.getCipher());
            row.createCell(2).setCellValue(fieldinventory.getMaterial());
            row.createCell(3).setCellValue(fieldinventory.getDescription());
            row.createCell(4).setCellValue(fieldinventory.getSiteobject());
            row.createCell(5).setCellValue(fieldinventory.getCharacteristic());
            row.createCell(6).setCellValue(fieldinventory.getTitle());
            row.createCell(7).setCellValue(fieldinventory.getSquare());
            row.createCell(8).setCellValue(fieldinventory.getDepth());
            row.createCell(9).setCellValue(fieldinventory.getCoord_north());
            row.createCell(10).setCellValue(fieldinventory.getCoord_west());
            row.createCell(11).setCellValue(fieldinventory.getLayer());
            row.createCell(12).setCellValue(fieldinventory.getSizex());
            row.createCell(13).setCellValue(fieldinventory.getSizey());
            row.createCell(14).setCellValue(fieldinventory.getSizez());
            row.createCell(15).setCellValue(fieldinventory.getArea());
            if (fieldinventory.getFind_date() != null) {
                Cell cell = row.createCell(16);
                cell.setCellStyle(dateCellStyle);
                cell.setCellValue(fieldinventory.getFind_date());
            }
            row.createCell(17).setCellValue(fieldinventory.getSite_title());
            row.createCell(18).setCellValue(fieldinventory.getRegion());
        }

    }

    }
