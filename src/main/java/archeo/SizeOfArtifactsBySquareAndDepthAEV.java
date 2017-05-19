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
public class SizeOfArtifactsBySquareAndDepthAEV extends AbstractXlsView {

    private final List<Map<String, Object>> objects;

    public SizeOfArtifactsBySquareAndDepthAEV(List<Map<String, Object>> objects) {
        this.objects = objects;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        httpServletResponse.setHeader("Content-Disposition", "inline; filename=sizeOfArtifactsBySquareAndDepth.xls");
        Sheet sheet = workbook.createSheet("Размеры фрагментов по квадрату и глубине");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Номер в описи");
        header.createCell(1).setCellValue("Размер_X");
        header.createCell(2).setCellValue("Размер_Y");
        header.createCell(3).setCellValue("Размер_Z");
        header.createCell(4).setCellValue("Квадрат");
        header.createCell(5).setCellValue("Глубина(см)");

        int rowNum = 1;
        for (Map<String, Object> fields : objects) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Map.Entry<String, Object> field: fields.entrySet()) {
                row.createCell(colNum++).setCellValue(formatObject(field.getValue()));
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
