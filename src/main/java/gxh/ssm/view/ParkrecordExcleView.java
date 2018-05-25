package gxh.ssm.view;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ParkrecordExcleView extends AbstractXlsView {

    //导出文件名
    private String fileName=null;

    //到处视图自定义接口
    private ExcelExportService excelExpService=null;
//构造方法1
    public ParkrecordExcleView(ExcelExportService excelExpService) {
        this.excelExpService = excelExpService;
    }
    //构造方法2

    public ParkrecordExcleView(String viewName,ExcelExportService excelExportService) {
        this.setBeanName(viewName);
    }

    public String getFilename() {
        return fileName;
    }

    public void setFilename(String filename) {
        this.fileName = filename;
    }

    public ExcelExportService getExcelExpService() {
        return excelExpService;
    }

    public void setExcelExpService(ExcelExportService excelExpService) {
        this.excelExpService = excelExpService;
    }


    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                      HttpServletResponse response) throws Exception {
        // 没有自定义接口
        if (excelExpService == null) {
            throw new RuntimeException("导出服务接口不能为null！！");
        }
        // 文件名不为空，为空则使用请求路径中的字符串作为文件名
        if (!StringUtils.isEmpty(fileName)) {
            // 进行字符转换
            String reqCharset = request.getCharacterEncoding();
            reqCharset = reqCharset == null ? "UTF-8" : reqCharset;
            fileName = new String(fileName.getBytes(reqCharset), "ISO8859-1");
            // 设置下面文件名
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        }
        // 回调接口方法，使用自定义生成Excel文档
        excelExpService.markWordBook(model, workbook);
    }
}
