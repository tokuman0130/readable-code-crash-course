package readablecode.week4;

import java.util.List;
import java.util.Objects;

import com.google.common.base.Strings;

public class MarkdownTableUtils {

    // TODO1 : find more duplicated codes and extract them and refactor them.
    // hint1. logic of creating separator row and empty row are same except " "
    // or
    // "-"
    // hint2. logic of creating header caption row and other has difference
    //
    // idea1. give up for make all creating row logic into one method and create
    // two method for each
    // idea2. make all creating row logic into one and use selector argument
    // such as
    // idea3. use adapter method
    // 1. use createRow which is existed in this class to replace your the code
    // for header caption row
    // 2. create adapter method for separator row and empty row in order to use
    // createRow

    /**
     * Returns the string of table which has empty rows as Markdown table
     * syntax.
     * length of captions for separator cell and empty cell is same with their
     * header captions
     *
     *
     * @param headerRowCaptions
     *            the captions for header row
     * @param emptyRowCount
     *            the number of empty rows.
     * @return the string of table which has empty rows as Markdown table
     * @throws NullPointerException
     *             if headerRowCaptions is null
     * @throws IllegalArgumentException
     *             if headerRowCaptions is empty
     * @throws IllegalArgumentException
     *             if emptyRowCount is less than 1
     */
    private static final String VERTICALLINE = "|";
    private static final String HORIZONTALLINE = "-";
    private static final String SPACE = " ";

    public static String createEmptyTable(List<String> headerRowCaptions, int emptyRowCount) {
        Objects.requireNonNull(headerRowCaptions, "headerCaptions must not be null");
        if (headerRowCaptions.isEmpty()) {
            throw new IllegalArgumentException("headerCaptions must have one more elements");
        }
        if (emptyRowCount < 1) {
            throw new IllegalArgumentException("emptyRowCount must be greater than or equal to 1");
        }

        String headerRow = createHeaderRow(headerRowCaptions);
        String separatorRow = createRow(headerRowCaptions, HORIZONTALLINE);
        String emptyRows = Strings.repeat(createRow(headerRowCaptions, SPACE), emptyRowCount);

        return headerRow + separatorRow + emptyRows;

    }

    private static String createHeaderRow(List<String> headerRowCaptions) {
        StringBuilder markdownHeader = new StringBuilder();
        for (String headerWord : headerRowCaptions) {
            markdownHeader.append(VERTICALLINE);
            markdownHeader.append(headerWord);
        }
        markdownHeader.append(VERTICALLINE);
        markdownHeader.append(System.lineSeparator());
        return markdownHeader.toString();
    }

    private static String createRow(List<String> headerRowCaptions, String repeatedChar) {
        StringBuilder markdownRow = new StringBuilder();
        for (String headerWord : headerRowCaptions) {
            markdownRow.append(VERTICALLINE);
            markdownRow.append(Strings.repeat(repeatedChar, headerWord.length()));
        }
        markdownRow.append(VERTICALLINE);
        markdownRow.append(System.lineSeparator());
        return markdownRow.toString();
    }
}
