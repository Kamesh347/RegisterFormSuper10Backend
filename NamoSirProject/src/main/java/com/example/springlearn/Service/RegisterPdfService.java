package com.example.springlearn.Service;

import com.example.springlearn.Entity.RegisterForm;
import com.example.springlearn.Repo.RegisterFormRepository;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class RegisterPdfService {

    private final RegisterFormRepository repository;

    public RegisterPdfService(RegisterFormRepository repository) {
        this.repository = repository;
    }

    // ===============================
    // DOWNLOAD ALL LETTERS AS PDF
    // ===============================
    public byte[] downloadAllAsPdf() throws IOException {

        List<RegisterForm> forms = repository.findAll();

        try (PDDocument document = new PDDocument();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            for (RegisterForm form : forms) {
                PDPage page = new PDPage(PDRectangle.A4);
                document.addPage(page);

                try (PDPageContentStream cs =
                             new PDPageContentStream(document, page)) {

                    float marginX = 50;
                    float y = 780;
                    float leading = 16;

                    PDType1Font bold =
                            new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD);
                    PDType1Font normal =
                            new PDType1Font(Standard14Fonts.FontName.HELVETICA);

                    // ===============================
                    // Sender Details
                    // ===============================
                    y = writeLine(cs, bold, 11, marginX, y, form.getSenderName());
                    y = writeLine(cs, normal, 11, marginX, y, form.getSenderAddress());
                    y = writeLine(cs, normal, 11, marginX, y,
                            form.getSenderCity() + ", " +
                                    form.getSenderState() + " - " +
                                    form.getSenderZip());

                    y -= leading;
                    y = writeLine(cs, normal, 11, marginX, y, form.getSenderDate());

                    // ===============================
                    // Receiver Details
                    // ===============================
                    y -= leading * 2;
                    y = writeLine(cs, bold, 11, marginX, y, form.getReceiverName());
                    y = writeLine(cs, normal, 11, marginX, y, form.getReceiverDesignation());
                    y = writeLine(cs, normal, 11, marginX, y, form.getOrganizationName());
                    y = writeLine(cs, normal, 11, marginX, y, form.getOrganizationAddress());

                    // ===============================
                    // Subject
                    // ===============================
                    y -= leading * 2;
                    y = writeLine(cs, bold, 11, marginX, y,
                            "Subject: " + form.getSubject());

                    // ===============================
                    // Salutation
                    // ===============================
                    y -= leading * 2;
                    y = writeLine(cs, normal, 11, marginX, y,
                            form.getSalutation());

                    // ===============================
                    // Opening Paragraph
                    // ===============================
                    y -= leading;
                    y = writeParagraph(cs, normal, 11, marginX, y,
                            form.getOpeningParagraph());

                    // ===============================
                    // Body Paragraph
                    // ===============================
                    y -= leading;
                    y = writeParagraph(cs, normal, 11, marginX, y,
                            form.getBodyParagraph());

                    // ===============================
                    // Closing Paragraph
                    // ===============================
                    y -= leading;
                    y = writeParagraph(cs, normal, 11, marginX, y,
                            form.getClosingParagraph());

                    // ===============================
                    // Sign Off
                    // ===============================
                    y -= leading * 2;
                    y = writeLine(cs, normal, 11, marginX, y, form.getSignOff());

                    y -= leading;
                    y = writeLine(cs, bold, 11, marginX, y, form.getSenderName());
                    y = writeLine(cs, normal, 11, marginX, y,
                            form.getSenderDesignation());
                    y = writeLine(cs, normal, 11, marginX, y,
                            "Contact: " + form.getSenderContactNumber());
                    writeLine(cs, normal, 11, marginX, y - leading,
                            "Email: " + form.getSenderEmail());
                }
            }

            document.save(out);
            return out.toByteArray();
        }
    }

    // ===============================
    // Helper Methods
    // ===============================
    private float writeLine(PDPageContentStream cs, PDType1Font font,
                            int size, float x, float y, String text)
            throws IOException {

        cs.beginText();
        cs.setFont(font, size);
        cs.newLineAtOffset(x, y);
        cs.showText(text != null ? text : "");
        cs.endText();
        return y - 16;
    }

    private float writeParagraph(PDPageContentStream cs, PDType1Font font,
                                 int size, float x, float y, String text)
            throws IOException {

        if (text == null) return y;

        float width = 500;
        String[] words = text.split(" ");
        StringBuilder line = new StringBuilder();

        for (String word : words) {
            String testLine = line + word + " ";
            float textWidth =
                    font.getStringWidth(testLine) / 1000 * size;

            if (textWidth > width) {
                y = writeLine(cs, font, size, x, y, line.toString());
                line = new StringBuilder(word).append(" ");
            } else {
                line.append(word).append(" ");
            }
        }

        if (!line.isEmpty()) {
            y = writeLine(cs, font, size, x, y, line.toString());
        }
        return y;
    }
}
