package utilities;



	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.CellStyle;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.FillPatternType;
	import org.apache.poi.ss.usermodel.IndexedColors;
	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelUtility {
		
		public   FileInputStream fi;
		private  Object xlsheet;
		public  FileOutputStream fo;
		public  XSSFWorkbook wb;
		public  XSSFSheet ws;
		public  XSSFRow row;
		public  XSSFCell cell;
		public  CellStyle Style;
       String path;
       
		public ExcelUtility(String path)
		{
			this.path=path;
			
		}
		
		public  int getRowCount(String sheetName) throws IOException   {
			
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(sheetName);
	        int rowcount=ws.getLastRowNum();
	        wb.close();
	        fi.close();
	        return rowcount;
	        
	        }
		
	public static int getCellCount(String sheetName,int rownum) throws IOException   {
			
			fi=new FileInputStream(path);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(sheetName);
			row=ws.getRow(rownum);
	        int cellcount=row.getLastCellNum();
	        wb.close();
	        fi.close();
	        return cellcount;
	        
	        }
		
	public static String getCellData(String sheetName,int rownum,int colnum) throws IOException   {
		
		fi=new FileInputStream(path);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(sheetName);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
	    
		DataFormatter formatter=new DataFormatter();
		
		String data;
		try
		{
			
		
				data=formatter.formatCellValue(cell);
			
		}
	    catch(Exception e) {
	    	data="";
	    }
		wb.close();
		fi.close();
		return data;
	    }
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException   {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
	    cell.setCellValue(data);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
		fi.close();
		fo.close();

	    }
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException   {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		Style=wb.createCellStyle();
		Style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    cell.setCellStyle(Style);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
		fi.close();
		fo.close();
	    }
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException   {
		
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		Style=wb.createCellStyle();
		Style.setFillForegroundColor(IndexedColors.RED.getIndex());
		Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	    cell.setCellStyle(Style);
	    fo=new FileOutputStream(xlfile);
	    wb.write(fo);
	    wb.close();
		fi.close();
		fo.close();
	}
	}
}
