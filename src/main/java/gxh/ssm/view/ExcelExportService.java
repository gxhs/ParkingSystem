package gxh.ssm.view;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.Map;

public interface ExcelExportService {

    public void markWordBook(Map<String,Object>model, Workbook workbook);
}
