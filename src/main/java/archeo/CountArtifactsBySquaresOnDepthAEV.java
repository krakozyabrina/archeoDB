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
 * Created by arybasova on 27.04.17.
 */
public class CountArtifactsBySquaresOnDepthAEV extends AbstractXlsView {

    private final List<Map<String, Object>> objects;

    public CountArtifactsBySquaresOnDepthAEV(List<Map<String, Object>> objects) {
        this.objects = objects;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        httpServletResponse.setHeader("Content-Disposition", "inline; filename=countArtifactsBySquaresOnDepth.xls");
        Sheet sheet = workbook.createSheet("Количество находок по квадратам на заданной глубине");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Квадрат");
        header.createCell(1).setCellValue("Количество");
        header.createCell(2).setCellValue("Номера находок в описи");

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
