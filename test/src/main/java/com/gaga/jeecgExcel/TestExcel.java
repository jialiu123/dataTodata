package com.gaga.jeecgExcel;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.thymeleaf.util.MapUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：liujia
 * @date ：Created in 2021/2/8 16:59
 * @version: 1.0
 */
public class TestExcel {

    public static void main(String[] args) {

        HSSFWorkbook workbook = null;


        List<ExportExcelHeader> lstHeader = new ArrayList<>();

        workbook = createWorkBookForMap(null, lstHeader, "123");
    }


    public static HSSFWorkbook createWorkBookForMap(List<HashMap<String, Object>> rs2,
                                                    List<ExportExcelHeader> lstHeader,
                                                    String sheetName) {
        //创建EXCEL工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建Excel文件的sheet
        HSSFSheet sheet = wb.createSheet();
        //设置第一个sheet的名称
        wb.setSheetName(0, sheetName);
        List<ExportExcelHeader> lstExcelHeader = new ArrayList<>(lstHeader.size());
        for (ExportExcelHeader header : lstHeader) {
            lstExcelHeader.add(new ExportExcelHeader());
        }

        createHSSFWorkbookHeader(wb, sheet, lstHeader, lstExcelHeader);

        for (Map<String, Object> dataMap : rs2) {
            fillHSSFRowData(wb, sheet, dataMap, lstExcelHeader);
        }

        return wb;
    }

    /**
     * 动态创建sheet页
     *
     * @param index     sheetIndex
     * @param wb
     * @param rs2
     * @param lstHeader
     * @param sheetName
     */
    public static void createWorkBookForMap(int index, HSSFWorkbook wb, List<HashMap<String, Object>> rs2, List<ExportExcelHeader> lstHeader, String sheetName) {
        //创建Excel文件的sheet
        HSSFSheet sheet = wb.createSheet();
        //设置第一个sheet的名称
        wb.setSheetName(index, sheetName);
        List<ExportExcelHeader> lstExcelHeader = new ArrayList<ExportExcelHeader>(lstHeader.size());
        for (ExportExcelHeader header : lstHeader) {
            lstExcelHeader.add(new ExportExcelHeader());
        }

        createHSSFWorkbookHeader(wb, sheet, lstHeader, lstExcelHeader);

        for (Map<String, Object> dataMap : rs2) {
            fillHSSFRowData(wb, sheet, dataMap, lstExcelHeader);
        }

    }

    /**
     * @throws
     * @Title: createHSSFWorkbookHeader
     * @param: @param wb
     * @param: @param sheet
     * @param: @param lstHeader
     * @return: void
     */
    public static void createHSSFWorkbookHeader(HSSFWorkbook wb, HSSFSheet sheet, List<ExportExcelHeader> lstHeader, List<ExportExcelHeader> lstExcelHeader) {
        Integer level = 0;        // 层级
        HSSFRow row = null;        //行对象
        Integer colIndex = 0;    //cell指针
        Integer endRow = 0;        //合并时,开始row
        Map<String, CellRangeAddress> cacheMap = new HashMap<String, CellRangeAddress>();//缓存上一级位置
        CellStyle cellStyle = getHSSFCellStyle(wb);
        HSSFPalette palette = wb.getCustomPalette();
        //这个是重点，具体的就是把之前的颜色 HSSFColor.LIME.index
        //替换为  RGB(51,204,204) 宝石蓝这种颜色 你可以改为 RGB(0,255,127)
        palette.setColorAtIndex(HSSFColor.LIGHT_TURQUOISE.index, (byte) 227, (byte) 239, (byte) 219);
        cellStyle.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        for (ExportExcelHeader header : lstHeader) {
            CellRangeAddress region = cacheMap.get(header.getParent());
            if (region != null) {
                endRow = region.getLastRow();

                if (level != header.getLevel()) colIndex = region.getFirstColumn();
            }

            if (level != header.getLevel()) {
                row = sheet.createRow(level++);
                setRowStyle(wb, row);
            }
            setHSSFCellStyle(row.createCell(colIndex), cellStyle).setCellValue(header.getText());

            CellRangeAddress cache = new CellRangeAddress(endRow, endRow + header.getRowspan() - 1, colIndex, colIndex + header.getColspan() - 1);
            sheet.addMergedRegion(cache);
            cacheMap.put(header.getId(), cache);

            lstExcelHeader.add(colIndex, header);

            //sheet.autoSizeColumn(colIndex, true);
            sheet.setColumnWidth(colIndex, 20 * 256);
            colIndex = cache.getLastColumn() + 1;
        }

        RegionCellRangeAddressStyle(cacheMap, sheet, wb);
        // 前两个参数是你要用来拆分的列数和行数。后两个参数是下面窗口的可见象限，其中第三个参数是右边区域可见的左边列数，第四个参数是下面区域可见的首行
        sheet.createFreezePane(0, sheet.getLastRowNum() + 1, 1, sheet.getLastRowNum() + 1);
    }

    /**
     * @throws
     * @Title: fillHSSFRowData
     * @Description: TODO(自动添加数据)
     * @param: @param wb
     * @param: @param sheet
     * @param: @param dataMap
     * @param: @param lstHeader
     * @return: void
     */
    public static void fillHSSFRowData(HSSFWorkbook wb, HSSFSheet sheet, Map<String, Object> dataMap, List<ExportExcelHeader> lstHeader) {
        HSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);

        Integer colIndex = 0;
        CellStyle cellStyle = getHSSFCellStyle(wb);
        for (ExportExcelHeader header : lstHeader) {
            if (StringUtils.isBlank(header.getKey())) continue;

            setRowStyle(wb, row);
            setHSSFCellStyle(row.createCell(colIndex), cellStyle).setCellValue(String.valueOf(dataMap.get(header.getKey())));
            colIndex++;
        }
    }

    /**
     * @throws
     * @Title: setRowStyle
     * @Description: TODO(行row设置样式)
     * @param: @param row
     * @return: void
     */
    public static void setRowStyle(HSSFWorkbook wb, HSSFRow row) {

        row.setHeight((short) 460);
    }

    /**
     * @param @param  wb
     * @param @param  cell
     * @param @return 设定文件
     * @return HSSFCell    返回类型
     * @throws
     * @Title: setHSSFCellStyle
     * @Description: TODO(单元格cell设置样式)
     */
    public static HSSFCell setHSSFCellStyle(HSSFCell cell, CellStyle titleStyle) {
        cell.setCellStyle(titleStyle);

        return cell;
    }

    /***
     * 获取统一的wb样式
     * @param wb
     * @return
     */
    public static CellStyle getHSSFCellStyle(HSSFWorkbook wb) {
        CellStyle titleStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontHeightInPoints((short) 11);
        font.setFontName("微软雅黑");
        titleStyle.setFont(font);
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);//文字水平居中
        titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//文字垂直居中
        titleStyle.setWrapText(true);//强制自动换行

        //设置边框样式
        titleStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框样式
        titleStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);//下边框样式
        titleStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框样式
        titleStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框样式
        //设置边框颜色
        titleStyle.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index);//上边框颜色
        titleStyle.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index);//下边框颜色
        titleStyle.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index);//左边框颜色
        titleStyle.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index);//右边框颜色

        return titleStyle;
    }

    /**
     * 给合并单元格设置样式边框
     *
     * @param cacheMap
     * @param sheet
     * @param wb
     */
    static void RegionCellRangeAddressStyle(Map<String, CellRangeAddress> cacheMap, HSSFSheet sheet, HSSFWorkbook wb) {
        if (MapUtils.isEmpty(cacheMap)) return;

        for (String cacheKey : cacheMap.keySet()) {
            CellRangeAddress cache = cacheMap.get(cacheKey);
            if (cache == null) continue;

            RegionUtil.setBorderBottom(HSSFCellStyle.BORDER_THIN, cache, sheet, wb); // 下边框边框样式
            RegionUtil.setBottomBorderColor(HSSFColor.GREY_50_PERCENT.index, cache, sheet, wb);// 下边框边框颜色
            RegionUtil.setBorderLeft(HSSFCellStyle.BORDER_THIN, cache, sheet, wb); // 左边框边框样式
            RegionUtil.setLeftBorderColor(HSSFColor.GREY_50_PERCENT.index, cache, sheet, wb);// 左边框边框颜色
            RegionUtil.setBorderRight(HSSFCellStyle.BORDER_THIN, cache, sheet, wb); // 右边框边框样式
            RegionUtil.setRightBorderColor(HSSFColor.GREY_50_PERCENT.index, cache, sheet, wb);// 右边框边框颜色
            RegionUtil.setBorderTop(HSSFCellStyle.BORDER_THIN, cache, sheet, wb); // 上边框边框样式
            RegionUtil.setTopBorderColor(HSSFColor.GREY_50_PERCENT.index, cache, sheet, wb);// 上边框边框颜色
        }
    }
}

@Data
class ExportExcelHeader {

    //id主键
    private String id;

    //字段提取关键字
    private String key;

    //excel表头显示名称
    private String text;

    //父节点
    private String parent;

    //所属层级
    private Integer level;

    //所占colnum 列数
    private Integer colspan;

    //所占rownum 行数
    private Integer rowspan;

    public ExportExcelHeader() {
        super();
    }

    public ExportExcelHeader(String id, String key, String text, String parent, Integer level, Integer colspan,
                             Integer rowspan) {
        super();
        this.id = id;
        this.key = key;
        this.text = text;
        this.parent = parent;
        this.level = level;
        this.colspan = colspan;
        this.rowspan = rowspan;
    }
}
