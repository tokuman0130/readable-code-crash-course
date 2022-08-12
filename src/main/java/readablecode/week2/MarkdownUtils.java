package readablecode.week2;

import java.util.List;

public class MarkdownUtils {
    // TODO1 : use early return:Readable code 7.5, 7.7 and remove the 1 nest(you
    // might need to change if condition and if condition is complicated such as
    // if(!(...)) please refactor it after you read 7.2)
    // ネストの解除しないとみたいだけどわからない (append(|)のところメソッド化出来たら理想だけど) これやったら終わり
    // * you do not need to improve exception handling

    // TODO2 : add line break and comment for each block/paragraph after you
    // read
    // Readable code 4.7

    // TODO3 : re-name the variables after you read Readable code 2.2 2.7, 3.8

    // TODO4 : re-name method as it is after you read Readable code 3.0, 3.9

    // TODO5 : remove the unnecessary variable after you read Readable code 9.1

    /**
     * カラム名以外空のテーブルを返す
     *
     * @param words
     * @param rowCount
     * @return カラム名以外空のテーブル
     * @throws IllegalArgumentException
     */
    public static String createEmptyTable(List<String> words, int rowCount) throws IllegalArgumentException {

        if (words == null || words.isEmpty() || rowCount <= 0) {
            throw new IllegalArgumentException("");
        }
        StringBuilder table = new StringBuilder();

        // ｜でwordをはさむ形でListを結合（"|e|e|…e|"の形になる）←これいらない？
        for (String word : words) {
            table.append("|");
            table.append(word);
        }
        table.append("|");
        table.append(System.lineSeparator());

        // -------------------"|e|eee|…e|"
        // 2行目および横線追加"|-|---|…-|"にしてる←これいらない？
        for (String word : words) {
            table.append("|");
            for (int i = 0; i < word.length(); i++) {
                table.append("-");
            }
        }
        table.append("|");
        table.append(System.lineSeparator());

        // 文字数で区切られた空白行をrouCount分作成←これいらない？
        for (int i = 0; i < rowCount; i++) {
            for (String word : words) {
                table.append("|");
                for (int j = 0; j < word.length(); j++) {
                    table.append(" ");
                }
            }
            table.append("|");
            table.append(System.lineSeparator());

        }

        return table.toString();

    }

}
