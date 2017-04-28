package archeo;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by arybasova on 28.04.17.
 */
public class AllSitesAEV  extends AbstractXlsView {

    private final List<Map<String, Object>> objects;

    public AllSitesAEV(List<Map<String, Object>> objects) {
        this.objects = objects;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {


        Sheet sheet = workbook.createSheet("Полное описание памятников");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Название памятника");
        header.createCell(1).setCellValue("Регион");
        header.createCell(2).setCellValue("Эпоха");
        header.createCell(3).setCellValue("Комментарии к памятнику");

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

    private String formatObject(Object value) {
        if (value instanceof Date) {
            return new SimpleDateFormat("dd.MM.yyyy").format(value);
        }
        return Objects.toString(value, "");
    }
}
