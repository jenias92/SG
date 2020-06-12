import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportFromExcel {

	private String elderDbFilePath = "C:/test/aaaaa.txt";

	public ImportFromExcel() {

	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();

		case NUMERIC:
			return cell.getNumericCellValue();

		}

		return null;
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
				}

			}
			newElders.add(elder);
		}

		workbook.close();
		inputStream.close();

		return newElders;
	}

	public void InsertIntoDB(List<Elders> ElderList) throws IOException {
		boolean elderExist = false;
		File elderDbFile = new File(elderDbFilePath);
		if (!elderDbFile.exists()) {
			System.out.println("Going to create the file as its not exist");
			elderDbFile.createNewFile();
		} else {
			FileWriter fileWritter = new FileWriter(elderDbFile, true);
			BufferedWriter buffer = new BufferedWriter(fileWritter);
			Scanner fileReader = new Scanner(elderDbFile);
			for (int i = 0; i < ElderList.size(); i++) {
				String id = ElderList.get(i).getId();
				if (i == 0) {
					continue;
				}
				elderExist = this.checkIfExist(id, fileReader);
				if (elderExist) {
					System.out.printf("Skip ID: %s as it already in DB\n", id);
					continue;
				} else {
					System.out.printf("Importing ID: %s\n", id);
					String single = Arrays.toString(ElderList.get(i).fullData());
					buffer.write("\n" + single);
				}
			}
			buffer.close();
			System.out.println("Import Completed");
		}

	}

	private boolean checkIfExist(String id, Scanner file) {
		while (file.hasNextLine()) {
			String data = file.nextLine();
			data = data.replace("[", "");
			data = data.replace("]", "");
			data = data.replace(", ", ",");
			String[] split = data.split(",");
			if (id.equals(split[0])) {
				return true;
			}
		}
		return false;
	}
}
