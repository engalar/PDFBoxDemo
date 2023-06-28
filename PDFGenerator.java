import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.File;
import java.io.IOException;

public class PDFGenerator {
  public static void main(String[] args) {
    try {
      // 创建一个新的PDF文档
      PDDocument document = new PDDocument();

      // 创建页面
      PDPage page = new PDPage();

      // 添加页面到文档
      document.addPage(page);

      // 创建页面内容流
      PDPageContentStream contentStream = new PDPageContentStream(document, page);

      // 导入自定义字体
      PDType0Font font = PDType0Font.load(document, new File("C://Windows/Fonts/simfang.ttf"));

      // 设置字体和字号
      contentStream.setFont(font, 12);

      // 在页面上添加文本
      contentStream.beginText();
      contentStream.newLineAtOffset(100, 700);
      contentStream.showText("hello world!你好世界！");
      // contentStream.showText("hello world!");
      contentStream.endText();

      // 关闭页面内容流
      contentStream.close();

      // 保存PDF文档到文件
      document.save("example.pdf");

      // 关闭PDF文档
      document.close();

      System.out.println("PDF generated successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
