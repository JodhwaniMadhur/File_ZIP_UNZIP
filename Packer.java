import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class Packer
{
 FileOutputStream outstream = null;

 String ValidExt[] = {".txt",".c",".java",".cpp"};

 public Packer(String src, String Dest) throws Exception
 {
 String Magic = "Madhur123456";
 byte arr[] = Magic.getBytes();
 outstream = new FileOutputStream(Dest);
 outstream.write(arr, 0, arr.length);
 System.setProperty("user.dir",src);
 listAllFiles(src);
 }

 public void listAllFiles(String path)
 {
 try
 (Stream<Path> paths = Files.walk(Paths.get(path)))
 {
 paths.forEach(filePath ->
 {
 if (Files.isRegularFile(filePath))
 {
 try
 {
 String name = filePath.getFileName().toString();
 String ext = name.substring(name.lastIndexOf("."));

 List<String> list = Arrays.asList(ValidExt);

 if(list.contains(ext))
 {
 File file=new File(filePath.getFileName().toString());

 packfile(file.getAbsolutePath());
 }
 }
 catch (Exception e)
 {
 System.out.println(e);
 }
 }
 });
 }
 catch (IOException e)
 {
 System.out.println(e);
 }
 }

 public void packfile(String filePath)
 {
 FileInputStream instream = null;
 try
 {
 byte[] buffer = new byte[1024];

 int length;

 byte temp[] = new byte[100];

 File fobj = new File(filePath);
 String Header = filePath+" "+fobj.length();

 for (int i = Header.length(); i < 100; i++)
 Header += " ";
 temp = Header.getBytes();
 instream = new FileInputStream(filePath);

 outstream.write(temp, 0, temp.length);

 while ((length = instream.read(buffer)) > 0)
 {
 outstream.write(buffer, 0, length);
 }

 instream.close();
 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 }
}