package com.my.ssm.readexcel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.my.ssm.core.util.DateUtil;
import com.my.ssm.core.util.PConst;
import com.my.ssm.core.util.ToolsUtil;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 根据excel生成sql脚本
 * @ClassName:  GeneratorSqlByExcel   
 * @Desc:      
 * 
 * @author: WJ
 * @date:   2019年4月17日 上午11:39:52   
 *
 */
public class GeneratorSqlByExcel {
    /** 当前项目的根目录 */
    private static String path = System.getProperty("user.dir");
    private static String ID = "ID";
    private static String ACTIVE_FLAG = "ACTIVE_FLAG";
    private static String CREATED_BY = "CREATED_BY";
    private static String CREATED_DATE = "CREATED_DATE";
    private static String MODIFIED_BY = "MODIFIED_BY";
    private static String MODIFIED_DATE = "MODIFIED_DATE";
    private static String SAASID = "SAASID";

    public static void main(String[] args) {
        // excel地址
        String sourceFile = "G:\\Work\\SL WMS\\文档\\表结构设计\\SL_表结构设计.xls";
        getDataFromExcel(sourceFile, "销售退货清单表");
        System.out.println("----------------------创建完成--------------------");
    }

    /**
     * 根据excel地址获取其中内容
     * 
     * @param sourceFile
     * 
     * @author WJ
     * @remark 方法初始化
     * @create 2018-11-20 下午5:44:03
     */
    private static void getDataFromExcel(String sourceFile, String sheetName) {
        // 存储生成的sql文件地址
        String savepath = path + File.separator + "target" + File.separator + "generate-sql";
        isDirExits(savepath);

        // 建立一个输出流，用于保存文件
        PrintWriter pw = null;
        PrintWriter pwx = null;
        
        try {
            Workbook book = Workbook.getWorkbook(new File(sourceFile));

            // 0代表第一个工作表对象
            Sheet sheet = book.getSheet(sheetName);
            String tableName = sheet.getCell(1, 0).getContents().trim();
            String pdate = DateUtil.getDate();
            String fileName = pdate + "_CREATE_TABLE_" + tableName;

            //sql脚本地址 若存在则覆盖
            pw = new PrintWriter(new File(savepath + File.separator + fileName + ".sql"));
            pwx = new PrintWriter(new File(savepath + File.separator + fileName + ".txt"));

            //创建sql脚本
            createFile(pw, sheet, savepath, tableName);
            createXml(pwx, sheet);
            
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            pw.close();
            pwx.close();
        }

    }

    private static void createFile(PrintWriter pw, Sheet sheet, String savepath, String tableName) {
        String tableDescr = sheet.getCell(0, 0).getContents().trim();
        // 行
        int rows = sheet.getRows();
        //列
        // int cols =sheet.getColumns();

        //开始写入
        pw.println("-- // CREATE TABLE " + "CREATE_TABLE_" + tableName + "");
        pw.println("-- Migration SQL that makes the change goes here.");
        pw.println("CREATE TABLE " + tableName + "(");

        // 表结构
        for (int i = 2; i < rows; i++) {
            String line = "";
            line = appendTableField(sheet, i, line);
            pw.println(line);
        }
        pw.println("    PRIMARY KEY (ID)");
        pw.println(");");
        pw.println();

        // 表索引
        pw.println("-- Set Remark");
        pw.println("CREATE UNIQUE INDEX " + tableName + "_INDEX1 ON " + tableName + "();\r\n");

        // 表注释
        pw.println("-- Create Index");
        pw.println("EXEC sp_addextendedproperty N'MS_Description', N'" + tableDescr + "', N'user', N'dbo', N'table', N'"
                + tableName + "', NULL, NULL;");
        String descr = "EXEC sp_addextendedproperty N'MS_Description', N'%s', N'user', N'dbo', N'table', N'%s', N'column', N'%s';";
        for (int i = 2; i < rows; i++) {
            String line = "";
            String cellName = sheet.getCell(1, i).getContents();
            String content = "";
            if (!ToolsUtil.isNull(cellName)) {
                content = sheet.getCell(8, i).getContents();
                line = String.format(descr, content, tableName, cellName);
            }
            pw.println(line);
        }

        // 删除表及索引
        pw.println("\n");
        pw.println("-- //@UNDO");
        pw.println("-- SQL to undo the change goes here.");
        pw.println("DROP INDEX " + tableName + "." + tableName + "_INDEX1;");
        pw.println("DROP TABLE " + tableName + ";");
    }

    /**
	 * 仅生成columnOverride
	 * 
	 * @param pw
	 * @param sheet
	 *
	 * @author WJ
	 * @remark 方法初始化
	 * @create 2018年11月26日 下午3:25:48
	 *
	 */
	private static void createXml(PrintWriter pw, Sheet sheet) {
		// 行
		int rows = sheet.getRows();
		String line = "";

		// 开始写入
		for (int i = 2; i < rows; i++) {
			String xml = "<columnOverride column=\"%s\" javaType=\"%s\" />";
			line = appendXmlField(sheet, i, xml);
			if (!ToolsUtil.isNull(line)) {
				pw.println(line);
			}
		}

	}
    
    /**
     * 判断文件夹是否存在,不存在则新建
     * 
     * @param path
     * 
     * @author WJ
     * @remark 方法初始化
     * @create 2018-11-20 下午4:17:19
     */
    private static void isDirExits(String path) {
        File dir = new File(path);
        if (!dir.getParentFile().exists()) {
            dir.getParentFile().mkdir();
        }
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();
        }
    }

    /**
     * 自动补齐空格(默认25个字符，不足则用空格补充)
     * 
     * @param str
     * @return
     * 
     * @author WJ
     * @remark 方法初始化
     * @create 2018-11-20 下午5:27:33
     */
    public static String appentBlank(String str) {
    	StringBuilder stringBuilder = new StringBuilder(str);
    	try {
        	// 字符长度
            int length = 25; 
            int strLen = 0;
            // 计算原字符串所占长度,规定中文占两个,其他占一个
            for (int i = 0; i < str.length(); i++) {
                if (isChinese(str.charAt(i))) {
                    strLen = strLen + 2;
                } else {
                    strLen = strLen + 1;
                }
            }
            if (strLen >= length) {
            	stringBuilder.append("   ");
                return stringBuilder.toString();
            }
            // 计算所需补充空格长度
            int remain = length - strLen;
            for (int i = 0; i < remain; i++) {
            	stringBuilder.append(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    /**
     * 拼接表结构
     * 
     * @param sheet 
     * @param i     第几行
     * @param line  存储需要拼写的字段
     * @return
     *
     * @author WJ
     * @remark 方法初始化
     * @create 2018-11-20 下午5:56:55
     */
    private static String appendTableField(Sheet sheet, int i, String line) {
        // 前面代表列数，后面代表行数
        String cellName = sheet.getCell(1, i).getContents();
        String type = "";
        String length = "";
        String primay = "";
        String decimals = "";
        if (!ToolsUtil.isNull(cellName)) {
            type = sheet.getCell(2, i).getContents();
            length = sheet.getCell(3, i).getContents();
            primay = sheet.getCell(5, i).getContents();
            decimals = sheet.getCell(4, i).getContents();
            
            line = "	";
            // 补齐空格
            line += appentBlank(cellName);

            boolean falg = PConst.DECIMAL.equals(type) || PConst.NUMBER.equals(type);
            if (!ToolsUtil.isNull(type) && PConst.VARCHAR.equals(type)) {
                line += "NVARCHAR(" + length + ")";
            } else if (!ToolsUtil.isNull(type) && falg) {
                line += "DECIMAL(" + length + "," + decimals + ")";
            } else {
                line += type;
            }
            if (ID.equals(cellName)) {
                line += " IDENTITY(1,1)";
            }
            if (!ToolsUtil.isNull(primay) && PConst.BOOLEAN_Y.equals(primay)) {
                line += " NOT NULL";
            }
            if (ACTIVE_FLAG.equals(cellName)) {
            	line += " NOT NULL DEFAULT 'Y'";
            }
            if (CREATED_BY.equals(cellName) || CREATED_DATE.equals(cellName) || MODIFIED_BY.equals(cellName) || MODIFIED_DATE.equals(cellName)) {
            	line += " NOT NULL";
            }
            if (SAASID.equals(cellName)) {
            	line += " NOT NULL DEFAULT '0'";
            }
            
            line += ",";
        }
        return line;
    }

    /**
	 * 拼接xml
	 * 
	 * @param sheet
	 * @param i
	 * @param line
	 * @return
	 *
	 * @author WJ
	 * @remark 方法初始化
	 * @create 2018年11月26日 下午3:27:36
	 *
	 */
	private static String appendXmlField(Sheet sheet, int i, String line) {
		String cellName = sheet.getCell(1, i).getContents();
		String type = "";
		if (!ToolsUtil.isNull(cellName)) {
			type = sheet.getCell(2, i).getContents();
			if (!ToolsUtil.isNull(type)) {
				switch (type) {
				case "BIGINT":
					line = String.format(line, cellName, "java.lang.Long");
					break;
				case "INT":
					line = String.format(line, cellName, "java.lang.Long");
					break;
				case "NUMBER":
					line = String.format(line, cellName, "DECIMAL");
					break;
				case "DECIMAL":
					line = String.format(line, cellName, "DECIMAL");
					break;
				case "DATETIME":
					line = String.format(line, cellName, "TIMESTAMP");
					break;
				default:
					line = "";
					break;
				}
			}
		} else {
			line = "";
		}

		return line;
	}
    
    /**
     * 根据Unicode编码完美的判断中文汉字和符号
     * 
     * @Title: isChinese    
     * @Desc:  
     * @param: @param c
     * @param: @return      
     * @return: boolean      
     * @throws 
     *  
     * @author: WJ
     * @date:   2019年4月17日 上午11:55:47
     */
    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }

}
