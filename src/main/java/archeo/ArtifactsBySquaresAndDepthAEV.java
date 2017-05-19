package archeo;

import org.apache.poi.ss.usermodel.*;
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
public class ArtifactsBySquaresAndDepthAEV extends AbstractXlsView {

    private List<Fieldinventory> fieldinventories;

    public ArtifactsBySquaresAndDepthAEV(List<Fieldinventory> fieldinventory) {
        this.fieldinventories = fieldinventory;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map,
                                      Workbook workbook,
                                      HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {

        httpServletResponse.setHeader("Content-Disposition", "inline; filename=artifactsBySquaresAndDepth.xls");
        Sheet sheet = workbook.createSheet("Опись предметов по заданным квадратам и глубине");
        CellStyle dateCellStyle = workbook.createCellStyle();
        DataFormat dataFormat = workbook.createDataFormat();
        dateCellStyle.setDataFormat(dataFormat.getFormat("DD.MM.YY"));

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Номер в описи");
        header.createCell(1).setCellValue("Предмет");
        header.createCell(2).setCellValue("Описание");
        header.createCell(3).setCellValue("Дата находки");
        header.createCell(4).setCellValue("Размер_X");
        header.createCell(5).setCellValue("Размер_Y");
        header.createCell(6).setCellValue("Размер_Z");
        header.createCell(7).setCellValue("Шифр");
        header.createCell(8).setCellValue("Глубина(см)");
        header.createCell(9).setCellValue("Коорд_Север");
        header.createCell(10).setCellValue("Коорд_Запад");
        header.createCell(11).setCellValue("Квадрат");
        header.createCell(12).setCellValue("Материал");
        header.createCell(13).setCellValue("Слой");
        header.createCell(14).setCellValue("Памятник");

        int rowNum = 1;

        for (Fieldinventory fieldinventory : this.fieldinventories) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(fieldinventory.getInv_num());
            row.createCell(1).setCellValue(fieldinventory.getTitle());
            row.createCell(2).setCellValue(fieldinventory.getDescription());
            if (fieldinventory.getFind_date() != null) {
                Cell cell = row.createCell(3);
                cell.setCellStyle(dateCellStyle);
                cell.setCellValue(fieldinventory.getFind_date());
            }
            row.createCell(4).setCellValue(fieldinventory.getSizex());
            row.createCell(5).setCellValue(fieldinventory.getSizey());
            row.createCell(6).setCellValue(fieldinventory.getSizez());
            row.createCell(7).setCellValue(fieldinventory.getCipher());
            row.createCell(8).setCellValue(fieldinventory.getDepth());
            row.createCell(9).setCellValue(fieldinventory.getCoord_north());
            row.createCell(10).setCellValue(fieldinventory.getCoord_west());
            row.createCell(11).setCellValue(fieldinventory.getSquare());
            row.createCell(12).setCellValue(fieldinventory.getMaterial());
            row.createCell(13).setCellValue(fieldinventory.getLayer());
            row.createCell(14).setCellValue(fieldinventory.getSite_title());
        }
    }
}
