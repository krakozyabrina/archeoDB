package archeo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by arybasova on 01.05.17.
 */
public class FieldInventoryByObjectAndDepthAEV extends AbstractXlsView {
    private final List<Map<String, Object>> objects;

    public FieldInventoryByObjectAndDepthAEV(List<Map<String, Object>> objects) {
        this.objects = objects;

    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        Sheet sheet = workbook.createSheet("Опись предметов по объекту и глубине");

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

        int rowNum = 1;
        for (Map<String, Object> fields : objects) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Map.Entry<String, Object> field: fields.entrySet()) {
                if (field.getValue() instanceof Number) {
                    Number num = (Number) field.getValue();
                    row.createCell(colNum++).setCellValue(num.intValue());
                } else if (field.getValue() instanceof Date) {
                    row.createCell(colNum++).setCellValue((Date)field.getValue());
                } else {
                    row.createCell(colNum++).setCellValue(Objects.toString(field.getValue(), ""));
                }
            }
        }

    }

}
