import java.io.IOException;
import java.util.List;

public class ImportFiles {

	public static void main(String[] args) throws IOException {
		String excelFilePath = "C:/test/elders.xlsx";
		ImportFromExcel reader = new ImportFromExcel();
		List<Elders> NewEldersList = reader.readBooksFromExcelFile(excelFilePath);
		reader.InsertIntoDB(NewEldersList);
	}
}