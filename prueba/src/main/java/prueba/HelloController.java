package prueba;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(value = "/zip", produces = "application/zip")
	public byte[] zipFiles() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
		ZipOutputStream zipOutputStream = new ZipOutputStream(bufferedOutputStream);
		
		File file = new File("C:\\gua\\userguide.pdf");
		byte[] array = FileUtils.readFileToByteArray(file);

		zipOutputStream.putNextEntry(new ZipEntry("andres.pdf"));
		zipOutputStream.write(array);
		zipOutputStream.closeEntry();

		if (zipOutputStream != null) {
			zipOutputStream.finish();
			zipOutputStream.flush();
			IOUtils.closeQuietly(zipOutputStream);
		}
		IOUtils.closeQuietly(bufferedOutputStream);
		IOUtils.closeQuietly(byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}

}
