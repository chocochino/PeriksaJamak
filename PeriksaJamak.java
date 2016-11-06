import java.io.*;

public class PeriksaJamak {

	private PeriksaJamak(String address) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			br = new BufferedReader(new FileReader(address));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				if (line.startsWith("#:"))
					sb = new StringBuilder();
				sb.append(line+"\n");
				if (line.startsWith("msgstr") && line.matches(".*\\b(s)\\b.*"))
					System.out.println(">> Kesalahan! Seharusnya target terjemahan tidak memiliki bentuk kata jamak (s)! <<\n"+sb.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			new PeriksaJamak(args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Dokumen tidak ditemukan.\n");
		}
	}
}
