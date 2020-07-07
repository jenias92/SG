package ImportElder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Elders.Elders;

public class ImportFromExcel {

	private String userExcelFile;

	public ImportFromExcel() {

	}

	public String getUserExcelFile() {
		return userExcelFile;
	}

	public void setUserExcelFile(String userExcelFile) {
		this.userExcelFile = userExcelFile;
	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();

		case NUMERIC:
			return cell.getNumericCellValue();

		default:
			return null;

		}
	}

	public List<Elders> readBooksFromExcelFile(String excelFilePath) throws IOException {
		List<Elders> newElders = new ArrayList<>();
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		DataFormatter formatter = new DataFormatter();
		Sheet firstSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = firstSheet.iterator();

		while (iterator.hasNext()) {
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();
			Elders elder = new Elders();

			while (cellIterator.hasNext()) {
				Cell nextCell = cellIterator.next();
				int columnIndex = nextCell.getColumnIndex();

				switch (columnIndex) {
				case 0:
					String id = formatter.formatCellValue(nextCell);
					elder.setId(id);
					break;
				case 1:
					elder.setFirstName((String) getCellValue(nextCell));
					break;
				case 2:
					elder.setLastName((String) getCellValue(nextCell));
					break;
				case 3:
					elder.setCity((String) getCellValue(nextCell));
					break;
				case 4:
					elder.setAddress((String) getCellValue(nextCell));
					break;
				case 5:
					String BirthDay = formatter.formatCellValue(nextCell);
					elder.setBirthDay(BirthDay);
					break;
				case 6:
					elder.setLanguages((String) getCellValue(nextCell));
					break;
				case 7:
					elder.setHobbies((String) getCellValue(nextCell));
					break;
				case 8:
					String phone = formatter.formatCellValue(nextCell);
					elder.setTelephone(phone);
					break;
				}

			}
			newElders.add(elder);
		}

		workbook.close();
		inputStream.close();

		return newElders;
	}

}
