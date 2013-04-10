package euler.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import euler.exception.EulerException;
import euler.exception.EulerException.CodeError;

public class FileUtils {

	public static int getFileLength(String fileName) throws EulerException {
		try (LineNumberReader reader = new LineNumberReader(new FileReader(
				fileName));) {
			reader.skip(Long.MAX_VALUE);
			return reader.getLineNumber();
		} catch (FileNotFoundException e) {
			throw new EulerException(CodeError.FILE_NOT_FOUND, fileName);
		} catch (IOException e) {
			throw new EulerException(CodeError.ERROR_READING_FILE, fileName);
		}
	}

}
