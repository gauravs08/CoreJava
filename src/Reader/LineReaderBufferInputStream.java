package Reader;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 *  Comparing Execution time of BufferInputReader Vs LineNumberReader Vs Stream
 *  o/p > Effeciency of BufferInputReader to LineNumberReader is around :: 200%

 *  
 */
public class LineReaderBufferInputStream {

	public static void main(String args[]) throws IOException {
		//LineReaderBufferInputStream
		LineReaderBufferInputStream lr = new LineReaderBufferInputStream();
		long startTime = System.nanoTime();

		int count = lr.countLinesUsingLineNumberReader("D://out.txt");
		
		long endTime = System.nanoTime();
		long c1 = (endTime - startTime);
		System.out.println(count + " LineReaderBufferInputStream Time taken:: " + c1);

		startTime = System.nanoTime();
		
		count = countLinesByBufferIpStream("D://out.txt");
		
		endTime = System.nanoTime();
		long c2 = (endTime - startTime);
		System.out.println(count + " BufferedInputStream Time taken:: " + c2);

		System.out.println("Effeciency of BufferInputReader to LineNumberReader is around :: " + (c1) / c2 * 100 + "%");
		
		// Java8 line by line reader
		//read file into stream, try-with-resources
		startTime = System.nanoTime();
		long cn = countLinesUsingStream("D://out.txt");
		endTime = System.nanoTime();

		System.out.println(cn +" Using Stream :: " + (endTime - startTime));
				
	}

	public int countLinesUsingLineNumberReader(String filename) throws IOException {
		LineNumberReader reader = new LineNumberReader(new FileReader(filename));
		int cnt = 0;
		String lineRead = "";
		while ((lineRead = reader.readLine()) != null) {
			//if you need to do anything with lineReader.
		}

		cnt = reader.getLineNumber();
		reader.close();
		return cnt;
	}

	public static int countLinesByBufferIpStream(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		try {
			byte[] c = new byte[1024];
			int count = 1;
			int readChars = 0;
			boolean empty = true;
			while ((readChars = is.read(c)) != -1) {
				empty = false;
				for (int i = 0; i < readChars; ++i) {
					if (c[i] == '\n') {
						++count;
					}
				}
			}
			return (count == 0 && !empty) ? 1 : count;
		} finally {
			is.close();
		}
	}
	
	public static long countLinesUsingStream(String fileName) throws IOException{
		try (Stream<String> streamReader = Files.lines(Paths.get("D://out.txt"))) {

			return streamReader.count();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
